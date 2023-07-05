package br.com.gabrieldev.ScreenMatchSpringBoot.controller;

import br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie.Movie;
import br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie.MovieData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private List<Movie> movies = new ArrayList<>();

    @GetMapping("/form")
    public String loadMovieForm() {
        return "movies/form";
    }

    @GetMapping
    public String loadListMovies(Model model) {
        model.addAttribute("movies", movies);

        return "movies/list";
    }

    @PostMapping
    public String createMovie(MovieData movieData) {
        Movie movie = new Movie(movieData);
        movies.add(movie);

        return "redirect:/movies";
    }
}
