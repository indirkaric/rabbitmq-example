package com.rabbitmq.rabbitmq.example.logic.service;

import com.rabbitmq.rabbitmq.example.domain.dto.CountryDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Country;
import com.rabbitmq.rabbitmq.example.domain.repository.CountryRepository;
import com.rabbitmq.rabbitmq.example.exception.error.NotFoundException;
import com.rabbitmq.rabbitmq.example.exception.error.RestApiError;
import com.rabbitmq.rabbitmq.example.logic.mapper.CountryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryDto> getCountries() {
        return countryRepository.findAll().stream().map(countryMapper::toDto).collect(Collectors.toList());
    }

    public CountryDto getCountryById(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        if (!country.isPresent())
            throw new NotFoundException(RestApiError.COUNTRY_NOT_FOUND);
        return  countryMapper.toDto(country.get());
    }
}
