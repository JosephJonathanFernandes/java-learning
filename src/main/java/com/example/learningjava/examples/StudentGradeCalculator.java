package com.example.learningjava.examples;

import java.util.Scanner;
import com.example.learningjava.model.Student;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        Student s = new Student(name, subjects);

        int[] marks = new int[subjects];
        System.out.println("\nEnter marks for " + name + ":");
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        s.setMarks(marks);

        System.out.println("\n--- Result ---");
        System.out.println("Name: " + s.getName());
        System.out.println("Average: " + s.calculateAverage());
        System.out.println("Grade: " + s.calculateGrade());

        sc.close();
    }
}
