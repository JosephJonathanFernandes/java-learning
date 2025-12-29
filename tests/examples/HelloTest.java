package com.example.learningjava.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.learningjava.examples.basics.Hello;
import org.junit.jupiter.api.Test;

public class HelloTest {
  @Test
  public void testHello() {
    Hello hello = new Hello();
    assertEquals("Hello, World!", hello.greet());
  }
}
