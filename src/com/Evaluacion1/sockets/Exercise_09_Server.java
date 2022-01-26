package com.Evaluacion1.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Exercise_09_Server {
    public static void main(String[] args) throws IOException {
        //Web Server.
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket client;
        PrintStream output;
        InputStreamReader clientInput;
        BufferedReader htmlReader, clientMessages;
        String input = "";
        ArrayList<String> messages = new ArrayList<String>();

        while(true) {
            client = serverSocket.accept();
            System.out.println("Se ha conectado un cliente.");
            output = new PrintStream(client.getOutputStream(), true);
            htmlReader = new BufferedReader(new FileReader("src/prueba.html"));
            clientInput = new InputStreamReader(client.getInputStream());
            clientMessages = new BufferedReader(clientInput);


            while(clientInput.ready()) {
                input = clientMessages.readLine();

                if(input.startsWith("GET /list?")) {
                    messages.add(input.substring(input.indexOf("textbox=") + 8, input.indexOf('&')));
                }

                output.println("HTTP/1.1 200 OK");
                output.println("Content-Type: text/html");
                output.println("");

                while((input = htmlReader.readLine()) != null) {
                    output.println(input);

                    if(input.trim().startsWith("<h1>")) {
                        for(String s: messages) {
                            output.println("<p>" + s + "</p>");
                        }
                    }
                }
            }

            client.close();
        }
    }
}
