import React, { useContext, useRef, useState } from "react";
import { Store } from '../../store/store';

import HOST_API from '../../constants';

const ListToDoForm = () => {

    const formRef = useRef(null);
    const input = useRef(null);
    const { dispatch, state } = useContext(Store);
    const [name, setName] = useState('');


    const onAdd = (event) => {
        event.preventDefault();

        if (input.current.value === '') {
            alert('Debe ingresar un valor')
            return;
        }

        const request = {
            id: null,
            name,
        };


        fetch(HOST_API + "/list-todo", {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then((todo) => {
                dispatch({ type: "add-item", payload: { ...todo, listTodo: [] } });
                setName('');
                formRef.current.reset();
            });
    }

    const handleName = (e) => setName(e.target.value)

    return <form ref={formRef}>
        <input
            type="text"
            ref={input}
            name="name"
            placeholder="¿Qué piensas hacer hoy?"
            onChange={handleName}></input>
        <button onClick={onAdd}>Crear</button>
    </form>
}

export default ListToDoForm;