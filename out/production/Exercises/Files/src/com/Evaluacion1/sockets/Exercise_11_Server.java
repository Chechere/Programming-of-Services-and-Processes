package com.Evaluacion1.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Exercise_11_Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8081);
        List<String> contactsnames = new ArrayList<String>();
        List<Integer> contactsnumbers = new ArrayList<Integer>();
        List<String> listMessages = new ArrayList<String>(); //=(List<String>)cMessages.readObject();

        while(true) {
            Socket client = serverSocket.accept();
            ObjectInputStream cMessages = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream sMessages = new ObjectOutputStream(client.getOutputStream());

            listMessages = (List<String>) cMessages.readObject();
            switch (listMessages.get(0)) {
                case "add":
                    contactsnames.add(listMessages.get(1));
                    contactsnumbers.add(Integer.valueOf(listMessages.get(2)));
                    break;
                case "remove":
                    int pos = contactsnames.indexOf(listMessages.get(1));

                    contactsnames.remove(pos);
                    contactsnumbers.remove(pos);
                    break;
                case "change":
                    break;
                case "get":
                    listMessages.clear();

                    for(int i = 0; i < contactsnames.size(); i++) {
                            listMessages.add(contactsnames.get(i) + ": " + contactsnumbers.get(i));
                    }

                    sMessages.writeObject(listMessages);
                    break;
            }

            client.close();
        }
    }
}
