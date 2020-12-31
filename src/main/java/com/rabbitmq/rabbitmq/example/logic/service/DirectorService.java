package com.rabbitmq.rabbitmq.example.logic.service;

import com.rabbitmq.rabbitmq.example.domain.dto.DirectorDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Director;
import com.rabbitmq.rabbitmq.example.domain.event.publisher.DirectorCreatedPublisher;
import com.rabbitmq.rabbitmq.example.domain.repository.DirectorRepository;
import com.rabbitmq.rabbitmq.example.exception.error.NotFoundException;
import com.rabbitmq.rabbitmq.example.exception.error.RestApiError;
import com.rabbitmq.rabbitmq.example.logic.mapper.DirectorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DirectorService {
    private final DirectorMapper directorMapper;
    private  final DirectorRepository directorRepository;
    private final DirectorCreatedPublisher directorCreatedPublisher;

    public List<DirectorDto> getDirectors() {
        return directorRepository.findAll().stream().map(directorMapper::toDto).collect(Collectors.toList());
    }

    public DirectorDto getDirectorById(Long id) {
        Optional<Director> director = directorRepository.findById(id);
        if (!director.isPresent())
            throw new NotFoundException(RestApiError.DIRECTOR_NOT_FOUND);
        return  directorMapper.toDto(director.get());
    }

    public ResponseEntity<DirectorDto> saveDirector(DirectorDto directorDto) {
        Director tempDirector = directorRepository.save(directorMapper.toEntity(directorDto));
        DirectorDto director = directorMapper.toDto(tempDirector);
        directorCreatedPublisher.publish(directorMapper.toDirectorCreatedEvent(director));
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

}
