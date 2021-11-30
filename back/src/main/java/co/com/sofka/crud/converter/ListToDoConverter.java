package co.com.sofka.crud.converter;

import co.com.sofka.crud.dto.ListTodoDTO;
import co.com.sofka.crud.model.ListTodo;

public class ListToDoConverter implements Converter<ListTodo, ListTodoDTO> {

    @Override
    public ListTodo fromDTO(ListTodoDTO dto) {
        ListTodo listTodo = new ListTodo();
        listTodo.setId(dto.getId());
        listTodo.setName(dto.getName());
        return listTodo;
    }

    @Override
    public ListTodoDTO fromModel(ListTodo entity) {
        ListTodoDTO listTodoDTO = new ListTodoDTO();
        listTodoDTO.setName(entity.getName());
        listTodoDTO.setId(entity.getId());
        return listTodoDTO;
    }

}
