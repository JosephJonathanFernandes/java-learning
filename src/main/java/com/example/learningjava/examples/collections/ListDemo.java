package com.example.learningjava.examples;

import com.example.learningjava.model.Student;
import java.util.ArrayList;
import java.util.List;

public class ListDemo {

  public static void main(String[] args) {

    List<Student> students = new ArrayList<>();

    Student s1 = new Student("Joseph", 1);
    s1.setMarks(new int[] {85});

    Student s2 = new Student("Alex", 1);
    s2.setMarks(new int[] {90});

    students.add(s1);
    students.add(s2);

    // Loop through list
    for (Student s : students) {
      System.out.println(s.getName() + " - " + s.getMarks()[0]);
    }
  }
}
