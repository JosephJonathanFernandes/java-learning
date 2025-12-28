package com.example.learningjava.examples;

class Student {
    String name;
    int age;

    void introduce() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Alice";
        s1.age = 20;
        s1.introduce();

        Student s2 = new Student();
        s2.name = "Bob";
        s2.age = 22;
        s2.introduce();
    }
}
