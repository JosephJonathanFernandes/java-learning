package com.example.learningjava.examples;

import com.example.learningjava.model.Student;

public class OOPDemo {

  public static void main(String[] args) {

    Student s1 = new Student("Joseph", 1);

    s1.setName("Joseph");
    s1.setMarks(new int[] {85});

    System.out.println("Name: " + s1.getName());
    System.out.println("Marks: " + java.util.Arrays.toString(s1.getMarks()));

    s1.setMarks(new int[] {150}); // not blocked now
  }
}
