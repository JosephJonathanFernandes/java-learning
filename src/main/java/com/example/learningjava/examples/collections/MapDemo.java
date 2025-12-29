package com.example.learningjava.examples.collections;

import com.example.learningjava.model.Student;
import java.util.HashMap;
import java.util.Map;

public class MapDemo {

  public static void main(String[] args) {

    Map<Integer, Student> studentMap = new HashMap<>();

    Student s1 = new Student("Joseph", 1);
    s1.setMarks(new int[] {88});

    Student s2 = new Student("Alex", 1);
    s2.setMarks(new int[] {92});

    studentMap.put(1, s1);
    studentMap.put(2, s2);

    Student student = studentMap.get(1);
    System.out.println(student.getName());

    for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
      System.out.println("Roll: " + entry.getKey() + " Name: " + entry.getValue().getName());
    }
  }
}
