package com.Wilmer.Screenmatch.principal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploConStream {
    public void ejemploStream(){
        List<String> listaNombresEjemplo = Arrays.asList("Wilmer", "Abigail", "Luisa", "Gabriela", "Marielos", "Anastasia", "Dasha", "Isabel");
         listaNombresEjemplo.stream()
                 .sorted()
                 .filter(n-> n.startsWith("I"))
                 .limit(7)
                 .forEach(System.out::println);
    }
}
