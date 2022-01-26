package com.Evaluacion1.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_11_Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //TODO Create a complex Server that can add, remove and change an array of contacts.
        Scanner sc = new Scanner(System.in);
        String action = "";

        do {
            Socket socket = new Socket("localhost", 8081);
            ObjectOutputStream cMessages = new ObjectOutputStream(socket.getOutputStream()); // To send objects through it
            ObjectInputStream sMessages = new ObjectInputStream(socket.getInputStream());
            List<String> messages = new ArrayList<String>();

            messages.add("get");
            cMessages.writeObject(messages);
            messages.clear();
            messages = (List<String>) sMessages.readObject();
            for(String s : messages) {
                System.out.println(s);
            }

            socket.close();
            messages.clear();

            System.out.print("\nSelect ([A]dd, [R]emove, [C]hange, [E]nd): ");
            action = sc.nextLine();

            socket = new Socket("localhost", 8081);
            cMessages = new ObjectOutputStream(socket.getOutputStream()); // To send objects through it
            sMessages = new ObjectInputStream(socket.getInputStream());

            switch (action.toLowerCase()) {
                case "a":
                case "add":
                    messages.add("add");
                    System.out.print("Name of contact: ");
                    messages.add(sc.nextLine());
                    System.out.print("Number of contact: ");
                    messages.add(String.valueOf(sc.nextInt()));

                    cMessages.writeObject(messages);
                    break;
                case "r":
                case "remove":
                    messages.add("remove");
                    System.out.print("Name of contact: ");
                    messages.add(sc.nextLine());

                    cMessages.writeObject(messages);
                    break;
                case "c":
                case "change":
                    messages.add("change");
                    break;
                case "end":
                    System.out.println("Connection finished.");
                default:
                    messages.clear();
                    messages.add("wrong");
                    cMessages.writeObject(messages);
                    System.out.println("Wrong action. Please repeat.");
                    break;
            }

            socket.close();
            messages.clear();
        }while(!action.toLowerCase().equals("end"));

        /*List<String> messages = new ArrayList<String>();
        messages.add("Hello from the other side!");
        messages.add("How are you doing?");
        messages.add("What time is it?");
        messages.add("Hi hi hi hi.");

        System.out.println("Sending messages to the ServerSocket");
        cMessages.writeObject(messages);

        System.out.println("Closing socket and terminating program.");
        socket.close();*/
    }
}

