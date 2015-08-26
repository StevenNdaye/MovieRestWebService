package com.movie.rest.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty
    private int id;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @Column(name = "rating")
    @JsonProperty
    private int rating;

    @Column(name = "availability")
    @JsonProperty
    private long availability;

    @Column(name = "review", length = 500)
    @JsonProperty
    private String review;

    @Column(name = "thumb")
    @JsonProperty
    private String thumb;

    @JsonCreator
    public Movie(@JsonProperty("name") String name, @JsonProperty("rating") int rating,
                 @JsonProperty("availability") long availability, @JsonProperty("review") String review,
                 @JsonProperty("thumb") String thumb) {
        this.name = name;
        this.rating = rating;
        this.availability = availability;
        this.review = review;
        this.thumb = thumb;
    }
}
