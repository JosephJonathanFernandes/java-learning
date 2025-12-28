package com.example.learningjava.examples;

class Student {
  String name;
  int age;

  // Constructor
  Student(String n, int a) {
    name = n;
    age = a;
  }

  void display() {
    System.out.println("Name: " + name + ", Age: " + age);
  }
}

public class ConstructorDemo {
  public static void main(String[] args) {
    Student s1 = new Student("Alice", 20);
    s1.display();
  }
}
