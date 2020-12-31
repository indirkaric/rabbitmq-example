package com.rabbitmq.rabbitmq.example.logic.service;

import com.rabbitmq.rabbitmq.example.domain.dto.MovieDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Genre;
import com.rabbitmq.rabbitmq.example.domain.entity.Movie;
import com.rabbitmq.rabbitmq.example.domain.event.publisher.MovieCreatedPublisher;
import com.rabbitmq.rabbitmq.example.domain.repository.MovieRepository;
import com.rabbitmq.rabbitmq.example.exception.error.BadRequestException;
import com.rabbitmq.rabbitmq.example.exception.error.NotFoundException;
import com.rabbitmq.rabbitmq.example.exception.error.RestApiError;
import com.rabbitmq.rabbitmq.example.logic.mapper.GenreMapper;
import com.rabbitmq.rabbitmq.example.logic.mapper.MovieMapper;
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
public class MovieService {
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;
    private  final MovieCreatedPublisher movieCreatedPublisher;
    private final GenreMapper genreMapper;
    private final GenreService genreService;

    public List<MovieDto> getMovies() {
        return movieRepository.findAll().stream().map(movieMapper::toDto).collect(Collectors.toList());
    }

    public MovieDto getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent())
            throw new NotFoundException(RestApiError.MOVIE_NOT_FOUND);
        return movieMapper.toDto(movie.get());
    }

    public ResponseEntity<MovieDto> saveMovie(MovieDto movieDto) {
        if (movieRepository.findByTitle(movieDto.getTitle()) != null)
             throw new BadRequestException(RestApiError.MOVIE_ALREADY_EXIST);
        Movie tempMovie = movieRepository.save(movieMapper.toEntity(movieDto));
        MovieDto movie = movieMapper.toDto(tempMovie);
        movieCreatedPublisher.publish(movieMapper.toMovieCreatedEvent(movie));
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    public ResponseEntity<MovieDto> addGenre(Long movieId, Long genreId) {
        Genre genre = genreMapper.toEntity(genreService.getGenreById(genreId));
        Movie movie = movieMapper.toEntity(getMovieById(movieId));
        if(movie.getGenres().contains(genre)){
            throw new BadRequestException(RestApiError.GENRE_ALREADY_EXIST);
        }else {
            movie.getGenres().add(genre);
            MovieDto movieDto = movieMapper.toDto(movieRepository.save(movie));
            return new ResponseEntity<>(movieDto, HttpStatus.OK);
        }

    }
}
