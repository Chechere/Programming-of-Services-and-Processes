package com.Evaluacion2.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Theory1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jack", "Jacob");
        /*
            Print Hello <name> for each element.
            Update the list adding "Captain" for each name.
            Print the name that start with "Ja".
            List only even numbers,
        */

        names.forEach(name -> System.out.println("Hello " + name + "."));
        System.out.println();

        List<String> captains = names.stream()
                                     .map(name -> "Captain " + name)
                                     .toList();
        captains.forEach(captain -> System.out.println("Hello " + captain + "."));
        System.out.println();

        String jaName = names.stream()
                             .filter(name -> name.startsWith("Ja"))
                             .findFirst()
                             .orElse("No hay ningun nombre que empieze por Ja");
        System.out.println(jaName + "\n");

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> pares = nums.stream().filter(i -> i % 2 == 0).toList();
        pares.forEach(System.out::println);

        //int suma = nums.stream().mapToInt(Integer::intValue).sum();
        //int suma = nums.stream().mapToInt((i -> Integer.valueOf(i))).sum();
        int suma = nums.stream().mapToInt((i -> i)).sum();
        double avg = nums.stream().mapToInt(i->i).average().getAsDouble();
    }
}