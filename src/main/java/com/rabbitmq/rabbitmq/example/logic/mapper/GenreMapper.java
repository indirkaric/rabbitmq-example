package com.rabbitmq.rabbitmq.example.logic.mapper;

import com.rabbitmq.rabbitmq.example.domain.dto.GenreDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);
    Genre toEntity(GenreDto genreDto);
    GenreDto toDto(Genre genre);
}
