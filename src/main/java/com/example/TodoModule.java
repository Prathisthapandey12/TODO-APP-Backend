package com.example;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.dropwizard.jdbi3.JdbiFactory;
import org.jdbi.v3.core.Jdbi;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class TodoModule extends DropwizardAwareModule<TodoConfiguration> {

    @Provides
    @Singleton
    public TodoDAO provideTodoDAO() {
        // DropwizardAwareModule gives you direct access to 'configuration()' and 'environment()' safely!
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment(), configuration().getDataSourceFactory(), "postgresql");
        
        TodoDAO dao = jdbi.onDemand(TodoDAO.class);
        dao.createTable();
        return dao;
    }
}