package com.rabbitmq.rabbitmq.example.controller;

import com.rabbitmq.rabbitmq.example.domain.dto.ActorDto;
import com.rabbitmq.rabbitmq.example.logic.service.ActorService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ActorController.ROOT_PATH)
public class ActorController {
    public static final String ROOT_PATH = "/api/v1/actors";
    private final ActorService actorService;

    @GetMapping
    @ApiOperation(value = "Get all actors")
    public ResponseEntity<List<ActorDto>> getActors() {
        List<ActorDto> actors = actorService.getActors();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get actor by id")
    public ResponseEntity<ActorDto> getActorById(@PathVariable Long id) {
        ActorDto actor = actorService.getActorById(id);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

}
