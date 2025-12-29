package com.example.learningjava.examples.collections;

public class Student implements Comparable<Student> {

  private String name;
  private int marks;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMarks() {
    return marks;
  }

  public void setMarks(int marks) {
    if (marks >= 0 && marks <= 100) {
      this.marks = marks;
    }
  }

  // NATURAL SORT: by marks (ascending)
  @Override
  public int compareTo(Student other) {
    return this.marks - other.marks;
  }
}
