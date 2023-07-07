package br.com.gabrieldev.ScreenMatchSpringBoot.controller;

import br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie.Movie;
import br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie.MovieData;
import br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping("/form")
    public String loadMovieForm() {
        return "movies/form";
    }

    @GetMapping
    public String loadListMovies(Model model) {
        model.addAttribute("movies", repository.findAll());

        return "movies/list";
    }

    @PostMapping
    public String createMovie(MovieData movieData) {
        Movie movie = new Movie(movieData);
        repository.save(movie);

        return "redirect:/movies";
    }

    @DeleteMapping
    public String deleteMovie(Long id) {
        repository.deleteById(id);

        return "redirect:/movies";
    }
}
