package com.example.learningjava.examples;

class MethodDemo {
  static int add(int a, int b) {
    return a + b;
  }

  static void greet(String name) {
    System.out.println("Hello, " + name + "!");
  }

  public static void main(String[] args) {
    greet("Joseph");
    int sum = add(5, 3);
    System.out.println("Sum = " + sum);
  }
}
