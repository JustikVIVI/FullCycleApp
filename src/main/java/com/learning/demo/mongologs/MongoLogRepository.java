package com.learning.demo.mongologs;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoLogRepository extends MongoRepository<MongoLog, String> {
    MongoLog findByLevel(String level);
    @NotNull
    List<MongoLog> findAll();
}
