package com.rabbitmq.rabbitmq.example.domain.repository;

import com.rabbitmq.rabbitmq.example.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}
