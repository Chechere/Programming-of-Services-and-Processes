package com.Evaluacion1.FizzBuzz;

public class FizzBuzz {
    public static void main(String[] args) {
        int lenght = 100;

        /*for(int i = 1; i <= lenght; i++) {
            String result = "";

            result += (i % 3 == 0) ? "Fizz" : "";
            result += (i % 5 == 0) ? "Buzz" : "";
            result += (result.isEmpty()) ? i : "";


            System.out.println(result);
        }*/

        for(int i = 1; i <= lenght; i++) {
            int n = 0;

            if(i % 3 == 0) {
                System.out.print("Fizz");
                n++;
            }

            if(i % 5 == 0) {
                System.out.print("Buzz");
                n++;
            }

            if(n == 0) System.out.print(i);

            System.out.println();
        }
    }
}
