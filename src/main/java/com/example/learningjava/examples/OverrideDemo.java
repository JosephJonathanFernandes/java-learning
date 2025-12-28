package com.example.learningjava.examples;

class Animal {
  void sound() {
    System.out.println("Some sound...");
  }
}

class Dog extends Animal {
  @Override
  void sound() {
    System.out.println("Bark!");
  }
}

public class OverrideDemo {
  public static void main(String[] args) {
    Animal a = new Dog(); // Polymorphism
    a.sound(); // Output: Bark!
  }
}
