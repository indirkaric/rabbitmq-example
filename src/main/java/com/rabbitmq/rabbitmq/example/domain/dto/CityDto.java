package com.rabbitmq.rabbitmq.example.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CityDto {
    private Long id;
    @NotBlank(message = "name can not be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50")
    private String name;
    @NotNull(message = "Country can not be empty")
    private CountryDto country;

}

