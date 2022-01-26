package com.Evaluacion2.streams.Exercise3_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConsultasAlumnos_enunciado {
    List<Alumno> listaAlumnos = new ArrayList<>();

    public ConsultasAlumnos_enunciado() {
        // Cargamos la lista de Alumnos
        listaAlumnos.add(new Alumno(1, "1717213183", "Javier", "Molina Cano", "Java 8", 7, 28));
        listaAlumnos.add(new Alumno(2, "1717456218", "Ana", "Gómez Álvarez", "Java 8", 10, 33));
        listaAlumnos.add(new Alumno(3, "1717328901", "Pedro", "Marín López", "Java 8", 8.6, 15));
        listaAlumnos.add(new Alumno(4, "1717567128", "Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        listaAlumnos.add(new Alumno(5, "1717902145", "Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        listaAlumnos.add(new Alumno(6, "1717678456", "Germán", "López Fernández", "Java 8", 8, 34));
        listaAlumnos.add(new Alumno(7, "1102156732", "Oscar", "Murillo González", "Java 8", 10, 32));
        listaAlumnos.add(new Alumno(8, "1103421907", "Antonio Jesús", "Palacio Martínez", "PHP", 9.5, 17));
        listaAlumnos.add(new Alumno(9, "1717297015", "César", "González Martínez", "Java 8", 8, 26));
        listaAlumnos.add(new Alumno(10, "1717912056", "Gloria", "González Castaño", "PHP", 10, 28));
        listaAlumnos.add(new Alumno(11, "1717912058", "Jorge", "Ruiz Ruiz", "Python", 8, 22));
        listaAlumnos.add(new Alumno(12, "1717912985", "Ignacio", "Duque García", "Java Script", 9.4, 32));
        listaAlumnos.add(new Alumno(13, "1717913851", "Julio", "González Castaño", "C Sharp", 10, 22));
        listaAlumnos.add(new Alumno(14, "1717986531", "Gloria", "Rodas Carretero", "Ruby", 7, 18));
        listaAlumnos.add(new Alumno(15, "1717975232", "Jaime", "Jiménez Gómez", "Java Script", 10, 18));

        procesarStreams();
    }

    private void procesarStreams() {
        System.out.println("*** Lista de Alumnos ***");
        listaAlumnos.forEach(System.out::println);

        System.out.println("\n*** Alumnos cuyo apellido empiezan con el caracter L u G ***");
        listaAlumnos.stream().filter(alumno ->  alumno.getApellidos().startsWith("L") ||
                                                alumno.getApellidos().startsWith("G"))
                             .forEach(System.out::println);

        System.out.println("\n**** Número de Alumnos ***");
        long count = listaAlumnos.stream().count(); //En este ejercicio es obligatorio usar .count().
        System.out.println(count);

        System.out.println("\n**** Alumnos con nota mayor a 9 y que sean del curso PHP ***");
        listaAlumnos.stream().filter(alumno -> alumno.getNota() > 9)
                             .filter(alumno -> alumno.getNombreCurso().equals("PHP"))
                             .forEach(System.out::println);

        System.out.println("\n**** Imprimir los 2 primeros Alumnos de la lista ***");
        listaAlumnos.stream().limit(2).forEach(System.out::println);

        System.out.println("\n**** Imprimir el alumno con menor edad ***");
        listaAlumnos.stream()
                    .filter(alumno -> alumno.getEdad() == listaAlumnos.stream()
                                                                      .mapToInt(Alumno::getEdad)
                                                                      .min()
                                                                      .orElse(-1))
                    .forEach(System.out::println);

        System.out.println("\n**** Imprimir el alumno con mayor edad ***");
        listaAlumnos.stream()
                    .filter(alumno -> alumno.getEdad() == listaAlumnos.stream()
                                                                      .mapToInt(Alumno::getEdad)
                                                                      .max()
                                                                      .orElse(-1))
                    .forEach(System.out::println);
        System.out.println("\n**** Encontrar el decimocuarto Alumno***");
        int id = 14;
        listaAlumnos.stream()
                    .filter(alumno -> alumno.getId() == id)
                    .forEach(System.out::println);

        System.out.println("\n**** Alumnos que tienen un curso en el que el nombre contienen la A ***");
        listaAlumnos.stream()
                    .filter(alumno -> alumno.getNombreCurso().contains("a"))
                    .forEach(System.out::println);

        System.out.println("\n**** Alumnos en que la longitud de su nombre es mayor a 10 caracteres ***");
        listaAlumnos.stream()
                    .filter(alumno -> alumno.getNombre().length() > 10)
                    .forEach(System.out::println);

    }


}
