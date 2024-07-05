package com.Wilmer.Screenmatch;

import com.Wilmer.Screenmatch.Conections.ConectionApi;
import com.Wilmer.Screenmatch.Conections.ConvierteDatos;
import com.Wilmer.Screenmatch.Model.DatosEpisodios;
import com.Wilmer.Screenmatch.Model.DatosSerie;
import com.Wilmer.Screenmatch.Model.DatosTemporadass;
import com.Wilmer.Screenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraMenu();
	}
}
