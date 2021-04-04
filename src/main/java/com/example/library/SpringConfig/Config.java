package com.example.library.SpringConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.example.library")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "com.example.library.repository")
public class Config {
}
