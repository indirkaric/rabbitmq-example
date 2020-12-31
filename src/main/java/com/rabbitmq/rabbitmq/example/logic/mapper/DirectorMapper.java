package com.rabbitmq.rabbitmq.example.logic.mapper;

import com.rabbitmq.rabbitmq.example.domain.dto.DirectorDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Director;
import com.rabbitmq.rabbitmq.example.domain.event.model.DirectorCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);
    Director toEntity(DirectorDto directorDto);
    DirectorDto toDto(Director director);
    DirectorCreatedEvent toDirectorCreatedEvent(DirectorDto directorDto);
}

