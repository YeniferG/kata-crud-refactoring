package co.com.sofka.crud.converter;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.model.Todo;

public class TodoConverter implements Converter<Todo, TodoDTO> {

    @Override
    public Todo fromDTO(TodoDTO dto) {
        Todo todo = new Todo();
        todo.setName(dto.getName());
        todo.setCompleted(dto.getCompleted());
        return todo;
    }

    @Override
    public TodoDTO fromModel(Todo entity) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(entity.getId());
        todoDTO.setName(entity.getName());
        todoDTO.setCompleted(entity.getCompleted());
        return todoDTO;
    }

}
