package com.example;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;

@RegisterBeanMapper(Todo.class)
public interface TodoDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS todos (id SERIAL PRIMARY KEY, title VARCHAR(255), completed BOOLEAN)")
    void createTable();

    @SqlQuery("SELECT * FROM todos")
    List<Todo> getAll();

    @SqlQuery("SELECT * FROM todos WHERE id = :id")
    Todo findById(@Bind("id") long id);

    @SqlUpdate("INSERT INTO todos (title, completed) VALUES (:title, :completed)")
    @GetGeneratedKeys
    long insert(@Bind("title") String title, @Bind("completed") boolean completed);

    @SqlUpdate("UPDATE todos SET completed = :completed WHERE id = :id")
    void updateStatus(@Bind("id") long id, @Bind("completed") boolean completed);
}