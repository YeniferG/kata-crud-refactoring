function reducer(state, action) {

    const { type, payload } = action


    switch (type) {
        case 'add-subtodo':
            const newListToDo = state.listToDo.map(toDo => {
                if (toDo.id === payload.listTodoId) {
                    const listToUpdate = toDo.listTodo
                    return { ...toDo, listTodo: [...listToUpdate, payload] }
                }
                return toDo;
            })
            return { ...state, listToDo: newListToDo }
        case 'delete-subtodo':
            const listWithoutSubToDo = state.listToDo.map(toDo => {
                if (toDo.id === payload.listId) {
                    const newListSubToDo = toDo.listTodo.filter(todo => todo.id !== payload.toDoId)
                    return { ...toDo, listTodo: newListSubToDo }
                }
                return toDo;
            })
            return { ...state, listToDo: listWithoutSubToDo }
        case 'edit-subtodo':
            return { ...state, toDo: payload }
        case 'update-subtodo':
            const listUpdated = state.listToDo.map(toDo => {
                if (toDo.id === payload.listTodoId) {
                    const listTodoUpdated = toDo.listTodo.map(subToDo => subToDo.id === payload.id ? payload : subToDo)
                    return { ...toDo, listTodo: listTodoUpdated }
                }
                return toDo
            })
            return { ...state, listToDo: listUpdated, toDo: {} }
        case 'delete-item':
            const listUpdate = state.listToDo.filter((todo) => {
                return todo.id !== action.id;
            });
            return { ...state, listToDo: listUpdate }
        case 'update-list':
            return { ...state, listToDo: payload }
        case 'add-item':
            const list = state.listToDo;
            return { ...state, listToDo: [...list, payload] }
        default:
            return state;
    }
}

export default reducer;