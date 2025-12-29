package com.example.learningjava.examples.oop;

import com.example.learningjava.model.Student;
import java.util.Scanner;

public class StudentGradeCalculator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter student name: ");
    String name = sc.nextLine();
    System.out.print("Enter marks: ");
    int marks = sc.nextInt();

    Student s = new Student(name, 1);
    s.setMarks(new int[] {marks});

    System.out.println("\n--- Result ---");
    System.out.println("Name: " + s.getName());
    System.out.println("Marks: " + java.util.Arrays.toString(s.getMarks()));

    sc.close();
  }
}
