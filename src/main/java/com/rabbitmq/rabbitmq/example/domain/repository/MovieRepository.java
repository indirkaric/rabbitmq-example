package com.rabbitmq.rabbitmq.example.domain.repository;

import com.rabbitmq.rabbitmq.example.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);
}
