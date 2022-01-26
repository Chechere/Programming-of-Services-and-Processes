package com.Evaluacion2.agify;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.*;

public class agifyFuture {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        agifyThread sergio = new agifyThread("Sergio");
        agifyThread pablo = new agifyThread("Pablo");
        agifyThread nico = new agifyThread("Nicolas");
        agifyThread cesar = new agifyThread("Cesar");

        ExecutorService ex = Executors.newFixedThreadPool(4);

        Future<Persona> result1 = ex.submit(sergio);
        Future<Persona> result2 = ex.submit(pablo);
        Future<Persona> result3 = ex.submit(nico);
        Future<Persona> result4 = ex.submit(cesar);

        System.out.println(result1.get().getNombre() + ": " + result1.get().getEdad());
        System.out.println(result2.get().getNombre() + ": " + result2.get().getEdad());
        System.out.println(result3.get().getNombre() + ": " + result3.get().getEdad());
        System.out.println(result4.get().getNombre() + ": " + result4.get().getEdad());

        ex.shutdown();
    }
}

class agifyThread implements Callable<Persona> {
    String name;
    String url;

    public agifyThread(String name) throws IOException {
        this.name = name;
        this.url = "https://api.agify.io/?name=" + name;
    }

    @Override
    public Persona call() throws Exception {
        Persona result = null;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String respuesta = response.body();
            String edad = respuesta.substring(respuesta.indexOf("age") + 5, respuesta.indexOf(",\"count"));
            result = new Persona(name, Integer.valueOf(edad));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
}