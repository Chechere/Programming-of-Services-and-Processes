package com.Evaluacion1.sockets;

import java.io.IOException;
import java.net.*;

public class Exercise_04 {
    public static void main(String[] args) throws IOException {
        //TASK: Find open ports from a specific IP.
        for(int i = 1; i < 450; i++) {
            try {
                SocketAddress sockaddr = new InetSocketAddress("192.168.2.216", i);
                Socket socket = new Socket();
                socket.connect(sockaddr, 20);

                if(socket.isConnected()) {
                    System.out.println("Open port: " + i);
                }

                socket.close();
            }catch (SocketTimeoutException e) {
            }catch (SocketException e) {
            }
        }
    }
}
