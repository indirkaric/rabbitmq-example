package com.rabbitmq.rabbitmq.example.logic.service;

import com.rabbitmq.rabbitmq.example.domain.dto.GenreDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Genre;
import com.rabbitmq.rabbitmq.example.domain.repository.GenreRepository;
import com.rabbitmq.rabbitmq.example.exception.error.NotFoundException;
import com.rabbitmq.rabbitmq.example.exception.error.RestApiError;
import com.rabbitmq.rabbitmq.example.logic.mapper.GenreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenreDto getGenreById(Long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        if (!genre.isPresent())
            throw new NotFoundException(RestApiError.GENRE_NOT_FOUND);
        return genreMapper.toDto(genre.get());
    }
}
