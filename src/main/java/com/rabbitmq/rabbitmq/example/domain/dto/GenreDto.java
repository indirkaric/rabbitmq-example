package com.rabbitmq.rabbitmq.example.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class GenreDto {
    private Long id;
    @NotBlank(message = "Genre can not be blank")
    @Size(min = 4, max = 15, message = "Name must be between 4 and 15")
    private String name;

}

