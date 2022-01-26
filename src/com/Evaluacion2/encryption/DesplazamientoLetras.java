package com.Evaluacion2.encryption;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DesplazamientoLetras {
    static final String DICTIONARY = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        /*String mensaje = "Hola Buenas tardes.";
        int clave = 53;

        clave = reducirClave(clave);

        mensaje = Encode(mensaje, clave);
        System.out.println("Mensaje encriptado: " + mensaje);

        mensaje = Decode(mensaje, clave);
        System.out.println("Mensaje desencriptado: " + mensaje);*/

        String mensaje = "testing the new hello world";
        int clave = 13;
        clave = reducirClave(clave);

        mensaje = Encode(mensaje, clave);
        System.out.println("Mensaje encriptado: " + mensaje);
        mensaje = Crack(mensaje);
        System.out.println("Mensaje crakeado: " + mensaje);
    }

    public static int reducirClave(int clave) {
        while(clave >= DICTIONARY.length()) clave -= DICTIONARY.length();
        return clave;
    }

    public static String Encode(String str, int key) {
        String result = "";

        for(char c : str.toCharArray()) {
            if(DICTIONARY.indexOf(c) != -1) {
                int newPos = DICTIONARY.indexOf(c) + key;
                newPos = (newPos >= DICTIONARY.length()) ?  newPos - DICTIONARY.length() : newPos;
                result += DICTIONARY.toCharArray()[newPos];
            } else if(DICTIONARY.indexOf(c + ' ') != -1) {
                int newPos = DICTIONARY.indexOf(c + ' ') + key;
                newPos = (newPos >= DICTIONARY.length()) ?  newPos - DICTIONARY.length() : newPos;
                result += (char)(DICTIONARY.toCharArray()[newPos] - ' ');
            } else {
                result += c;
            }
        }

        return result;
    }

    public static String Decode(String str, int key) {
        String result = "";

        for(char c : str.toCharArray()) {
            if(DICTIONARY.indexOf(c) != -1) {
                int newPos = DICTIONARY.indexOf(c) - key;
                newPos = (newPos < 0) ? DICTIONARY.length() + newPos : newPos;
                result += DICTIONARY.toCharArray()[newPos];
            } else if(DICTIONARY.indexOf(c + ' ') != -1) {
                int newPos = DICTIONARY.indexOf(c + ' ') - key;
                newPos = (newPos < 0) ? DICTIONARY.length() + newPos : newPos;
                result += (char)(DICTIONARY.toCharArray()[newPos] - ' ');
            } else {
                result += c;
            }
        }

        return result;
    }


    public static String Crack(String str) {
        String result = "";
        int[] charCounter = new int[DICTIONARY.length()];

        for(char c : str.toCharArray()) {
            if(DICTIONARY.indexOf(c) != -1) {
                charCounter[DICTIONARY.indexOf(c)]++;
            }
        }

        int commonChar = Arrays.stream(charCounter).max().getAsInt();
        int indexCommonChar = IntStream.range(0, charCounter.length).filter(i -> charCounter[i] == commonChar).findFirst().getAsInt();
        int key = Math.abs(indexCommonChar - DICTIONARY.indexOf('e'));

        result = Decode(str, key);
        return result;
    }
}