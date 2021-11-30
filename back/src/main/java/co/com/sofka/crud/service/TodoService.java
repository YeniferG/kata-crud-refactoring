package co.com.sofka.crud.service;

import java.util.stream.Collectors;

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

        @Autowired
        ListTodoService listTodoService;

        public TodoDTO save(TodoDTO todoDTO) {
                TodoConverter converter = new TodoConverter();
                Todo todo = converter.fromDTO(todoDTO);
                ListTodo listTodoById = listTodoRepository.findById(todoDTO.getListTodoId())
                                .orElseThrow(() -> new RuntimeException("List id not found"));
                listTodoById.getListTodo().add(todo);

                ListTodo newListTodo = listTodoRepository.save(listTodoById);

                int lastIndexTodo = (newListTodo.getListTodo().size() - 1);

                Todo newTodo = newListTodo.getListTodo()
                                .get(lastIndexTodo);
                TodoDTO toTodoDTO = converter.fromModel(newTodo);
                toTodoDTO.setListTodoId(newListTodo.getId());

                return toTodoDTO;
        }

        public TodoDTO update(TodoDTO todoDTO) {
                TodoConverter todoConverter = new TodoConverter();
                ListTodo listToDoToUpdate = listTodoService.getListTodoById(todoDTO.getListTodoId());
                listToDoToUpdate.getListTodo()
                                .stream()
                                .map(todoToUpdate -> {
                                        if (todoToUpdate.getId().equals(todoDTO.getId())) {
                                                todoToUpdate.setName(todoDTO.getName());
                                                todoToUpdate.setCompleted(todoDTO.getCompleted());
                                        }
                                        return todoToUpdate;
                                }).collect(Collectors.toList());
                ListTodo listTodo = listTodoRepository.save(listToDoToUpdate);
                Todo todoUpdated = getTodoById(listTodo, todoDTO.getId());
                TodoDTO toToDoDTO = todoConverter.fromModel(todoUpdated);
                toToDoDTO.setListTodoId(todoDTO.getListTodoId());
                return toToDoDTO;
        }

        public void delete(Long idList, Long idTodo) {
                ListTodo listTodo = listTodoService.getListTodoById(idList);
                Todo todo = getTodoById(listTodo, idTodo);
                listTodo.getListTodo().remove(todo);
                listTodoRepository.save(listTodo);
        }

        public TodoDTO getTodo(Long idList, Long idTodo) {
                TodoConverter todoConverter = new TodoConverter();
                ListTodo listTodo = listTodoService.getListTodoById(idList);
                Todo todo = getTodoById(listTodo, idTodo);
                TodoDTO todoDTO = todoConverter.fromModel(todo);
                todoDTO.setListTodoId(listTodo.getId());
                return todoDTO;
        }

        private Todo getTodoById(ListTodo listTodo, Long idTodo) {
                return listTodo.getListTodo()
                                .stream()
                                .filter(t -> t.getId().equals(idTodo))
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException("Todo not found"));
        }
}
