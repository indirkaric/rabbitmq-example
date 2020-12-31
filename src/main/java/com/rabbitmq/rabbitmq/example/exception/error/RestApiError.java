package com.rabbitmq.rabbitmq.example.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class RestApiError implements Serializable {
    public static final RestApiError MOVIE_NOT_FOUND = new RestApiError("movie_not_found", "Movie not found");
    public static final RestApiError MOVIE_ALREADY_EXIST = new RestApiError("movie_already_exist", "Movie already exist");
    public static final RestApiError ACTOR_NOT_FOUND = new RestApiError("actor_not_found", "Actor not found");
    public static final RestApiError ACTOR_ALREADY_EXIST = new RestApiError("actor_already_exist", "Actor_already_exist");
    public static final RestApiError DIRECTOR_NOT_FOUND = new RestApiError("director_not_found", "Director not found");
    public static final RestApiError DIRECTOR_ALREADY_EXIST = new RestApiError("director_already_exist", "Director already exist");
    public static final RestApiError COUNTRY_NOT_FOUND = new RestApiError("country_not_found", "Country not found");
    public static final RestApiError CITY_NOT_FOUND = new RestApiError("city_not_found", "City not found");
    public static final RestApiError GENRE_NOT_FOUND = new RestApiError("genre_not_found", "Genre not found");
    public static final RestApiError GENRE_ALREADY_EXIST = new RestApiError("genre_already_exist", "Genre already exist");

    public static final String ERROR = "error";
    public static final String ERROR_DESCRIPTION = "error_description";
    @JsonProperty(ERROR)
    private String error;
    @JsonProperty(ERROR_DESCRIPTION)
    private String description;

    public RestApiError(String error, String description) {
        this.error = error;
        this.description = description;
    }
}
