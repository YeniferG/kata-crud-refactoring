package co.com.sofka.crud.model;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Boolean isCompleted;

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
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
