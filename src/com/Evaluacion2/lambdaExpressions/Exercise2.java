package com.Evaluacion2.lambdaExpressions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise2 {
    public static void main(String[] args) {
        int[] nums1 = {5, 3};
        int result = Arrays.stream(nums1).sum();
        System.out.println("Ejercicio 1: " + result);



        int n3 = 15;
        result = IntStream.rangeClosed(1, n3)
                          .filter(n -> n % 3 == 0 || n % 5 == 0)
                          .sum();
        System.out.println("Ejercicio 2: " + result);



        int n4 = 5;
        result = IntStream.range(0, n4+1).sum();
        System.out.println("Ejercicio 3: " + result);



        int n5 = 3;
        final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        result = IntStream.range(0, nums.length)
                          .filter(i -> nums[i] == n5)
                          .findFirst()
                          .orElse(-1);

        if(result < 0) System.out.println("Ejercicio 4: El numero no esta dentro del array");
        else System.out.println("Ejercicio 4: El numero " + n5 + " esta en la posicion " + result);



        String s1 = "java interview";
        String resultStr = new StringBuilder(s1).reverse().toString();
        System.out.println("Ejercicio 5: El inverso de \"" + s1 + "\" es \"" + resultStr + "\"");



        int[] nums2 = new int[] {1, 2, 3, 4, 5, 6, 24, 7, 8, 9, 10};
        result = Arrays.stream(nums2).max().getAsInt();
        System.out.println("Ejercicio 6: " + result);



        double[] doubles = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double resultDouble = Arrays.stream(doubles).average().getAsDouble();
        System.out.println("Ejercicio 7: " + resultDouble);



        String[] strs = {"Hola", "Adios", "Buenas"};
        System.out.print("Ejercicio 8: ");
        Arrays.stream(strs).forEach(s -> System.out.print(s + ", "));
        System.out.println();
        Arrays.stream(strs).map(s -> s.toUpperCase()).forEach(s -> System.out.print(s + ", "));
    }
}