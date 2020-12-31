package com.rabbitmq.rabbitmq.example.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
