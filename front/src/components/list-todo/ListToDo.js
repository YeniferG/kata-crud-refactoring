import React, { useContext, useEffect } from "react";
import { Store } from "../../store/store";
import ListSubTodo from "../todo/ListSubToDo";

import TodoForm from "../todo/TodoForm";
import HOST_API from '../../constants';

const ListToDo = () => {
    const { dispatch, state } = useContext(Store);

    useEffect(() => {
        fetch(HOST_API + "/list-todo")
            .then(response => response.json())
            .then((list) => {
                const listToDo = list.map(todo => {
                    const listSubTodo = todo.listTodo.map((subToDo) => {
                        return { ...subToDo, listTodoId: todo.id }
                    })
                    return { ...todo, listTodo: listSubTodo }
                });
                dispatch({ type: "update-list", payload: listToDo })
            })
    }, [dispatch]);

    const onDelete = (id) => {
        fetch(`${HOST_API}/list-todo/${id}`, {
            method: "DELETE"
        }).then(() => {
            dispatch({ type: "delete-item", id })
        })
    };

    return <div>
        <table >
            <thead>
                <tr>
                    <td>Lista de tareas</td>
                </tr>
            </thead>
            <tbody>
                {state.listToDo.map((todo) => (
                    <tr key={todo.id} id={todo.id}>
                        <td>
                            <fieldset>
                                <legend>
                                    {todo.name.toUpperCase()}
                                    <button onClick={() => onDelete(todo.id)}>Eliminar</button>
                                </legend>
                                <TodoForm listId={todo.id} todo={todo} />
                                <ListSubTodo listSubTodo={todo.listTodo} listId={todo.id} />
                            </fieldset>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>
}
export default ListToDo;