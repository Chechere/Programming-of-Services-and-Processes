package com.Evaluacion1.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class Exercise_03 {
    public static void main(String[] args) throws IOException {
        //TASK: Get HTML from a specific URL.

        URL link = new URL("http://www.google.com/");
        BufferedReader br = new BufferedReader(new InputStreamReader(link.openStream()));
        String line = br.readLine();

        while (line != null){
            System.out.println(line);
            line = br.readLine();
        }

        br.close();
    }
}
