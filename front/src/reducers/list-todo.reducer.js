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
        case 'delete-item':
            const listUpdate = state.listToDo.filter((todo) => {
                return todo.id !== action.id;
            });
            return { ...state, listToDo: listUpdate }
        case 'update-list':
            const todoUpList = state;
            todoUpList.listToDo = action.list;
            return { ...state, todo: todoUpList }
        case 'edit-item':
            const todoUpEdit = state.todo;
            todoUpEdit.item = action.item;
            return { ...state, todo: todoUpEdit }
        case 'add-item':
            const list = state.listToDo;
            list.push(payload)
            return { ...state, listToDo: list }
        default:
            return state;
    }
}

export default reducer; 