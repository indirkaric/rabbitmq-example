package com.rabbitmq.rabbitmq.example.logic.service;

import com.rabbitmq.rabbitmq.example.domain.dto.CityDto;
import com.rabbitmq.rabbitmq.example.domain.entity.City;
import com.rabbitmq.rabbitmq.example.domain.repository.CityRepository;
import com.rabbitmq.rabbitmq.example.exception.error.NotFoundException;
import com.rabbitmq.rabbitmq.example.exception.error.RestApiError;
import com.rabbitmq.rabbitmq.example.logic.mapper.CityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public List<CityDto> getCities() {
        return cityRepository.findAll().stream().map(cityMapper::toDto).collect(Collectors.toList());
    }

    public CityDto getCityById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (!city.isPresent())
            throw new NotFoundException(RestApiError.CITY_NOT_FOUND);
        return  cityMapper.toDto(city.get());
    }
}
