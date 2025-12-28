package com.example.learningjava.examples;

import com.example.learningjava.model.Student;

public class OOPDemo {

  public static void main(String[] args) {

    Student s1 = new Student();

    s1.setName("Joseph");
    s1.setMarks(85);

    System.out.println("Name: " + s1.getName());
    System.out.println("Marks: " + s1.getMarks());

    s1.setMarks(150); // blocked
  }
}
