package com.example.learningjava.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.learningjava.examples.basics.HelloWorld;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
  @Test
  public void testHelloWorld() {
    assertEquals("Hello, World!", new HelloWorld().greet());
  }
}
