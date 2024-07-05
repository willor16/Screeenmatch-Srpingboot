package com.Wilmer.Screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTemporadass(
        @JsonAlias("Title") String nombreTemporada,
        @JsonAlias("Season") Integer NumeroTemporada,
        @JsonAlias("Episodes") List<DatosEpisodios> listaDeEpsiodios

) {
}
