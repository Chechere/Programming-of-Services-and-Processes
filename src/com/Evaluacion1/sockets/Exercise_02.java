package com.Evaluacion1.sockets;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Exercise_02 {
    public static void main(String[] args) throws UnknownHostException {
        //TASK: Show IP from a specific address.

        Scanner sc = new Scanner(System.in);
        InetAddress net;
        String domain;

        System.out.print("Write domain or 'exit' to end: ");
        domain = sc.nextLine();

        while(!domain.equalsIgnoreCase("exit")) {
            try {
                net = InetAddress.getByName(domain);

                System.out.println("Ip from domain (" + domain + "): " + net);
            }catch(UnknownHostException e) {
                System.out.println("Error! Wrong domain or no exist domain: " + domain);
            }

            System.out.print("Write domain or 'exit' to end: ");
            domain = sc.nextLine();
        }
    }
}
