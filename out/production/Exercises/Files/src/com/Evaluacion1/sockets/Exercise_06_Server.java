package com.Evaluacion1.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise_06_Server {
    public static void main(String[] args) throws IOException {
        //'Echo' server. takes and return a message to the client.
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket client = serverSocket.accept(); //Block the app until receives a connection and accept it.

        InputStreamReader isr = new InputStreamReader(client.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        PrintStream output = new PrintStream(client.getOutputStream(), true);

        String message = br.readLine(); //Also blocks the app until receives the message.
        output.println(message.toUpperCase());

        client.close();
        br.close();
        output.close();
        serverSocket.close();
    }
}
