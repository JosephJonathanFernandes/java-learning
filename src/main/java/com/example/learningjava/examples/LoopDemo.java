package com.example.learningjava.examples;

class LoopDemo {
    public static void main(String[] args) {
        // For loop
        for (int i = 1; i <= 5; i++)
            System.out.println("Count: " + i);

        // While loop
        int n = 3;
        while (n > 0) {
            System.out.println("n = " + n);
            n--;
        }

        // Do-while loop
        int x = 1;
        do {
            System.out.println("Hello " + x);
            x++;
        } while (x <= 3);
    }
}
