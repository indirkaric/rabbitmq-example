package com.rabbitmq.rabbitmq.example.logic.service;

import com.rabbitmq.rabbitmq.example.domain.dto.ActorDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Actor;
import com.rabbitmq.rabbitmq.example.domain.repository.ActorRepository;
import com.rabbitmq.rabbitmq.example.exception.error.NotFoundException;
import com.rabbitmq.rabbitmq.example.exception.error.RestApiError;
import com.rabbitmq.rabbitmq.example.logic.mapper.ActorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActorService {
    private final ActorMapper actorMapper;
    private final ActorRepository actorRepository;

    public List<ActorDto> getActors() {
        return actorRepository.findAll().stream().map(actorMapper::toDto).collect(Collectors.toList());
    }

    public ActorDto getActorById(Long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        if (!actor.isPresent())
            throw new NotFoundException(RestApiError.ACTOR_NOT_FOUND);
        return actorMapper.toDto(actor.get());
    }
}
