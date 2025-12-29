# Java Basics - Fundamental Concepts

This guide covers the fundamental building blocks of Java programming, essential for understanding all subsequent topics in this learning repository.

## 📋 Table of Contents
- [Hello World Program](#hello-world-program)
- [Variables and Data Types](#variables-and-data-types)
- [Operators](#operators)
- [Control Flow Statements](#control-flow-statements)
- [Loops](#loops)
- [Methods](#methods)
- [Arrays](#arrays)
- [Input/Output](#inputoutput)
- [Best Practices](#best-practices)

## Hello World Program

The simplest Java program demonstrates the basic structure:

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java World!");
    }
}
```

**Key Components:**
- **Class Declaration**: `public class Hello` - defines a class named Hello
- **Main Method**: `public static void main(String[] args)` - entry point for JVM
- **Print Statement**: `System.out.println()` - outputs text to console

**See Also:** `src/main/java/com/example/learningjava/examples/basics/Hello.java`

## Variables and Data Types

Java is a strongly-typed language requiring explicit type declarations.

### Primitive Data Types

| Type | Size | Range | Example |
|------|------|-------|---------|
| `byte` | 8-bit | -128 to 127 | `byte age = 25;` |
| `short` | 16-bit | -32,768 to 32,767 | `short year = 2024;` |
| `int` | 32-bit | -2^31 to 2^31-1 | `int population = 1000000;` |
| `long` | 64-bit | -2^63 to 2^63-1 | `long distance = 123456789L;` |
| `float` | 32-bit | ±3.4×10^38 | `float pi = 3.14f;` |
| `double` | 64-bit | ±1.7×10^308 | `double price = 19.99;` |
| `char` | 16-bit | Unicode characters | `char letter = 'A';` |
| `boolean` | 1-bit | true/false | `boolean isValid = true;` |

### Reference Types

```java
String name = "John Doe";        // String object
int[] numbers = {1, 2, 3, 4, 5}; // Array reference
Scanner scanner = new Scanner(System.in); // Object reference
```

**See Also:** `src/main/java/com/example/learningjava/examples/basics/A.java`

## Operators

Java provides various operators for performing operations on variables and values.

### Arithmetic Operators

```java
int a = 10, b = 3;
int sum = a + b;        // 13
int difference = a - b; // 7
int product = a * b;    // 30
int quotient = a / b;   // 3 (integer division)
int remainder = a % b;  // 1
```

### Comparison Operators

```java
boolean result;
result = (a == b);  // false - equal to
result = (a != b);  // true - not equal to
result = (a > b);   // true - greater than
result = (a < b);   // false - less than
result = (a >= b);  // true - greater than or equal
result = (a <= b);  // false - less than or equal
```

### Logical Operators

```java
boolean x = true, y = false;
boolean andResult = x && y;  // false - AND
boolean orResult = x || y;   // true - OR
boolean notResult = !x;      // false - NOT
```

### Assignment Operators

```java
int num = 10;
num += 5;  // num = num + 5; → 15
num -= 3;  // num = num - 3; → 12
num *= 2;  // num = num * 2; → 24
num /= 4;  // num = num / 4; → 6
num %= 5;  // num = num % 5; → 1
```

## Control Flow Statements

Control flow statements allow programs to make decisions and execute code conditionally.

### If-Else Statements

```java
int score = 85;

if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else if (score >= 70) {
    System.out.println("Grade: C");
} else {
    System.out.println("Grade: F");
}
```

### Switch Statements

```java
int day = 3;
String dayName;

switch (day) {
    case 1:
        dayName = "Monday";
        break;
    case 2:
        dayName = "Tuesday";
        break;
    case 3:
        dayName = "Wednesday";
        break;
    default:
        dayName = "Unknown";
        break;
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/basics/IfElseDemo.java`

## Loops

Loops allow repetitive execution of code blocks.

### For Loop

```java
// Traditional for loop
for (int i = 0; i < 5; i++) {
    System.out.println("Count: " + i);
}

// Enhanced for loop (for-each)
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println("Number: " + num);
}
```

### While Loop

```java
int count = 0;
while (count < 5) {
    System.out.println("Count: " + count);
    count++;
}
```

### Do-While Loop

```java
int num;
do {
    System.out.print("Enter a number between 1-10: ");
    num = scanner.nextInt();
} while (num < 1 || num > 10);
```

**See Also:** `src/main/java/com/example/learningjava/examples/basics/LoopDemo.java`

## Methods

Methods are reusable blocks of code that perform specific tasks.

### Method Declaration

```java
// Method without return value
public static void greet(String name) {
    System.out.println("Hello, " + name + "!");
}

// Method with return value
public static int add(int a, int b) {
    return a + b;
}

// Method with multiple parameters
public static double calculateAverage(int[] scores) {
    int sum = 0;
    for (int score : scores) {
        sum += score;
    }
    return (double) sum / scores.length;
}
```

### Method Overloading

```java
public static void printInfo(String name) {
    System.out.println("Name: " + name);
}

public static void printInfo(String name, int age) {
    System.out.println("Name: " + name + ", Age: " + age);
}

public static void printInfo(String name, int age, String city) {
    System.out.println("Name: " + name + ", Age: " + age + ", City: " + city);
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/basics/MethodDemo.java`

## Arrays

Arrays are fixed-size data structures that store multiple values of the same type.

### Array Declaration and Initialization

```java
// Declare and initialize
int[] numbers = {1, 2, 3, 4, 5};

// Declare then initialize
String[] names = new String[3];
names[0] = "Alice";
names[1] = "Bob";
names[2] = "Charlie";

// Multidimensional array
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

### Array Operations

```java
int[] scores = {85, 92, 78, 96, 88};

// Access elements
int firstScore = scores[0];  // 85
int lastScore = scores[scores.length - 1];  // 88

// Calculate sum
int sum = 0;
for (int score : scores) {
    sum += score;
}

// Find maximum
int max = scores[0];
for (int score : scores) {
    if (score > max) {
        max = score;
    }
}

// Calculate average (with type casting)
double average = (double) sum / scores.length;
```

**See Also:** `src/main/java/com/example/learningjava/examples/basics/ArrayDemo.java`

## Input/Output

Java provides several ways to handle input and output operations.

### Console Output

```java
System.out.println("This prints and moves to next line");
System.out.print("This prints without newline");
System.out.printf("Formatted output: %s scored %d%%", "Alice", 95);
```

### Console Input with Scanner

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);

// Read different types
String name = scanner.nextLine();      // Read entire line
int age = scanner.nextInt();          // Read integer
double salary = scanner.nextDouble(); // Read double
boolean isStudent = scanner.nextBoolean(); // Read boolean

// Handle input buffer issues
scanner.nextLine(); // Consume leftover newline after nextInt()

scanner.close(); // Always close scanner
```

**See Also:** `src/main/java/com/example/learningjava/examples/basics/InputDemo.java`

## Best Practices

### 🔧 **Code Style**
- Use meaningful variable and method names
- Follow camelCase convention for variables and methods
- Use PascalCase for class names
- Add comments for complex logic

### 🛡️ **Error Prevention**
- Always initialize variables before use
- Check array bounds to avoid IndexOutOfBoundsException
- Handle division by zero
- Close resources (Scanner, File, etc.) in finally blocks or try-with-resources

### 📊 **Performance Considerations**
- Use appropriate data types (int vs long, float vs double)
- Initialize arrays with known sizes when possible
- Avoid unnecessary object creation in loops
- Use StringBuilder for string concatenation in loops

### 🔍 **Debugging Tips**
- Use System.out.println() for debugging
- Check variable values at different execution points
- Verify loop conditions and array indices
- Test edge cases (empty arrays, zero values, negative numbers)

## Practice Exercises

1. **Temperature Converter**: Create a program that converts Celsius to Fahrenheit and vice versa
2. **Grade Calculator**: Build a program that calculates letter grades based on percentage scores
3. **Number Guessing Game**: Implement a game where the computer generates a random number and the user guesses it
4. **Simple Calculator**: Create a calculator that performs basic arithmetic operations with menu selection

## Next Steps

After mastering these basics, you're ready to explore:
- **Object-Oriented Programming** (`docs/OOP.md`)
- **Collections Framework** (`docs/COLLECTIONS.md`)
- **Exception Handling** (`docs/EXCEPTIONS.md`)

Remember: Practice is key to mastering these concepts. Run the examples, modify them, and create your own programs to reinforce your understanding.
