package com.Evaluacion1.CalculatorAndWebServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise_09_Server {
    public static void main(String[] args) throws IOException {
        //Web Server.
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket client;
        PrintStream output;
        BufferedReader br;
        String input = "";

        while(true) {
            client = serverSocket.accept();
            output = new PrintStream(client.getOutputStream(), true);
            br = new BufferedReader(new FileReader("src/prueba.html"));

            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html");
            output.println("");

            while((input = br.readLine()) != null) {
                output.println(input);
            }

            client.close();
        }
    }
}
