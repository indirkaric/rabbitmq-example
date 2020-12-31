package com.rabbitmq.rabbitmq.example.domain.repository;

import com.rabbitmq.rabbitmq.example.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);
}
