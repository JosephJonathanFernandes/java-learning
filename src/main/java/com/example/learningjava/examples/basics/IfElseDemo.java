package com.example.learningjava.examples.basics;

class IfElseDemo {
  public static void main(String[] args) {
    int number = 5;
    if (number > 0) {
      System.out.println("Positive");
    } else if (number < 0) {
      System.out.println("Negative");
    } else {
      System.out.println("Zero");
    }

    int day = 3;
    switch (day) {
      case 1:
        System.out.println("Monday");
        break;
      case 2:
        System.out.println("Tuesday");
        break;
      default:
        System.out.println("Other day");
    }
  }
}
