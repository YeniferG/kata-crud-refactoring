import React, { useReducer, createContext } from 'react';
import ListToDoForm from './components/list-todo/ListToDoForm';
import ListToDo from './components/list-todo/ListToDo';
import StoreProvider from './store/store';

const App = () => (
  <StoreProvider>
    <ListToDoForm />
    <ListToDo />
  </StoreProvider>
)

export default App;