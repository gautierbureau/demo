package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:database.properties"})
@PropertySource(value = {"file:/config/database.properties"}, ignoreResourceNotFound = true)
public class DataSourceConfiguration {
}
