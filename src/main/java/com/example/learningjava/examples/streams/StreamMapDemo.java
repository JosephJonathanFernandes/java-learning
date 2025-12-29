package com.example.learningjava.examples.streams;

import com.example.learningjava.examples.collections.Student;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapDemo {

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

    // Map to names only
    List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());

    System.out.println("\nStudent names: " + names);

    // Map to uppercase names
    List<String> upperCaseNames =
        students.stream()
            .map(student -> student.getName().toUpperCase())
            .collect(Collectors.toList());

    System.out.println("Uppercase names: " + upperCaseNames);

    // Map to marks with bonus points (+5)
    List<Integer> marksWithBonus =
        students.stream().map(student -> student.getMarks() + 5).collect(Collectors.toList());

    System.out.println("Marks with bonus (+5): " + marksWithBonus);

    // Map to grade letters
    List<String> grades =
        students.stream()
            .map(
                student -> {
                  int marks = student.getMarks();
                  if (marks >= 90) return "A";
                  else if (marks >= 80) return "B";
                  else if (marks >= 70) return "C";
                  else if (marks >= 60) return "D";
                  else return "F";
                })
            .collect(Collectors.toList());

    System.out.println("Grades: " + grades);

    // Map to student info strings
    List<String> studentInfo =
        students.stream()
            .map(student -> student.getName() + " scored " + student.getMarks() + " marks")
            .collect(Collectors.toList());

    System.out.println("\nStudent info:");
    studentInfo.forEach(System.out::println);
  }

  private static Student createStudent(String name, int marks) {
    Student student = new Student();
    student.setName(name);
    student.setMarks(marks);
    return student;
  }
}
