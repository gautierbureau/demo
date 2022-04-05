package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Container
    public static PostgreSQLContainer<?> postgreDBContainer = new PostgreSQLContainer<>("postgres:13.1")
            .withDatabaseName("demo");

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.liquibase.url", postgreDBContainer::getJdbcUrl);
        registry.add("spring.liquibase.user", postgreDBContainer::getUsername);
        registry.add("spring.liquibase.password", postgreDBContainer::getPassword);
        registry.add("spring.datasource.url", postgreDBContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreDBContainer::getUsername);
        registry.add("spring.datasource.password", postgreDBContainer::getPassword);
    }

    @Test
    void contextLoads() {
    }

}
