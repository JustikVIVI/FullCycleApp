package com.learning.demo.repository;


import com.learning.demo.models.HelloWorldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloWorldRepository extends JpaRepository<HelloWorldEntity, Long> {
}
