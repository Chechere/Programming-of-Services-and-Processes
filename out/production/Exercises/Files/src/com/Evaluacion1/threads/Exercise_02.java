package com.Evaluacion1.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Exercise_02 {
    public static void main(String[] args) {
        String[] names = {"cesar", "nicolas", "pablo", "sergio"};

        try{
            Thread.sleep(3000);

            for(String s : names) {
                new Thread(new URLRunnable(s)).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class URLRunnable implements Runnable {
    String name;

    public URLRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try {
            URLConnection request = new URL("https://api.agify.io/?name=" + name).openConnection();

            request.connect();
            InputStreamReader inputStreamReader = new InputStreamReader((InputStream) request.getContent());
            BufferedReader input = new BufferedReader(inputStreamReader);

            Thread.sleep(3000);

            String mensaje;
            while (input.ready()) {
                mensaje = input.readLine();

                mensaje = mensaje.substring(1);
                mensaje = mensaje.substring(0, mensaje.length() - 1);
                mensaje = mensaje.replaceAll("\"","");

                System.out.println(mensaje);
            }
        }catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
