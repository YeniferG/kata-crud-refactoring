package co.com.sofka.crud.converter;

import co.com.sofka.crud.dto.ListTodoDTO;
import co.com.sofka.crud.model.ListTodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ListToDoConverterTest {

    @Test
    public void givenAnListTodoDtoReturnAnListTodo() {

        ListTodoDTO listTodoDTO = new ListTodoDTO();
        listTodoDTO.setName("entrenar");
        listTodoDTO.setId(1L);

        ListTodo expected = new ListTodo();
        expected.setName("entrenar");
        expected.setId(1L);

        ListToDoConverter listToDoConverter = new ListToDoConverter();

        ListTodo result = listToDoConverter.fromDTO(listTodoDTO);

        Assertions.assertEquals(expected.getClass(), result.getClass());
    }

    @Test
    public void givenAnListTodoReturnAnListTodoDTO() {

        ListTodo listTodo = new ListTodo();
        listTodo.setName("entrenar");
        listTodo.setId(1L);

        ListTodoDTO listTodoDTO = new ListTodoDTO();
        listTodoDTO.setName("entrenar");
        listTodoDTO.setId(1L);

        ListToDoConverter listToDoConverter = new ListToDoConverter();

        ListTodoDTO result = listToDoConverter.fromModel(listTodo);

        Assertions.assertEquals(listTodoDTO.getClass(), result.getClass());
    }

}