package com.rabbitmq.rabbitmq.example.domain.repository;

import com.rabbitmq.rabbitmq.example.domain.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
