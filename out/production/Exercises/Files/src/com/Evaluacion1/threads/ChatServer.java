package com.Evaluacion1.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8808);
        ChatServerBroadcaster broadcaster = new ChatServerBroadcaster();
        new Thread(broadcaster).start();

        while(true) {
            Socket socket = server.accept();
            ChatServerThread client = new ChatServerThread(socket, broadcaster);
            broadcaster.addClient(client);
            new Thread(client).start();
        }
    }
}

class ChatServerThread implements Runnable {
    Socket client;
    InputStreamReader isr;
    BufferedReader reader;

    public PrintStream writer;
    public String line = "";

    public ChatServerThread(Socket client, ChatServerBroadcaster broadcaster) throws IOException {
        this.client = client;
        isr = new InputStreamReader(client.getInputStream());
        reader = new BufferedReader(isr);
        writer = new PrintStream(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {

            while (!client.isClosed()) {

                line = reader.readLine();

                if(line.equals("exit")) {
                    client.close();
                    System.out.println("Connection ended.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ChatServerBroadcaster implements Runnable {
    static ArrayList<ChatServerThread> clients = new ArrayList<ChatServerThread>();
    String message = "";

    @Override
    public void run() {
        while(true) {
            int i = 0;
            while(i < clients.size() && clients.get(i).line.equals("")) {
                i++;
            }

            if(i < clients.size()) {

                for(ChatServerThread client : clients) {
                    if(client != clients.get(i)) client.writer.println(message);
                }

                clients.get(i).line = "";
            }
        }
    }

    public static void addClient(ChatServerThread client) {
        clients.add(client);
    }
}


class ChatServerReader implements Runnable {
    Socket client;
    BufferedReader reader;
    String line = "";

    public ChatServerReader(Socket client) throws IOException {
        this.client = client;
        InputStreamReader isr = new InputStreamReader(client.getInputStream());
        reader = new BufferedReader(isr);
    }

    @Override
    public void run() {

    }
}

class ChatServerWriter implements Runnable {
    Socket client;
    PrintStream writer;

    public ChatServerWriter(Socket client) throws IOException {
        this.client = client;
        writer = new PrintStream(client.getOutputStream(), true);
    }

    @Override
    public void run() {

    }
}
