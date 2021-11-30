package co.com.sofka.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.crud.converter.ListToDoConverter;
import co.com.sofka.crud.dto.ListTodoDTO;
import co.com.sofka.crud.model.ListTodo;
import co.com.sofka.crud.repository.ListTodoRepository;

@Service
public class ListTodoService {

    @Autowired
    ListTodoRepository repository;

    public ListTodoDTO save(ListTodoDTO listTodoDTO) {
        ListToDoConverter converter = new ListToDoConverter();
        ListTodo listTodo = converter.fromDTO(listTodoDTO);
        return converter.fromModel(repository.save(listTodo));
    }

    public Boolean delete(Long id) {
        return repository.findById(id)
                .map(listTodo -> {
                    repository.delete(listTodo);
                    return true;
                }).orElse(false);
    }

}
