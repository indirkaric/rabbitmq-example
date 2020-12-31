package com.rabbitmq.rabbitmq.example.logic.mapper;

import com.rabbitmq.rabbitmq.example.domain.dto.CountryDto;
import com.rabbitmq.rabbitmq.example.domain.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    Country toEntity(CountryDto countryDto);
    CountryDto toDto(Country country);
}

