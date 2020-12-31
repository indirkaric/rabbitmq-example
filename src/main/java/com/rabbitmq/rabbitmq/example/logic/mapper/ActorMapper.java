package com.rabbitmq.rabbitmq.example.logic.mapper;

import com.rabbitmq.rabbitmq.example.domain.dto.ActorDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);
    Actor toEntity(ActorDto actorDto);
    ActorDto toDto(Actor actor);

}
