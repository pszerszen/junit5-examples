package com.pgs.junit5.examples;

public class Fibonacci {
    public static int compute(int n) {
        return n <= 1 ? n : compute(n - 1) + compute(n - 2);
    }
}
