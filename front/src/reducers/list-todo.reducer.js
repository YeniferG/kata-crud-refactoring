function reducer(state, action) {

    const { type, payload } = action


    switch (type) {
        case 'update-item':
            const todoUpItem = state.todo;
            const listUpdateEdit = todoUpItem.list.map((item) => {
                if (item.id === action.item.id) {
                    return action.item;
                }
                return item;
            });
            todoUpItem.list = listUpdateEdit;
            todoUpItem.item = {};
            return { ...state, todo: todoUpItem }
        case 'add-subtodo':
            const newListToDo = state.listToDo.map(toDo => {
                if (toDo.id === payload.listTodoId) {
                    const listToUpdate = toDo.listTodo
                    return { ...toDo, listTodo: [...listToUpdate, payload] }
                }
                return toDo
            })
            return { ...state, listToDo: newListToDo }
        case 'delete-item':
            const listUpdate = state.listToDo.filter((todo) => {
                return todo.id !== action.id;
            });
            return { ...state, listToDo: listUpdate }
        case 'update-list':
            return { ...state, listToDo: action.list }
        case 'add-item':
            const list = state.listToDo;
            list.push(payload)
            return { ...state, listToDo: list }
        default:
            return state;
    }
}

export default reducer;