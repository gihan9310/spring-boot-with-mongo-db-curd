package com.gihanz.repositories;

import com.gihanz.documents.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

    Movie findMovieById(String id);
}
