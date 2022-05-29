package com.example.movieratingsoftware.Service;

import com.example.movieratingsoftware.Modle.Movie;
import com.example.movieratingsoftware.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    public List<Movie> getMovies() {
       return movieRepository.findAll();
    }
    public void addMovies(Movie movie){
        movieRepository.save(movie);
    }
    public void updateMovies(Movie newMovie, Integer id){
        Movie oldMovie = movieRepository.findById(id).get();
        oldMovie.setName(newMovie.getName());
        oldMovie.setGenre(newMovie.getGenre());
        oldMovie.setRating(newMovie.getRating());
        oldMovie.setDuration(newMovie.getDuration());
        oldMovie.setLaunchDate(newMovie.getLaunchDate());
        movieRepository.save(oldMovie);
    }
    public void deleteMovies(Integer id){
        movieRepository.deleteById(id);
    }
}