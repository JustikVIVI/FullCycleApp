package com.learning.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class MigrationVerifier {

    @Bean
    public CommandLineRunner verifyMigrations(ResourceLoader resourceLoader) {
        return args -> {
            Resource resource = resourceLoader.getResource("classpath:db/common/V20240530_1422__create_initial_tables.sql");
            System.out.println("Resource exists: " + resource.exists());
            if (resource.exists()) {
                System.out.println("Resource description: " + resource.getDescription());
            }
        };
    }
}
