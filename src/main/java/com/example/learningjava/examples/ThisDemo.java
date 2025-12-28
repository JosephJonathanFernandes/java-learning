package com.example.learningjava.examples;

class Car {
  String model;
  int year;

  Car(String model, int year) {
    this.model = model;
    this.year = year;
  }

  void show() {
    System.out.println("Model: " + model + ", Year: " + year);
  }
}

public class ThisDemo {
  public static void main(String[] args) {
    Car c1 = new Car("Tesla", 2024);
    c1.show();
  }
}
