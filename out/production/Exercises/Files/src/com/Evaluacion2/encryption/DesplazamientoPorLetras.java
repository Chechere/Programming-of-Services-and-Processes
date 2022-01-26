package com.Evaluacion2.encryption;

public class DesplazamientoPorLetras {
    private static final String DICTIONARY = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String mensaje = "Hola Mundo.";
        Pagina pagina = new Pagina(mensaje.length());

        String encode = Encode(mensaje, pagina);
        String decode = Decode(encode, pagina);

        System.out.println("Mensaje cifrado: " + encode);
        System.out.println("Mensaje descifrado: " + decode);
    }

    private static String Encode(String str, Pagina p) {
        String result = "";

        for(int i = 0; i < str.length(); i++) {
            char c = str.toCharArray()[i];
            int key = p.GetRandomNumber(i);

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

    private static String Decode(String str, Pagina p) {
        String result = "";

        for(int i = 0; i < str.length(); i++) {
            char c = str.toCharArray()[i];
            int key = p.GetRandomNumber(i);

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
}
