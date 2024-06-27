package com.learning.demo.mongologs;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoLogRepository extends MongoRepository<Object, String> {
}
