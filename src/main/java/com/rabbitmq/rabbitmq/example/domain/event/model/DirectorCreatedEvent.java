package com.rabbitmq.rabbitmq.example.domain.event.model;

import com.rabbitmq.rabbitmq.example.domain.dto.CityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorCreatedEvent extends Event{
    private Long id;
    private String firstName;
    private String lastName;
    private CityDto city;
}
