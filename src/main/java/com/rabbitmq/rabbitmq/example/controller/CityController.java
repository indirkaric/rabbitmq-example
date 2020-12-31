package com.rabbitmq.rabbitmq.example.controller;

import com.rabbitmq.rabbitmq.example.domain.dto.CityDto;
import com.rabbitmq.rabbitmq.example.logic.service.CityService;
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
@RequestMapping(CityController.ROOT_PATH)
public class CityController {
    public static final String ROOT_PATH = "/api/v1/cities";
    private final CityService cityService;

    @GetMapping
    @ApiOperation(value = "Get all cities")
    public ResponseEntity<List<CityDto>> getCountries() {
        List<CityDto> cities = cityService.getCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get city by id")
    public ResponseEntity<CityDto> getCityById(@PathVariable Long id) {
        CityDto city = cityService.getCityById(id);
        return  new ResponseEntity<>(city, HttpStatus.OK);
    }
}
