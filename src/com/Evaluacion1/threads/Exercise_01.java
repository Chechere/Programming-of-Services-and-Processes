package com.Evaluacion1.threads;

public class Exercise_01 {
    public static void main(String[] args) {
        /*
        TIC tic = new TIC();
        TAC tac = new TAC();

        try {
            tic.start();
            Thread.sleep(500);
            tac.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        try {
            new TICTAC("TIC").start();
            Thread.sleep(500);
            new TICTAC("TAC").start();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TIC extends Thread {
    @Override
    public void run() {
        while(true) {
            try {
                System.out.print("TIC");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class TAC extends Thread {
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("TAC");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TICTAC extends Thread {
    private String name;


    public TICTAC(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(name);
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}