package com.rabbitmq.rabbitmq.example.domain.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true)
    private String name;

}

