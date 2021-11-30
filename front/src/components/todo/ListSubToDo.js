import React, { useContext } from 'react';
import HOST_API from '../../constants';
import { Store } from '../../store/store';

const ListSubTodo = ({ listSubTodo, listId }) => {

    const { dispatch, state } = useContext(Store)

    const handleDelete = (toDoId) => {
        fetch(`${HOST_API}/list-todo/${listId}/todo/${toDoId}`, {
            method: 'DELETE'
        })
            .then(() => dispatch({ type: "delete-subtodo", payload: { listId, toDoId } }))
    }

    return (
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Tarea</td>
                    <td>¿Completado?</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                {listSubTodo && listSubTodo.map((todo) => {
                    return <tr key={todo.id}>
                        <td>{todo.id}</td>
                        <td>{todo.name}</td>
                        <td><input type="checkbox" defaultChecked={todo.completed}></input></td>
                        <td><button onClick={(e) => handleDelete(todo.id)}>Eliminar</button></td>
                        <td><button>Editar</button></td>
                    </tr>
                })}
            </tbody>
        </table>
    )
}
export default ListSubTodo;