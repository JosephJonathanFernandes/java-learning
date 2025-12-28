package com.example.learningjava.examples;

class StudentOOP {
  String name;
  int age;

  void introduce() {
    System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
  }
}

public class OOPDemo {
  public static void main(String[] args) {
    StudentOOP s1 = new StudentOOP();
    s1.name = "Alice";
    s1.age = 20;
    s1.introduce();

    StudentOOP s2 = new StudentOOP();
    s2.name = "Bob";
    s2.age = 22;
    s2.introduce();
  }
}
