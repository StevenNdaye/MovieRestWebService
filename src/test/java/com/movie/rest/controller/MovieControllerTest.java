package com.movie.rest.controller;

import com.movie.rest.entity.Movie;
import com.movie.rest.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieControllerTest {

    @Mock private MovieService movieService;
    private MovieController movieController;

    @Before
    public void setUp() throws Exception {
        movieController = new MovieController(movieService);
    }

    @Test
    public void shouldCreateMovie() throws Exception {
        Movie movie = new Movie("name", 5, 90, "Review", "Thumb");
        when(movieService.createMovie(movie)).thenReturn(movie);

        movieController.createMovie(movie);

        verify(movieService, atLeastOnce()).createMovie(movie);

    }
}