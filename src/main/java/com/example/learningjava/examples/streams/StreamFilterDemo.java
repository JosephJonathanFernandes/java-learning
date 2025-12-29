package com.example.learningjava.examples.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterDemo {

  public static void main(String[] args) {
    // Sample list of students
    List<Student> students =
        Arrays.asList(
            createStudent("Alice", 85),
            createStudent("Bob", 92),
            createStudent("Charlie", 78),
            createStudent("Diana", 96),
            createStudent("Eve", 88));

    System.out.println("All students:");
    students.forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));

    // Filter students with marks >= 90
    List<Student> highScorers =
        students.stream().filter(student -> student.getMarks() >= 90).collect(Collectors.toList());

    System.out.println("\nHigh scorers (marks >= 90):");
    highScorers.forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));

    // Filter students whose names start with 'A' or 'B'
    List<Student> namesStartingWithAB =
        students.stream()
            .filter(
                student -> student.getName().startsWith("A") || student.getName().startsWith("B"))
            .collect(Collectors.toList());

    System.out.println("\nStudents whose names start with A or B:");
    namesStartingWithAB.forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));

    // Filter and count students with marks between 80-95
    long count =
        students.stream()
            .filter(student -> student.getMarks() >= 80 && student.getMarks() <= 95)
            .count();

    System.out.println("\nNumber of students with marks between 80-95: " + count);
  }

  private static Student createStudent(String name, int marks) {
    Student student = new Student();
    student.setName(name);
    student.setMarks(marks);
    return student;
  }
}
