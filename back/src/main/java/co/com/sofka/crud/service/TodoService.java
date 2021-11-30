package co.com.sofka.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.crud.converter.TodoConverter;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.model.ListTodo;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.ListTodoRepository;

@Service
public class TodoService {

    @Autowired
    ListTodoRepository listTodoRepository;

    public TodoDTO save(TodoDTO todoDTO) {
        TodoConverter converter = new TodoConverter();
        Todo todo = converter.fromDTO(todoDTO);
        ListTodo listTodoById = listTodoRepository.findById(todoDTO.getListTodoId())
                .orElseThrow(() -> new RuntimeException("ID NOT FOUND"));
        listTodoById.getListTodo().add(todo);

        ListTodo newListTodo = listTodoRepository.save(listTodoById);

        Integer lastTodo = (newListTodo.getListTodo().size() - 1);

        Todo newTodo = newListTodo.getListTodo()
                .get(lastTodo);
        TodoDTO toTodoDTO = converter.fromModel(newTodo);
        toTodoDTO.setListTodoId(newListTodo.getId());

        return toTodoDTO;
    }

    public Boolean delete(Long idList, Long idTodo) {

        ListTodo listTodo = listTodoRepository.findById(idList)
                .orElseThrow(() -> new RuntimeException("List id not found"));

        Todo todo = listTodo.getListTodo()
                .stream()
                .filter(t -> t.getId().equals(idTodo))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Todo id not found"));

        Boolean isDeleted = listTodo.getListTodo().remove(todo);
        listTodoRepository.save(listTodo);
        return isDeleted;

    }

}
