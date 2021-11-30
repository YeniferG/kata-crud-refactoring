package co.com.sofka.crud.dto;

public class ListTodoDTO {

    private Long id;
    private String name;

    public ListTodoDTO() {
    }

    public ListTodoDTO(String name) {
        this.name = name;
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
