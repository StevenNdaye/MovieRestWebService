package com.movie.rest.service;

import com.movie.rest.entity.Movie;
import com.movie.rest.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @Mock private MovieRepository movieRepository;
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void shouldCreateMovie() throws Exception {
        Movie movie = new Movie("name", 5, 90, "Review", "Thumb");
        when(movieRepository.save(movie)).thenReturn(movie);

        movieService.createMovie(movie);

        verify(movieRepository, atLeastOnce()).save(movie);

    }
}