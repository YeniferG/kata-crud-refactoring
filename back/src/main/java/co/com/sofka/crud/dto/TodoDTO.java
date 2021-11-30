package co.com.sofka.crud.dto;

public class TodoDTO {

    private Long listTodoId;
    private Long id;
    private String name;
    private Boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getListTodoId() {
        return listTodoId;
    }

    public void setListTodoId(Long listTodoId) {
        this.listTodoId = listTodoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}
