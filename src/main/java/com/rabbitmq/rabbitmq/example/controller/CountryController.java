package com.rabbitmq.rabbitmq.example.controller;

import com.rabbitmq.rabbitmq.example.domain.dto.CountryDto;
import com.rabbitmq.rabbitmq.example.logic.service.CountryService;
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
@RequestMapping(CountryController.ROOT_PATH)
public class CountryController {
    public static final String ROOT_PATH = "/api/v1/countries";
    private final CountryService countryService;

    @GetMapping
    @ApiOperation(value = "Get all countries")
    public ResponseEntity<List<CountryDto>> getCountries() {
        List<CountryDto> countries = countryService.getCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get country by id")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable Long id) {
        CountryDto country = countryService.getCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

}
