package com.example.movieratingsoftware.Controller;

import com.example.movieratingsoftware.Modle.Movie;
import com.example.movieratingsoftware.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    
    @GetMapping
    private ResponseEntity getMovies(){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovies());
    }

    @PostMapping
    private ResponseEntity addMovies(@RequestBody Movie movie){
        movieService.addMovies(movie);
        return ResponseEntity.status(HttpStatus.OK).body("Movie added !");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovies(@RequestBody Movie movie, @PathVariable Integer id){
        movieService.updateMovies(movie, id);
        return ResponseEntity.status(HttpStatus.OK).body("User update !");
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity deleteMovies(@PathVariable Integer id){
        movieService.deleteMovies(id);
        return ResponseEntity.status(HttpStatus.OK).body("User delete !");
    }
}
