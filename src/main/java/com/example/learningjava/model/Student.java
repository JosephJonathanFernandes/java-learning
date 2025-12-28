package com.example.learningjava.model;

public class Student {

  private String name;
  private int marks;

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String name) {
    this.name = name;
  }

  public int getMarks() {
    return marks;
  }

  public void setMarks(int marks) {
    if (marks >= 0 && marks <= 100) {
      this.marks = marks;
    } else {
      System.out.println("Invalid marks!");
    }
  }
}
