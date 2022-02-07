package com.Evaluacion1.CalculatorAndWebServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class Exercise_07_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        PrintStream output = new PrintStream(socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        String action = "";
        boolean error = false;
        double number = 0;

        do {
            do {
                error = false;

                try {
                    System.out.print("Send the first number: ");
                    number = sc.nextDouble();
                }catch (InputMismatchException e) {
                    System.out.println("Error! wrong format. Correct format: 5,75.");
                    error = true;
                }

                sc.nextLine();
            }while(error);

            output.println(String.valueOf(number));

            do {
                error = false;

                try {
                    System.out.print("Send the second number: ");
                    number = sc.nextDouble();
                }catch (InputMismatchException e) {
                    System.out.println("Error! wrong format. Correct format: 5,75.");
                    error = true;
                }

                sc.nextLine();
            }while(error);
            output.println(String.valueOf(number));

            sc.nextLine();
            System.out.print("Send the operation: ");
            output.println(sc.nextLine());

            System.out.println(br.readLine());

            System.out.print("Write 'end' to finish: ");
            action = sc.nextLine();
            output.println(action);
        }while(!action.equals("end"));

        br.close();
        output.close();
        socket.close();
        sc.close();
    }
}
