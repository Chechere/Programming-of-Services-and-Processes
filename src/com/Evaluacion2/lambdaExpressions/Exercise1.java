package com.Evaluacion2.lambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Exercise1 {

    public static void main(String[] args) {
        int n1 = 3, n2 = 5;

        ((Interfaz1)(a, b) -> System.out.println(a * b)).operate(n1, n2);
        ((Interfaz1)(a, b) -> System.out.println(a + b)).operate(n1, n2);

        System.out.println();
        new Thread(() -> {
            for(int i = 0; i <= 5; i++) {
                System.out.println(i);
            }
        }).start();

        System.out.println("\nEjercicio 2:");
        if(((Interfaz2)(n) -> n % 2 == 0).parOImpar(n1)) {
            System.out.println(n1 + " es par");
        } else {
            System.out.println(n1 + " es impar");
        }

        /*Java provee con varias interfaces que ya vienen con entradas de datos
          como el ejercicio de arriba que necesita un numero n. Ahora repito el
          ejercicio con estas interfaces prehechas.
        */

        if(((Predicate<Integer>)(n) -> n % 2 == 0).test(n1)) {
            System.out.println(n1 + " es par");
        } else {
            System.out.println(n1 + " es impar");
        }


        //----------------------------------------------------------
        System.out.println();
        List<String> nombres = new ArrayList<String>();

        nombres.add("Peter");
        nombres.add("Gerhard");
        nombres.add("Philip");
        nombres.add("John");

        nombres.forEach((s) -> System.out.println(s));

        System.out.println();
        List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona("Peter", "Griffin", 34));
        personas.add(new Persona("Homer", "Simpson", 41));
        personas.add(new Persona("Tortilla", "Patata", 10));
        personas.add(new Persona("Bicarbonato", "Sodico", 81));
        personas.add(new Persona("Ultima", "Columna", 1));

        System.out.println("Apellidos ordenados:");
        personas.stream().sorted((p1, p2) -> p1.getApellido().compareTo(p2.getApellido())
        ).forEach((p) -> System.out.println(p));

        System.out.println("Solo los apellidos que empiezan por C:");
        personas.stream().filter((p) -> p.getApellido().startsWith("C")
        ).forEach((p) -> System.out.println(p));
    }
}

interface Interfaz1 {
    void operate(int a, int b);
}

interface Interfaz2 {
    boolean parOImpar(int n);
}

class Persona {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString() {
        return String.format("Persona [Nombre = %s, Apellido = %s, Edad = %d]\n", nombre, apellido, edad);
    }
}