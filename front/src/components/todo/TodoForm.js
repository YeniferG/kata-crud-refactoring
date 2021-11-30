import React, { useContext, useRef, useState } from 'react';
import HOST_API from '../../constants';
import { Store } from '../../store/store';

const TodoForm = ({ listId }) => {

    const { dispatch, state } = useContext(Store);

    const [name, setName] = useState('');
    const formRef = useRef(null);

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
            .then(todo => dispatch({ type: "add-subtodo", payload: todo }))
        formRef.current.reset()
    }

    const handleUpdateSubTodo = (e) => {
        e.preventDefault()
        const request = {
            ...state.toDo,
            name
        }
        fetch(`${HOST_API}/todo`, {
            method: 'PUT',
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(todoUpdated => {
                dispatch({ type: 'update-subtodo', 'payload': todoUpdated })
            })
        formRef.current.reset()
    }

    const handleChangeInput = (e) => setName(e.target.value)

    return (
        <form ref={formRef}>
            <input
                type="text"
                defaultValue={state.toDo.name}
                onChange={handleChangeInput}
                placeholder="Nombre de la tarea" />
            <button onClick={handleAddSubTodo}>Crear</button>
            <button onClick={handleUpdateSubTodo}>Actualizar</button>
        </form>
    )
}

export default TodoForm; 