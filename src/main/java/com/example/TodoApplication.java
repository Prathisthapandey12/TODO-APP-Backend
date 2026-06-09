package com.example;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class TodoApplication extends Application<TodoConfiguration> {

    public static void main(String[] args) throws Exception {
        new TodoApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<TodoConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig("com.example") 
                .modules(new TodoModule()) // <-- Guice registers it cleanly here now
                .build());
    }

    @Override
    public void run(TodoConfiguration configuration, Environment environment) {
    }
}