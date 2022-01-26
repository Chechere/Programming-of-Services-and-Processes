package com.Evaluacion1.threads;

public class Theory_3 {
    public static void main(String[] args) {
        /*TICTACRunnable tic = new TICTACRunnable("Tic");

        Thread t = new Thread(tic);
        t.start();

        new Thread(new TICTACRunnable("Tac")).start();*/


        try {
            new Thread(new TICRunnable()).start();
            Thread.sleep(500);
            new Thread(new TACRunnable()).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class TICTACRunnable implements Runnable {
    private String name;

    public TICTACRunnable(String name) {
        this.name = name;
    }

    public void run() {
        while(true) {
            try {
                System.out.println(name);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TICRunnable implements Runnable {

    public void run() {
        while(true) {
            try {
                System.out.print("TIC");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class TACRunnable implements Runnable {

    public void run() {
        while(true) {
            try {
                System.out.println("TAC");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
