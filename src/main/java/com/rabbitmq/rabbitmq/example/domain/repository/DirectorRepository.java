package com.rabbitmq.rabbitmq.example.domain.repository;

import com.rabbitmq.rabbitmq.example.domain.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
