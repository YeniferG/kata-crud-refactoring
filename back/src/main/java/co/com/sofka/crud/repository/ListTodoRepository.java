package co.com.sofka.crud.repository;

import org.springframework.data.repository.CrudRepository;
import co.com.sofka.crud.model.ListTodo;

public interface ListTodoRepository extends CrudRepository<ListTodo, Long> {

}
