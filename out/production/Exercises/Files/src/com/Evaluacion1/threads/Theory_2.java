package com.Evaluacion1.threads;

public class Theory_2 {
    public static void main(String[] args) {
        Hilo h1 = new Hilo();
        h1.start();
        for (int i = 10; i < 20; i++) {
            System.out.println(i);
        }
    }
}

class Hilo extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}