package com.rabbitmq.rabbitmq.example.controller;

import com.rabbitmq.rabbitmq.example.domain.dto.DirectorDto;
import com.rabbitmq.rabbitmq.example.logic.service.DirectorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(DirectorController.ROOT_PATH)
public class DirectorController {
    public static final String ROOT_PATH = "/api/v1/directors";
    private final DirectorService directorService;

    @GetMapping
    @ApiOperation(value = "Get all directors")
    public ResponseEntity<List<DirectorDto>> getDirectors() {
        List<DirectorDto> directors = directorService.getDirectors();
        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get director by id")
    public ResponseEntity<DirectorDto> getDirectorById(@PathVariable Long id) {
        DirectorDto director = directorService.getDirectorById(id);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Save director")
    public ResponseEntity<DirectorDto> saveDirector(@Valid @RequestBody DirectorDto directorDto) {
        return directorService.saveDirector(directorDto);
    }
}
