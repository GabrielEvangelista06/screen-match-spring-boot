package br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer durationInMinutes;
    private Integer releaseYear;
    private String category;

    public Movie(MovieData movieData) {
        this.name = movieData.name();
        this.durationInMinutes = movieData.duration();
        this.releaseYear = movieData.year();
        this.category = movieData.category();
    }

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getCategory() {
        return category;
    }

    public void updateRecord(MovieUpdateData movieUpdateData) {
        this.name = movieUpdateData.name();
        this.durationInMinutes = movieUpdateData.duration();
        this.releaseYear = movieUpdateData.year();
        this.category = movieUpdateData.category();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", releaseYear=" + releaseYear +
                ", category='" + category + '\'' +
                '}';
    }
}
