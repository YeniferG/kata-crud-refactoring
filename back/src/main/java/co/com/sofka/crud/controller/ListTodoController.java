package co.com.sofka.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.com.sofka.crud.dto.ListTodoDTO;
import co.com.sofka.crud.service.ListTodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("list-todo")
public class ListTodoController {

    @Autowired
    ListTodoService service;

    @PostMapping
    public ResponseEntity<ListTodoDTO> save(@RequestBody ListTodoDTO listTodoDTO) {
        return new ResponseEntity(service.save(listTodoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteListTodo(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<ListTodoDTO>> findAllListToDoDTO() {
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }

}
