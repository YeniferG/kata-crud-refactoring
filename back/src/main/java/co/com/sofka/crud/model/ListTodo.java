package co.com.sofka.crud.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class ListTodo {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> listToDo;

    public List<Todo> getListTodo() {
        return listToDo;
    }

    public void setListTodo(List<Todo> listTodo) {
        this.listToDo = listTodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
