package co.com.sofka.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.crud.converter.ListToDoConverter;
import co.com.sofka.crud.converter.TodoConverter;
import co.com.sofka.crud.dto.ListTodoDTO;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.model.ListTodo;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.ListTodoRepository;
import co.com.sofka.crud.repository.TodoRepository;

@Service
public class ListTodoService {

    @Autowired
    ListTodoRepository repository;

    @Autowired
    TodoRepository todoRepository;

    public ListTodoDTO save(ListTodoDTO listTodoDTO) {
        ListToDoConverter converter = new ListToDoConverter();
        ListTodo listTodo = converter.fromDTO(listTodoDTO);
        return converter.fromModel(repository.save(listTodo));
    }

    public TodoDTO save(TodoDTO todoDTO) {
        TodoConverter converter = new TodoConverter();
        Todo todo = converter.fromDTO(todoDTO);

        ListTodo listTodoById = repository.findById(todoDTO.getListTodoId())
                .orElseThrow(() -> new RuntimeException("ID NOT FOUND"));
        listTodoById.getListTodo().add(todo);

        ListTodo newListTodo = repository.save(listTodoById);

        Integer lastTodo = (newListTodo.getListTodo().size() - 1);

        Todo newTodo = newListTodo.getListTodo()
                .get(lastTodo);

        TodoDTO toTodoDTO = converter.fromModel(newTodo);
        toTodoDTO.setListTodoId(newListTodo.getId());

        return toTodoDTO;
    }

}
