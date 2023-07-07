package br.com.gabrieldev.ScreenMatchSpringBoot.domain.movie;

public record MovieUpdateData(Long id, String name, Integer duration, Integer year, String category) {
}
