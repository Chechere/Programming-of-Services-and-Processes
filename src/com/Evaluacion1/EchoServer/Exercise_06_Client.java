package com.Evaluacion1.EchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Exercise_06_Client {
    public static void main(String[] args) throws IOException {
        //Create and use an 'echo' server.
        Socket socket = new Socket("localhost", 5000);
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        PrintStream output = new PrintStream(socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);
        String word = "";

        do {
            System.out.println("Type a message: ");
            word = sc.nextLine();

            output.println(word); //Sends the message to the server
            System.out.println(br.readLine()); //Receive the same message and write it.
        }while(!word.equals(""));

        br.close();
        output.close();
        socket.close();
        sc.close();

        System.out.println("End");

    }
}
