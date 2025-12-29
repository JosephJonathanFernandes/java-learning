package com.example.learningjava.examples.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortDemo {

  public static void main(String[] args) {

    List<Student> students = new ArrayList<>();

    Student s1 = new Student();
    s1.setName("Joseph");
    s1.setMarks(85);

    Student s2 = new Student();
    s2.setName("Alex");
    s2.setMarks(95);

    Student s3 = new Student();
    s3.setName("Brian");
    s3.setMarks(75);

    students.add(s1);
    students.add(s2);
    students.add(s3);

    Collections.sort(students, (stu1, stu2) -> stu2.getMarks() - stu1.getMarks());

    for (Student s : students) {
      System.out.println(s.getName() + " - " + s.getMarks());
    }
  }
}
