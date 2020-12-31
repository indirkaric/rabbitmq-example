package com.rabbitmq.rabbitmq.example.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CountryDto {
    private Long id;
    @NotBlank
    @NotBlank(message = "name can not be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50")
    private String name;

}

