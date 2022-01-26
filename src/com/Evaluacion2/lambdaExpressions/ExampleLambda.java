package com.Evaluacion2.lambdaExpressions;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ExampleLambda {
    public static void main(String[] args) {
        System.out.println("Primer lambda");
        new Thread(() -> System.out.println("HOLA")).start();

        System.out.println("Segundo lambda");
        System.out.println("Forma primitiva");
        int[] nums = {1, 2, 3, 4, 5};

        for(int num : nums) {
            System.out.print(num + ", ");
        }

        System.out.println("\n\nForma labmda");
        ArrayList<Integer> numsLambda = new ArrayList<Integer>();
        numsLambda.add(1);
        numsLambda.add(2);
        numsLambda.add(3);
        numsLambda.add(4);
        numsLambda.add(5);

        numsLambda.forEach((Integer num) -> System.out.print(num + ", "));
        //Se puede resumir mas quitando "Integer" del parentesis.

        /* Para hacer lambda necesitamos una interfaz (Como Runnable) para ello.
        *  La interfaz que usamos aqui es la interfaz Consumer.
        *  Este es el código que resume lambda.
        *
        *  numsLambda.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
           });
        * */

        /*La última forma de simplificarlo sera: numsLambda.forEach(System.out::println);
        * Que basicamente simplifica funciones que solo hacen una cosa.
        * En nuestro caso escribir el siguiente numero de la lista.
        * No funciona con funciones que hacen varias cosas.*/
    }
}