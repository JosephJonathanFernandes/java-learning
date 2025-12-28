package com.example.learningjava.model;

public class Student {

  private String name;
  private int[] marks;

  public Student(String name, int numSubjects) {
    this.name = name;
    this.marks = new int[numSubjects];
  }

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String name) {
    this.name = name;
  }

  public int[] getMarks() {
    return marks;
  }

  public void setMarks(int[] marks) {
    this.marks = marks;
  }

  public double calculateAverage() {
    if (marks.length == 0) {
      return 0.0;
    }
    double sum = 0;
    for (int mark : marks) {
      sum += mark;
    }
    return sum / marks.length;
  }

  public String calculateGrade() {
    double avg = calculateAverage();
    if (avg >= 90) {
      return "A";
    } else if (avg >= 80) {
      return "B";
    } else if (avg >= 70) {
      return "C";
    } else if (avg >= 60) {
      return "D";
    } else {
      return "F";
    }
  }
}
