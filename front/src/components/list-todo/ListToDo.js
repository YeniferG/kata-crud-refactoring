import React, { useContext, useEffect } from "react";
import { Store } from "../../store/store";
import ListSubTodo from "../todo/ListSubToDo";


const HOST_API = "http://localhost:8080/api/v1";

const ListToDo = () => {
    const { dispatch, state } = useContext(Store);

    useEffect(() => {
        fetch(HOST_API + "/todos")
            .then(response => response.json())
            .then((list) => {
                dispatch({ type: "update-list", list })
            })
    }, [dispatch]);


    const onDelete = (id) => {
        fetch(HOST_API + "/" + id + "/todo", {
            method: "DELETE"
        }).then((list) => {
            dispatch({ type: "delete-item", id })
        })
    };

    const onEdit = (todo) => {
        //dispatch({ type: "edit-item", item: todo })
    };

    const onChange = (event, todo) => {
        /*const request = {
          name: todo.name,
          id: todo.id,
          completed: event.target.checked
        };
        fetch(HOST_API + "/todo", {
          method: "PUT",
          body: JSON.stringify(request),
          headers: {
            'Content-Type': 'application/json'
          }
        })
          .then(response => response.json())
          .then((todo) => {
            dispatch({ type: "update-item", item: todo });
          });*/
    };

    const decorationDone = {
        textDecoration: 'line-through'
    };

    return <div>
        <table >
            <thead>
                <tr>
                    <td>Tarea</td>
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
                                {/* <ToDoForm listId={element.id} todo={todo} /> */}
                                <ListSubTodo listSubTodo={todo.listTodo} />
                            </fieldset>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>
}

export default listToDo;