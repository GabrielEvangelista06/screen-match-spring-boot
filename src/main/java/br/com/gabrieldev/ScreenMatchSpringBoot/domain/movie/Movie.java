package br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie;

public class Movie {
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
