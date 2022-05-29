package com.example.movieratingsoftware.Repository;

import com.example.movieratingsoftware.Modle.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
}
