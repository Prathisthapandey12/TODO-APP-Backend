package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

// set up the REST api endpoints using get, post , path commands
@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    private final TodoDAO todoDAO;

    @Inject  // <--- Guice automatically injects the DAO here!
    public TodoResource(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @GET
    public List<Todo> getAllTodos() {
        return todoDAO.getAll();
    }

    @POST
    public Todo createTodo(Todo todo) {
        long id = todoDAO.insert(todo.getTitle(), todo.isCompleted());
        return new Todo(id, todo.getTitle(), todo.isCompleted());
    }

    @POST
    @Path("/{id}/toggle")
    public Todo toggleTodoStatus(@PathParam("id") long id) {
        Todo existingTodo = todoDAO.findById(id);
        
        if (existingTodo == null) {
            throw new WebApplicationException("Todo task not found", 404);
        }

        boolean newStatus = !existingTodo.isCompleted();

        todoDAO.updateStatus(id, newStatus);

        existingTodo.setCompleted(newStatus);
        return existingTodo;
    }
    @DELETE
    @Path("/{id}")
    public Todo deleteTodo(@PathParam("id") long id) {
        Todo existingTodo = todoDAO.findById(id);
        
        if (existingTodo == null) {
            throw new WebApplicationException("Todo task not found");
        }
        todoDAO.deleteById(id);
        return existingTodo;
    }
}