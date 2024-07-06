package com.Wilmer.Screenmatch.principal;

import com.Wilmer.Screenmatch.Conections.ConectionApi;
import com.Wilmer.Screenmatch.Conections.ConvierteDatos;
import com.Wilmer.Screenmatch.Model.DatosEpisodios;
import com.Wilmer.Screenmatch.Model.DatosSerie;
import com.Wilmer.Screenmatch.Model.DatosTemporadass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private ConectionApi consulta = new ConectionApi();
    private Scanner tecladoEntrada = new Scanner(System.in);
    private final String urlConsulta ="http://www.omdbapi.com/?t=";
    private final String apikey = "&apikey=9d2ac174";
    private final String identidadTemporada="&season=";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu(){
        var nombreSerie="";
        System.out.println("escribe el nombre de la serie que deseas buscar: ");
        nombreSerie = tecladoEntrada.nextLine().replace(" ", "+");
        var json = consulta.consumoApi(urlConsulta+nombreSerie+apikey);
        System.out.println(urlConsulta+nombreSerie+apikey);
        var datosSeires = conversor.convierteDatos(json, DatosSerie.class);
        List<DatosTemporadass> temporadasLista = new ArrayList<>();
        for (int i = 1; i <= datosSeires.totalDeTemporadas(); i++) {
            var jsonTemporadas = consulta.consumoApi(urlConsulta+nombreSerie+identidadTemporada+i+apikey);
            DatosTemporadass datosDeLaTemporaeda = conversor.convierteDatos(jsonTemporadas, DatosTemporadass.class);
            temporadasLista.add(datosDeLaTemporaeda);
        }
        temporadasLista.forEach(System.out::println);
        //mostrar solo el titulo de cada episodio y cada temporada
        for (int i = 0; i < datosSeires.totalDeTemporadas(); i++) {
            List<DatosEpisodios> episodiostemporadas = temporadasLista.get(i).listaDeEpsiodios();
            for (int j = 0; j < episodiostemporadas.size(); j++) {
                System.out.println("episodio: "+j+episodiostemporadas.get(j).Titulo());
            }
        }

        temporadasLista.forEach(t->t.listaDeEpsiodios().forEach(e-> System.out.println("con funciones lamda" + e.Titulo())));
    }
}
