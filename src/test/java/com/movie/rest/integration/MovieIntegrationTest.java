package com.movie.rest.integration;

import com.movie.rest.entity.Movie;
import com.movie.rest.repository.MovieRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Category(IntegrationTest.class)
public class MovieIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private MovieRepository movieRepository;
    private String url;

    @Before
    public void setUp() throws Exception {
        url = resourceUrl("/");
    }

    @Test
    public void shouldCreateAMovie() throws Exception {
        Movie movie = new Movie("Name", 1, 4, "Review", "Thumb");
        ResponseEntity<Movie> createdMovie = restTemplate.postForEntity(url + "movies", movie, Movie.class);

        assertThat(createdMovie.getStatusCode(), is(HttpStatus.OK));
    }


    @After
    public void tearDown() throws Exception {
        movieRepository.deleteAll();
    }
}
