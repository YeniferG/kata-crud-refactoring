import React, { useContext, useRef, useState } from 'react';
import HOST_API from '../../constants';
import { Store } from '../../store/store';

const TodoForm = ({ listId }) => {

    const { dispatch, state } = useContext(Store);

    const [name, setName] = useState('');

    const handleAddSubTodo = (e) => {
        e.preventDefault()

        const request = {
            listTodoId: listId,
            name,
            completed: false
        }


        fetch(`${HOST_API}/todo`, {
            method: 'POST',
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(todo => console.log(todo))
    }

    const handleChangeInput = (e) => setName(e.target.value)

    return (
        <form onSubmit={handleAddSubTodo}>
            <input
                type="text"
                onChange={handleChangeInput}
                placeholder="Nombre de la tarea" />
            <button type="submit">Crear</button>
        </form>
    )
}

export default TodoForm; 