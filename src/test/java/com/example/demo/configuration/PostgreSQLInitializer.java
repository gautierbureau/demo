package com.example.demo.configuration;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Map;

public class PostgreSQLInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final String POSTGRESQL_IMAGE = "postgres:13.1";
    private static final long MEMORY_IN_BYTES = 128 * 1024 * 1024; // 128 MB
    private static final long MEMORY_SWAP_IN_BYTES = 256 * 1024 * 1024; // 256 MB
    private static final PostgreSQLContainer<?> POSTGRESQL_CONTAINER = new PostgreSQLContainer<>(POSTGRESQL_IMAGE)
            .withDatabaseName("demo")
            .withCreateContainerCmdModifier(cmd -> cmd.getHostConfig()
                    .withMemory(MEMORY_IN_BYTES)
                    .withMemorySwap(MEMORY_SWAP_IN_BYTES)
            );

    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        final ConfigurableEnvironment environment = applicationContext.getEnvironment();

        POSTGRESQL_CONTAINER
                .withUsername(environment.getProperty("spring.datasource.username"))
                .withPassword(environment.getProperty("spring.datasource.password"))
                .start();

        TestPropertyValues.of(Map.of(
                "spring.liquibase.url", POSTGRESQL_CONTAINER.getJdbcUrl(),
                "spring.liquibase.user", POSTGRESQL_CONTAINER.getUsername(),
                "spring.liquibase.password", POSTGRESQL_CONTAINER.getPassword(),
                "spring.datasource.url", POSTGRESQL_CONTAINER.getJdbcUrl()
        )).applyTo(applicationContext);
    }
}
