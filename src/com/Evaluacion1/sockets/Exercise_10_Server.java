package com.Evaluacion1.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Exercise_10_Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket UDPSocket = new DatagramSocket(8081);
        byte[] buffer = new byte[20];

        while(true) {
            DatagramPacket petition = new DatagramPacket(buffer, buffer.length);
            UDPSocket.receive(petition);

            String message = "Text to Send.";
            DatagramPacket answer = new DatagramPacket(message.getBytes(), message.length(), petition.getAddress(), petition.getPort());
            UDPSocket.send(answer);
        }
    }
}
