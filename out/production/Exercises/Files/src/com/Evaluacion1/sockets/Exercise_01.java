package com.Evaluacion1.sockets;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exercise_01 {
    public static void main(String[] args) throws UnknownHostException {
        //TASK: Show IP from our computer.

        InetAddress net = InetAddress.getLocalHost();
        System.out.println(net);
    }
}