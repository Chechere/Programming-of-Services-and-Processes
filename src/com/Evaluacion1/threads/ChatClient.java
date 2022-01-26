package com.Evaluacion1.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost", 8808);

        new Thread(new ChatClientThreadReader(server)).start();
        new Thread(new ChatClientThreadWriter(server)).start();
    }
}

class ChatClientThreadReader implements Runnable {
    Socket server;
    BufferedReader reader;

    public ChatClientThreadReader(Socket server) throws IOException {
        this.server = server;
        InputStreamReader isr = new InputStreamReader(server.getInputStream());
        reader = new BufferedReader(isr);
    }
    @Override
    public void run() {
        try {
            while (true) {
                String str = reader.readLine();
                System.out.println(str);
            }
        }catch(IOException e) {
            if(server.isClosed()) System.out.println("Connection ended.");
            else e.printStackTrace();
        }
    }
}

class ChatClientThreadWriter implements Runnable {
    Socket server;
    PrintStream writer;

    public ChatClientThreadWriter(Socket server) throws IOException {
        this.server = server;
        writer = new PrintStream(server.getOutputStream(), true);
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String line;
        do {
            System.out.print("Escribe algo o 'exit': ");
            line = sc.nextLine();
            writer.println(line);
        } while(!line.equals("exit"));

        try {
            sc.close();
            writer.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
