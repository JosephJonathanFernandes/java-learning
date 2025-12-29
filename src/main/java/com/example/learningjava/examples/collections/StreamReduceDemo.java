package com.example.learningjava.examples.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class StreamReduceDemo {

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

    // Sum of all marks using reduce
    int totalMarks =
        students.stream().mapToInt(Student::getMarks).sum(); // or reduce(0, Integer::sum)

    System.out.println("\nTotal marks: " + totalMarks);

    // Average marks using reduce
    OptionalDouble average = students.stream().mapToInt(Student::getMarks).average();

    if (average.isPresent()) {
      System.out.println("Average marks: " + String.format("%.2f", average.getAsDouble()));
    }

    // Find maximum marks using reduce
    OptionalInt maxMarks = students.stream().mapToInt(Student::getMarks).max();

    if (maxMarks.isPresent()) {
      System.out.println("Maximum marks: " + maxMarks.getAsInt());
    }

    // Find minimum marks using reduce
    OptionalInt minMarks = students.stream().mapToInt(Student::getMarks).min();

    if (minMarks.isPresent()) {
      System.out.println("Minimum marks: " + minMarks.getAsInt());
    }

    // Count students with marks >= 90 using reduce
    long highScorersCount =
        students.stream().mapToInt(student -> student.getMarks() >= 90 ? 1 : 0).sum();

    System.out.println("Number of students with marks >= 90: " + highScorersCount);

    // Concatenate all names using reduce
    String allNames =
        students.stream()
            .map(Student::getName)
            .reduce("", (a, b) -> a + (a.isEmpty() ? "" : ", ") + b);

    System.out.println("All names: " + allNames);

    // Find student with highest marks using reduce
    Optional<Student> topStudent =
        students.stream().reduce((s1, s2) -> s1.getMarks() > s2.getMarks() ? s1 : s2);

    if (topStudent.isPresent()) {
      System.out.println(
          "Top student: "
              + topStudent.get().getName()
              + " with "
              + topStudent.get().getMarks()
              + " marks");
    }

    // Calculate sum using custom reduce
    int sumUsingReduce = students.stream().map(Student::getMarks).reduce(0, Integer::sum);

    System.out.println("Sum using reduce: " + sumUsingReduce);

    // Product of all marks (demonstrating reduce with multiplication)
    int product = students.stream().map(Student::getMarks).reduce(1, (a, b) -> a * b);

    System.out.println("Product of all marks: " + product);
  }

  private static Student createStudent(String name, int marks) {
    Student student = new Student();
    student.setName(name);
    student.setMarks(marks);
    return student;
  }
}
