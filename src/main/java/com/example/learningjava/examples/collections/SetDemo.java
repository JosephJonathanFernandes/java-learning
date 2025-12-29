package com.example.learningjava.examples;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

  public static void main(String[] args) {

    Set<String> emails = new HashSet<>();

    emails.add("a@gmail.com");
    emails.add("b@gmail.com");
    emails.add("a@gmail.com"); // duplicate

    for (String email : emails) {
      System.out.println(email);
    }
  }
}
