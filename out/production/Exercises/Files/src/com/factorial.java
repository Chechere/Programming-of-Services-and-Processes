package com;

public class factorial {
    public static void main(String[] args) {
        System.out.println(SacarFactorial(5));
    }

    static int SacarFactorial(int n) {
        if(n == 1) return n;
        else return n * SacarFactorial(n-1);
    }
}
