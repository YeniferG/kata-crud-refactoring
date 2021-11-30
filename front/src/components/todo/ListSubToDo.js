import React, { useContext } from 'react';
import { Store } from '../../store/store';
import HOST_API from '../../constants';


const ListSubTodo = ({ listSubTodo, listId }) => {
    const { dispatch, state } = useContext(Store);

    const handleDelete = (toDoId) => {
        fetch(`${HOST_API}/list-todo/${listId}/todo/${toDoId}`, {
            method: 'DELETE'
        })
            .then(() => dispatch({ type: "delete-subtodo", payload: { listId, toDoId } }))
    }

    const handleCompleted = (e, todo) => {

        const request = {
            ...todo,
            listTodoId: listId,
            completed: e.target.checked
        }

        fetch(`${HOST_API}/todo`, {
            method: 'PUT',
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(todoUpdated => dispatch({ type: 'update-subtodo', 'payload': todoUpdated }))
    };

    const handleEdit = (todo) => {
        dispatch({ type: 'edit-subtodo', payload: todo })
    };

    const decorationDone = {
        textDecoration: 'line-through'
    };

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
                    return <tr key={todo.id} style={todo.completed ? decorationDone : {}}>
                        <td>{todo.id}</td>
                        <td>{todo.name}</td>
                        <td>
                            <input
                                onChange={(e) => handleCompleted(e, todo)}
                                type="checkbox"
                                defaultChecked={todo.completed}>
                            </input>
                        </td>
                        <td><button onClick={(e) => handleDelete(todo.id)}>Eliminar</button></td>
                        <td><button onClick={() => handleEdit(todo)}>Editar</button></td>
                    </tr>
                })}
            </tbody>
        </table>
    )
}
export default ListSubTodo;