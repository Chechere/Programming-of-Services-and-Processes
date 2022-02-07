package com.Evaluacion1.EchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Exercise_05 {
    public static void main(String[] args) throws IOException {
        //Use Socket to connect an especific URL and port and write what it sends;

        Socket time = new Socket("time.nist.gov", 13);

        if(time.isConnected()) {
            InputStreamReader isr = new InputStreamReader(time.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String line = null;

            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        time.close();
    }
}
