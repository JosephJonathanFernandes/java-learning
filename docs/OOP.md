# Object-Oriented Programming in Java

This comprehensive guide covers the four fundamental principles of Object-Oriented Programming (OOP) in Java: Encapsulation, Inheritance, Polymorphism, and Abstraction.

## 📋 Table of Contents
- [Classes and Objects](#classes-and-objects)
- [Encapsulation](#encapsulation)
- [Inheritance](#inheritance)
- [Polymorphism](#polymorphism)
- [Abstraction](#abstraction)
- [Constructors](#constructors)
- [Access Modifiers](#access-modifiers)
- [The 'this' Keyword](#the-this-keyword)
- [Method Overriding vs Overloading](#method-overriding-vs-overloading)
- [Object Relationships](#object-relationships)
- [Best Practices](#best-practices)

## Classes and Objects

### Class Definition
A class is a blueprint or template for creating objects. It defines the properties (fields) and behaviors (methods) that objects of that class will have.

```java
public class Student {
    // Fields (properties)
    private String name;
    private int age;
    private String studentId;

    // Methods (behaviors)
    public void study() {
        System.out.println(name + " is studying");
    }

    public void takeExam() {
        System.out.println(name + " is taking an exam");
    }
}
```

### Object Creation
Objects are instances of classes, created using the `new` keyword.

```java
// Create objects (instances) of the Student class
Student alice = new Student();
Student bob = new Student();

// Each object has its own copy of the fields
alice.name = "Alice";
bob.name = "Bob";
```

**See Also:** `src/main/java/com/example/learningjava/examples/oop/OOPDemo.java`

## Encapsulation

Encapsulation is the bundling of data (fields) and methods that operate on that data within a single unit (class), while restricting direct access to some components.

### Private Fields with Public Getters/Setters

```java
public class BankAccount {
    private double balance;  // Private field - hidden from outside
    private String accountNumber;

    // Public getter method
    public double getBalance() {
        return balance;
    }

    // Public setter method with validation
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }

    // Business logic method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
```

**Benefits:**
- **Data Protection**: Prevents invalid data from being set
- **Flexibility**: Implementation can change without affecting users
- **Maintainability**: Centralized control over data access

## Inheritance

Inheritance allows a class (subclass/child) to inherit properties and methods from another class (superclass/parent).

### Basic Inheritance

```java
// Parent class (superclass)
public class Animal {
    protected String name;
    protected int age;

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Child class (subclass) inherits from Animal
public class Dog extends Animal {
    private String breed;

    // Constructor
    public Dog(String name, int age, String breed) {
        this.name = name;  // Inherited field
        this.age = age;    // Inherited field
        this.breed = breed;
    }

    // Additional method specific to Dog
    public void bark() {
        System.out.println(name + " says: Woof!");
    }

    // Override inherited method
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food");
    }
}
```

### Types of Inheritance
1. **Single Inheritance**: One class extends another (most common)
2. **Multilevel Inheritance**: A → B → C (each extends the previous)
3. **Hierarchical Inheritance**: Multiple classes extend the same parent

**See Also:** `src/main/java/com/example/learningjava/examples/oop/InheritanceDemo.java`

## Polymorphism

Polymorphism allows objects of different classes to be treated as objects of a common superclass, enabling the same method to behave differently based on the object type.

### Method Overriding (Runtime Polymorphism)

```java
public class Shape {
    public double calculateArea() {
        return 0.0;
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
```

### Using Polymorphism

```java
public class Main {
    public static void main(String[] args) {
        // Array of Shape objects (polymorphism)
        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Circle(3.0)
        };

        // Same method call, different behavior
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
        }
    }
}
```

### Method Overloading (Compile-time Polymorphism)

```java
public class Calculator {
    // Same method name, different parameters
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

## Abstraction

Abstraction focuses on essential features while hiding implementation details. Achieved through abstract classes and interfaces.

### Abstract Classes

```java
public abstract class Vehicle {
    protected String brand;
    protected String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // Abstract method - must be implemented by subclasses
    public abstract void start();

    // Concrete method - inherited as-is
    public void stop() {
        System.out.println("Vehicle stopped");
    }

    // Abstract method with implementation requirement
    public abstract double calculateFuelEfficiency();
}

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println("Starting car engine...");
    }

    @Override
    public double calculateFuelEfficiency() {
        return 25.0; // miles per gallon
    }
}
```

### Interfaces

```java
public interface Drivable {
    void accelerate();
    void brake();
    double getSpeed();
}

public interface Maintainable {
    void performMaintenance();
    boolean needsService();
}

public class SportsCar extends Car implements Drivable, Maintainable {
    private double currentSpeed;

    public SportsCar(String brand, String model) {
        super(brand, model, 2);
    }

    @Override
    public void accelerate() {
        currentSpeed += 20;
        System.out.println("Vroom! Speed: " + currentSpeed);
    }

    @Override
    public void brake() {
        currentSpeed = Math.max(0, currentSpeed - 15);
        System.out.println("Stopping... Speed: " + currentSpeed);
    }

    @Override
    public double getSpeed() {
        return currentSpeed;
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing sports car maintenance");
    }

    @Override
    public boolean needsService() {
        return currentSpeed > 100; // Needs service if driven hard
    }
}
```

## Constructors

Constructors are special methods used to initialize objects when they are created.

### Types of Constructors

```java
public class Person {
    private String name;
    private int age;
    private String address;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.address = "Not specified";
    }

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = "Not specified";
    }

    // Constructor with all parameters
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.address = other.address;
    }
}
```

### Constructor Chaining

```java
public class Employee extends Person {
    private String employeeId;
    private double salary;

    // Constructor using super() to call parent constructor
    public Employee(String name, int age, String employeeId, double salary) {
        super(name, age);  // Call parent constructor
        this.employeeId = employeeId;
        this.salary = salary;
    }
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/oop/ConstructorDemo.java`

## Access Modifiers

Access modifiers control the visibility and accessibility of classes, fields, and methods.

| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|----------|-------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `default` (no modifier) | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

### Example Usage

```java
public class AccessExample {
    public int publicField;      // Accessible everywhere
    protected int protectedField; // Accessible in same package and subclasses
    int defaultField;            // Accessible in same package only
    private int privateField;    // Accessible only within this class

    public void publicMethod() { }
    protected void protectedMethod() { }
    void defaultMethod() { }
    private void privateMethod() { }
}
```

## The 'this' Keyword

The `this` keyword refers to the current object instance.

### Common Uses

```java
public class Rectangle {
    private int length;
    private int width;

    // Constructor using 'this' to distinguish parameters from fields
    public Rectangle(int length, int width) {
        this.length = length;  // this.length refers to field
        this.width = width;    // this.width refers to field
    }

    // Method chaining using 'this' as return value
    public Rectangle setLength(int length) {
        this.length = length;
        return this;  // Return current object for method chaining
    }

    public Rectangle setWidth(int width) {
        this.width = width;
        return this;
    }

    // Calling another constructor using 'this()'
    public Rectangle(int side) {
        this(side, side);  // Call the two-parameter constructor
    }
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/oop/ThisDemo.java`

## Method Overriding vs Overloading

### Method Overriding
- **Same method signature** in subclass as in superclass
- **Runtime polymorphism** - determined at runtime
- **Requires inheritance relationship**
- **Can change access modifier** (but not to more restrictive)
- **Must have `@Override` annotation** (recommended)

```java
class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {  // Override
        System.out.println("Woof!");
    }
}
```

### Method Overloading
- **Same method name, different parameters**
- **Compile-time polymorphism** - determined at compile time
- **Can be in same class or inherited classes**
- **Cannot change return type alone**
- **No special annotation needed**

```java
class Calculator {
    public int add(int a, int b) { return a + b; }

    public double add(double a, double b) { return a + b; }  // Overload

    public int add(int a, int b, int c) { return a + b + c; } // Overload
}
```

## Object Relationships

### Association
- Objects are connected but can exist independently
- **One-to-One**: Person has an Address
- **One-to-Many**: Department has multiple Employees
- **Many-to-Many**: Students enroll in multiple Courses

### Aggregation
- "Has-a" relationship where parts can exist without the whole
- Weak relationship - parts can be shared

```java
public class Department {
    private List<Employee> employees; // Department has employees

    public Department() {
        this.employees = new ArrayList<>();
    }
}
```

### Composition
- Strong "Has-a" relationship where parts cannot exist without the whole
- Parts are created and destroyed with the whole

```java
public class Car {
    private Engine engine;  // Car has an engine

    public Car() {
        this.engine = new Engine(); // Engine created with Car
    }
}
```

## Best Practices

### 🎯 **Design Principles**
- **Single Responsibility**: Each class should have one reason to change
- **Open/Closed**: Open for extension, closed for modification
- **Liskov Substitution**: Subclasses should be substitutable for base classes
- **Interface Segregation**: Prefer small, focused interfaces
- **Dependency Inversion**: Depend on abstractions, not concretions

### 🏗️ **Class Design**
- Use meaningful class and method names
- Keep classes focused and not too large
- Prefer composition over inheritance when possible
- Use interfaces for defining contracts
- Make fields private and provide getters/setters as needed

### 🔒 **Encapsulation Guidelines**
- Hide implementation details
- Expose only necessary public APIs
- Validate input in setters
- Use immutable objects when appropriate
- Avoid exposing mutable internal state

### 📈 **Inheritance Best Practices**
- Don't use inheritance just to reuse code
- Favor composition when there's no "is-a" relationship
- Keep inheritance hierarchies shallow (preferably 2-3 levels max)
- Use abstract classes for partial implementations
- Override methods only when necessary

### 🎭 **Polymorphism Usage**
- Use polymorphism to write more flexible code
- Prefer interfaces over concrete classes in method parameters
- Use `instanceof` sparingly (indicates design issues)
- Leverage method overriding for different behaviors

## Common OOP Patterns

### Factory Pattern
```java
public class ShapeFactory {
    public static Shape createShape(String type) {
        switch (type.toLowerCase()) {
            case "circle": return new Circle();
            case "square": return new Square();
            default: throw new IllegalArgumentException("Unknown shape");
        }
    }
}
```

### Builder Pattern
```java
public class Person {
    private String name;
    private int age;
    private String address;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static class Builder {
        // Same fields as Person
        public Builder name(String name) { this.name = name; return this; }
        public Builder age(int age) { this.age = age; return this; }
        public Person build() { return new Person(this); }
    }
}

// Usage: Person person = new Person.Builder().name("John").age(30).build();
```

## Practice Exercises

1. **Bank Account System**: Create Account, SavingsAccount, and CurrentAccount classes
2. **Shape Hierarchy**: Implement Circle, Rectangle, Triangle with common Shape interface
3. **Employee Management**: Design Employee hierarchy with different roles and salaries
4. **Vehicle System**: Create Vehicle classes with different fuel types and engines

## Next Steps

After mastering OOP concepts, explore:
- **Collections Framework** (`docs/COLLECTIONS.md`)
- **Streams and Lambdas** (`docs/STREAMS.md`)
- **Exception Handling** (`docs/EXCEPTIONS.md`)

OOP is fundamental to Java development. Practice creating class hierarchies, implementing interfaces, and designing flexible systems using these principles.
