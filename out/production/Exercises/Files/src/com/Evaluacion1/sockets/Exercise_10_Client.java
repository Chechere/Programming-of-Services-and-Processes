package com.Evaluacion1.sockets;

import java.io.IOException;
import java.net.*;

public class Exercise_10_Client {
    public static void main(String[] args) throws IOException {
        //TODO Create a UDP Server.

        DatagramSocket UDPServer = new DatagramSocket();
        InetAddress host = InetAddress.getLocalHost();
        int port = 8081;
        byte[] message = "Text to send".getBytes();
        DatagramPacket petition = new DatagramPacket(message, message.length, host, port);

        UDPServer.send(petition);

        byte[] buffer = new byte[20];
        DatagramPacket answer = new DatagramPacket(buffer, buffer.length);
        UDPServer.receive(answer);

        System.out.println(new String(answer.getData()));

        UDPServer.close();
    }
}