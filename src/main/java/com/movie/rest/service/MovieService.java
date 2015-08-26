package com.movie.rest.service;

import com.movie.rest.entity.Movie;
import com.movie.rest.repository.MovieRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Inject
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
