package com.Evaluacion1.threads;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise_03_Server {
    public static void main(String[] args) throws IOException {
        while(true) {
            ServerSocket server = new ServerSocket(8833);
            Socket client = server.accept();

            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            PrintStream writer = new PrintStream(client.getOutputStream(), true);
        }
    }
}