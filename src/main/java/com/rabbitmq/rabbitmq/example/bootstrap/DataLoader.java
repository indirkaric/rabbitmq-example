package com.rabbitmq.rabbitmq.example.bootstrap;

import com.rabbitmq.rabbitmq.example.domain.entity.*;
import com.rabbitmq.rabbitmq.example.domain.repository.*;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final GenreRepository genreRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    public void loadData() {
        loadCountries();
        loadGenres();
        loadCities();
        loadActors();
        loadDirectors();
        loadMovies();
    }

    public void loadCountries() {
        List<String> countries = Arrays.asList(
                                "United States of America", "Bosnia and Herzegovina",
                                "Mexico", "Serbia",
                                "France", "Italy",
                                "Germany", "Croatia",
                                "Bulgaria", "Venezuela",
                                "Albania", "Belgium",
                                "Peru", "Argentina",
                                "Greece", "Cyprus",
                                "Spain", "Portugal",
                                "Finland", "Norway",
                                "Iraq", "Iran"
                                );
        if (countryRepository.count() <= 0) {
            countries.forEach(tempCountry -> {
                Country country = new Country();
                country.setName(tempCountry);
                countryRepository.save(country);
            });
        }

    }

    public void loadGenres() {
        List<String> genres = Arrays.asList(
                                            "Comedy", "Thriller",
                                            "Horror",  "Action",
                                            "Drama", "Science",
                                            "Fantasy", "Mystery",
                                            "Romance", "Western"
                                            );
        if (genreRepository.count() <= 0) {
            genres.forEach(tempGenre -> {
                Genre genre = new Genre();
                genre.setName(tempGenre);
                genreRepository.save(genre);
            });
        }
    }

    public void loadCities() {
        if (countryRepository.count() > 0 && cityRepository.count() <= 0) {
            List<String> spainCities = Arrays.asList("Madrid", "Seville", "Barcelona");
            List<String> bosniaCities = Arrays.asList("Sarajevo", "Tuzla", "Mostar");
            List<String> usaCities = Arrays.asList("Miami", "Los Angeles", "Oakland", "Denver", "Houston");
            List<String> franceCities = Arrays.asList("Paris", "Lyon", "Nice");

            Country spain = countryRepository.findByName("Spain");
            Country bosnia = countryRepository.findByName("Bosnia and Herzegovina");
            Country usa = countryRepository.findByName("United States of America");
            Country france = countryRepository.findByName("France");

            saveCities(spain, spainCities);
            saveCities(bosnia, bosniaCities);
            saveCities(usa, usaCities);
            saveCities(france, franceCities);
        }
    }

    public void saveCities(Country country, List<String> cities) {
        if (country != null) {
             cities.forEach(tempCity -> {
                 City city = new City();
                 city.setName(tempCity);
                 city.setCountry(country);
                 cityRepository.save(city);
            });
        }
    }

    public void loadActors() {
        if (actorRepository.count() <= 0) {
            Actor actor1 = new Actor();
            Actor actor2 = new Actor();
            Actor actor3 = new Actor();

            actor1.setFirstName("Test");
            actor1.setLastName("Actor");
            actor1.setCity(cityRepository.findByName("Houston"));

            actor2.setFirstName("Test2");
            actor2.setLastName("Actor");
            actor2.setCity(cityRepository.findByName("Oakland"));

            actor3.setFirstName("Test3");
            actor3.setLastName("Actor");
            actor3.setCity(cityRepository.findByName("Madrid"));

            actorRepository.save(actor1);
            actorRepository.save(actor2);
            actorRepository.save(actor3);

        }
    }

    public void loadDirectors() {
        if (directorRepository.count() <= 0) {
             Director director1 = new Director();
             Director director2 = new Director();
             Director director3 = new Director();

             director1.setFirstName("Test");
             director1.setLastName("Director");
             director1.setCity(cityRepository.findByName("Nice"));

             director2.setFirstName("Test2");
             director2.setLastName("Director");
             director2.setCity(cityRepository.findByName("Nice"));

             director3.setFirstName("Test3");
             director3.setLastName("Director");
             director3.setCity(cityRepository.findByName("Sarajevo"));

             directorRepository.save(director1);
             directorRepository.save(director2);
             directorRepository.save(director3);
        }
    }

    public void loadMovies() {
        if (movieRepository.count() <= 0) {
            Movie movie1 = new Movie();
            Movie movie2 = new Movie();

            movie1.setCity(cityRepository.findByName("Sarajevo"));
            movie1.setYear(2018);
            movie1.setTitle("Test Movie");
            movie1.setRating((float) 9.5);
            movie1.setImageUrl("No URL");
            movie1.setVotes(55555);
            movie1.getGenres().add(genreRepository.findByName("Action"));

            movie2.setCity(cityRepository.findByName("Miami"));
            movie2.setYear(2016);
            movie2.setTitle("Test2 Movie");
            movie2.setRating((float) 8.2);
            movie2.setImageUrl("No URL");
            movie2.setVotes(52855);
            movie2.getGenres().add(genreRepository.findByName("Thriller"));

            movieRepository.save(movie1);
            movieRepository.save(movie2);
        }
    }
}
