package com.example.learningjava.examples.oop;

import com.example.learningjava.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

  private List<Student> students = new ArrayList<>();

  public void addStudent(Student s) {
    students.add(s);
  }

  public void displayStudents() {
    for (Student s : students) {
      System.out.println(s.getName() + " - " + s.getMarks()[0]);
    }
  }

  public static void main(String[] args) {

    StudentManager manager = new StudentManager();

    Student s1 = new Student("Joseph", 1);
    s1.setMarks(new int[] {80});

    manager.addStudent(s1);
    manager.displayStudents();
  }
}
