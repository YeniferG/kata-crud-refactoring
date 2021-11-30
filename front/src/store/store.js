import React, { createContext, useReducer } from "react";
import reducer from "../reducers/reducer";

const initialState = {
    listToDo: [],
    toDo: {}
};

export const Store = createContext(initialState)

const StoreProvider = ({ children }) => {
    const [state, dispatch] = useReducer(reducer, initialState);
    return <Store.Provider value={{ state, dispatch }}>
        {children}
    </Store.Provider>
}

export default StoreProvider; 