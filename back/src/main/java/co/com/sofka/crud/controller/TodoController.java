package co.com.sofka.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity<TodoDTO> save(@RequestBody TodoDTO todoDTO) {
        return new ResponseEntity(todoService.save(todoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<TodoDTO> update(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
        if (todoDTO.getId() != null) {
            return new ResponseEntity(todoService.update(id, todoDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/list-todo/{idList}/todo/{idTodo}")
    public ResponseEntity delete(@PathVariable Long idList, @PathVariable Long idTodo) {
        try {
            todoService.delete(idList, idTodo);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list-todo/{idList}/todo/{idTodo}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable Long idList, @PathVariable Long idTodo) {
        return new ResponseEntity(todoService.getTodo(idList, idTodo), HttpStatus.OK);
    }

}
