package com.rabbitmq.rabbitmq.example.logic.mapper;

import com.rabbitmq.rabbitmq.example.domain.dto.MovieDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Movie;
import com.rabbitmq.rabbitmq.example.domain.event.model.MovieCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    Movie toEntity(MovieDto movieDto);
    MovieDto toDto(Movie movie);
    MovieCreatedEvent toMovieCreatedEvent(MovieDto movieDto);
}

