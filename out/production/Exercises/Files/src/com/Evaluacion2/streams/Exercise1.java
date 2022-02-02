package com.Evaluacion2.streams;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jack", "Jacob");

        //Say hello to all names.
        names.forEach(name -> System.out.println("Hello " + name));
        System.out.println();

        //Make captain to all names
        List<String> captains = names.stream().map(name -> "Captain " + name).toList();
        captains.forEach(System.out::println);
        System.out.println();

        //Show names that start with "Ja"
        names.stream().filter(name -> name.startsWith("Ja")).forEach(System.out::println);
        System.out.println();

        //Show even numbers. Calculate sum, avg, max and min.
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        nums.stream().filter(n -> n % 2==0).forEach(System.out::println);
        System.out.println();

        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        double avg = nums.stream().mapToInt(Integer::intValue).average().orElse(-1);
        int max = nums.stream().mapToInt(Integer::intValue).max().getAsInt();
        int min = nums.stream().mapToInt(Integer::intValue).min().getAsInt();

        System.out.printf("Sum: %d; Average: %.2f; Max: %d; Min: %d.", sum, avg, max, min);
    }
}
