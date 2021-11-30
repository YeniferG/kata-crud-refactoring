package co.com.sofka.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.crud.dto.ListTodoDTO;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.service.ListTodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("list-todo")
public class ListTodoController {

    @Autowired
    ListTodoService service;

    @PostMapping
    public ListTodoDTO save(@RequestBody ListTodoDTO listTodoDTO) {
        return service.save(listTodoDTO);
    }

    @PostMapping(value = "/todo")
    public TodoDTO save(@RequestBody TodoDTO todoDTO) {
        return service.save(todoDTO);
    }

}
