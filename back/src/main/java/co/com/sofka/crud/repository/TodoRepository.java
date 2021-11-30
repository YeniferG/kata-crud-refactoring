package co.com.sofka.crud.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.sofka.crud.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
