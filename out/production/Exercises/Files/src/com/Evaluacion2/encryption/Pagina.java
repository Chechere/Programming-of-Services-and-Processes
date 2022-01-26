package com.Evaluacion2.encryption;

import java.util.Random;

public class Pagina {
    int[] nums;

    public Pagina() {
        nums = new int[64];
        GenerarPagina();
    }

    public Pagina(int length) {
        nums = new int[length];
        GenerarPagina();
    }

    private void GenerarPagina() {
        Random rnd = new Random();

        for(int i = 0; i < nums.length; i++) {
            nums[i] = rnd.nextInt(25);
        }
    }

    public int GetRandomNumber(int index) {
        int n;

        try {
            n = nums[index];
        }catch (ArrayIndexOutOfBoundsException e) {
            n = -1;
        }

        return n;
    }
}
