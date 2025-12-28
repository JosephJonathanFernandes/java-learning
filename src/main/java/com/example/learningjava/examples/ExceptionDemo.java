package com.example.learningjava.examples;

/** Exception demonstration class. */
public final class ExceptionDemo {

  /** The dividend value for division. */
  private static final int DIVIDEND = 10;

  private ExceptionDemo() {
    // Utility class
  }

  public static void main(String[] args) {

    try {
      int result = DIVIDEND / 0;
      System.out.println(result);
    } catch (ArithmeticException e) {
      System.out.println("Cannot divide by zero!");
    } finally {
      System.out.println("Program ended safely.");
    }
  }
}
