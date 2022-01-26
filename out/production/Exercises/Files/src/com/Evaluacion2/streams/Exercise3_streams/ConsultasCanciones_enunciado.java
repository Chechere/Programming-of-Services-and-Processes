package com.Evaluacion2.streams.Exercise3_streams;

import java.util.*;
import java.util.stream.Collectors;

public class ConsultasCanciones_enunciado {
    List<Cancion> canciones;

    public ConsultasCanciones_enunciado() {
        canciones = new ArrayList<>(
                Arrays.asList(
                        new Cancion("Livin' on Prayer", "Bon Jovi"),
                        new Cancion("Long Hot Summer", "Keith Urban"),
                        new Cancion("It's my Life", "Bon Jovi"),
                        new Cancion("Dolor Fantasma", "Amadeus"),
                        new Cancion("Run To You", "Bryan Adams"),
                        new Cancion("Summer of 69", "Bryan Adams"),
                        new Cancion("Paranoid", "Black Sabbath"),
                        new Cancion("Cherokee", "Europe"),
                        new Cancion("River Bank", "Brad Paisley")
                )
        );
        procesarStreams();
    }

    private void procesarStreams() {
        System.out.println("*** Implementa la función filtrar Cantante utilizando foreach e ifs  ***");
        for (Cancion cancion : filtrarCantante(canciones, "Bon Jovi")) {
            System.out.println("Tradicional: " + cancion.getTitulo());
        }

        System.out.println();
        System.out.println("*** Implementa la función filtrar Cantante utilizando utilizando streams  ***");
        for (Cancion cancion : filtrarCantanteStream(canciones, "Bon Jovi")) {
            System.out.println("Stream: " + cancion.getTitulo());
        }
    }

    public List<Cancion> filtrarCantante(List<Cancion> canciones, String cantante) {
        List<Cancion> filtradas = new ArrayList<Cancion>();

        for(Cancion cancion : canciones) {
            if(cancion.cantante.equals(cantante)) filtradas.add(cancion);
        }

        return filtradas;
    }

    private  List<Cancion> filtrarCantanteStream(List<Cancion> canciones, String cantante) {
        return canciones.stream()
                        .filter(cancion -> cancion.cantante.equals(cantante))
                        .toList();
    }
}