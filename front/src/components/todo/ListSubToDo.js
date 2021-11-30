import React from 'react';

const ListSubTodo = ({ listSubTodo }) => {
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
                        <td><button>Eliminar</button></td>
                        <td><button>Editar</button></td>
                    </tr>
                })}
            </tbody>
        </table>
    )
}

export default ListSubTodo; 