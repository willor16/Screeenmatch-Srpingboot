package com.Wilmer.Screenmatch;

import com.Wilmer.Screenmatch.Conections.ConectionApi;
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
		var  respuesta =conexion.consumoApi("http://www.omdbapi.com/?t=game+of+thrones&season=1&episode=1&apikey=9d2ac174");
		System.out.println(respuesta);
	}
}
