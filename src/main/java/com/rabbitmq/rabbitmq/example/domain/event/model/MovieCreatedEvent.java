package com.rabbitmq.rabbitmq.example.domain.event.model;

import com.rabbitmq.rabbitmq.example.domain.dto.CityDto;
import com.rabbitmq.rabbitmq.example.domain.dto.DirectorDto;
import com.rabbitmq.rabbitmq.example.domain.dto.GenreDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCreatedEvent extends Event{
    private Long id;
    private String title;
    private int year;
    private String imageUrl;
    private int runtime;
    private Float rating;
    private int votes;
    private CityDto city;
    public List<Actor> actors = new ArrayList<>();
    public List<DirectorDto> directors = new ArrayList<>();
    public List<GenreDto> genres = new ArrayList<>();
}
