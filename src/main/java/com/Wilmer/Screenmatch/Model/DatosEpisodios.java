package com.Wilmer.Screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodios(
        @JsonAlias("Title") String Titulo,
        @JsonAlias("Released") String fechadelanzamiento,
        @JsonAlias("Season") Integer temporada,
        @JsonAlias("Episode") Integer episodio

) {
}
