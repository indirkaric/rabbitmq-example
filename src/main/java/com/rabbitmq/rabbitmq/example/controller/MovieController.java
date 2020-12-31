package com.rabbitmq.rabbitmq.example.controller;

import com.rabbitmq.rabbitmq.example.domain.dto.MovieDto;
import com.rabbitmq.rabbitmq.example.logic.service.MovieService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(MovieController.ROOT_PATH)
public class MovieController {
    public static final String ROOT_PATH = "/api/v1/movies";
    private final MovieService movieService;

    @GetMapping
    @ApiOperation(value = "Get all movies")
    public ResponseEntity<List<MovieDto>> getMovies() {
        List<MovieDto> movies = movieService.getMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get movie by id")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        MovieDto movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Save movie")
    public ResponseEntity<MovieDto> saveMovie(@Valid @RequestBody MovieDto movieDto) {
        return movieService.saveMovie(movieDto);
    }

    @PostMapping("/{movieId}/{genreId}")
    @ApiOperation(value = "Add genre")
    public ResponseEntity<MovieDto> addGenre(@PathVariable Long movieId, @PathVariable Long genreId) {
        return movieService.addGenre(movieId, genreId);
    }
}
