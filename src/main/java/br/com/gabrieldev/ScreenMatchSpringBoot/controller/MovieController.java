package br.com.gabrieldev.ScreenMatchSpringBoot.controller;

import br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie.Movie;
import br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie.MovieData;
import br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie.MovieRepository;
import br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie.MovieUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping("/form")
    public String loadMovieForm(Long id, Model model) {
        if (id != null) {
            Movie movie = repository.getReferenceById(id);
            model.addAttribute("movie", movie);
        }

        return "movies/form";
    }

    @GetMapping
    public String loadListMovies(Model model) {
        model.addAttribute("movies", repository.findAll());

        return "movies/list";
    }

    @PostMapping
    @Transactional
    public String createMovie(MovieData movieData) {
        Movie movie = new Movie(movieData);
        repository.save(movie);

        return "redirect:/movies";
    }

    @PutMapping
    @Transactional
    public String updateMovie(MovieUpdateData movieUpdateData) {
        Movie movie = repository.getReferenceById(movieUpdateData.id());

        movie.updateRecord(movieUpdateData);

        return "redirect:/movies";
    }

    @DeleteMapping
    @Transactional
    public String deleteMovie(Long id) {
        repository.deleteById(id);

        return "redirect:/movies";
    }

}
