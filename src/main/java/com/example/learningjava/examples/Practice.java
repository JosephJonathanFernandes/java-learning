package com.example.learningjava.examples;

class Add {
    static void run() {
        int a = 5, b = 3;
        System.out.println("Sum: " + (a + b));
    }
}

class EvenOdd {
    static void run() {
        int n = 10;
        System.out.println((n % 2 == 0) ? "Even" : "Odd");
    }
}

public class Practice {
    public static void main(String[] args) {
        Add.run();
        EvenOdd.run();
    }
}
