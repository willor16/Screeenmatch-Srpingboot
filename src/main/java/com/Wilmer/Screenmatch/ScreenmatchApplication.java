package com.Wilmer.Screenmatch;

import com.Wilmer.Screenmatch.Conections.ConectionApi;
import com.Wilmer.Screenmatch.Conections.ConvierteDatos;
import com.Wilmer.Screenmatch.Model.DatosEpisodios;
import com.Wilmer.Screenmatch.Model.DatosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//probando conexion
		var conexion = new ConectionApi();
		var  json =conexion.consumoApi("http://www.omdbapi.com/?t=game+of+thrones&apikey=9d2ac174");
		ConvierteDatos conversor = new ConvierteDatos();
		var datos = conversor.convierteDatos(json, DatosSerie.class);
		System.out.println("con metodo donversor de datos "+datos);
		json = conexion.consumoApi("http://www.omdbapi.com/?t=game+of+thrones&season=1&episode=1&apikey=9d2ac174");
		DatosEpisodios datosEpisodios = conversor.convierteDatos(json, DatosEpisodios.class);
		System.out.println("datos de los episodios: " + datosEpisodios);

	}
}
