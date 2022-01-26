package com.Evaluacion1.synchronizedThreads;

public class unclass {
    public static void main(String[] args) {
        String mensaje = "Mensaje secreto";
        Buffer b = new Buffer();

        new Thread(new Producer(b, mensaje)).start();
        new Thread(new Consumer(b, mensaje.length())).start();
        new Thread(new Consumer(b, mensaje.length())).start();
    }
}

class Producer implements Runnable {
    Buffer b;
    String mensaje;

    public Producer(Buffer b, String mensaje) {
        this.b = b;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        for(char c : mensaje.toCharArray()) {
            try {
                b.setCharacter(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    Buffer b;
    int mensajeLength;

    public Consumer(Buffer b, int mensajeLength) {
        this.b = b;
        this.mensajeLength = mensajeLength;
    }

    @Override
    public void run() {
        for(int i = 0; i < mensajeLength; i++) {
            try {
                System.out.println(b.getCharacter());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Buffer {
    private String c;
    private boolean changed = false;

    public synchronized String getCharacter() throws InterruptedException {
        while(!changed) wait();

        changed = false;
        notifyAll();
        return c;
    }

    public synchronized void setCharacter(char c) throws InterruptedException {
        while(changed) wait();

        this.c = String.valueOf(c);
        changed = true;
        notifyAll();
    }
}
