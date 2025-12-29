# Java Exception Handling

This comprehensive guide covers Java's exception handling mechanisms, including try-catch blocks, custom exceptions, and best practices for robust error management.

## 📋 Table of Contents
- [Introduction to Exceptions](#introduction-to-exceptions)
- [Exception Hierarchy](#exception-hierarchy)
- [Try-Catch Blocks](#try-catch-blocks)
- [Finally Block](#finally-block)
- [Throw and Throws](#throw-and-throws)
- [Custom Exceptions](#custom-exceptions)
- [Checked vs Unchecked Exceptions](#checked-vs-unchecked-exceptions)
- [Exception Chaining](#exception-chaining)
- [Try-With-Resources](#try-with-resources)
- [Best Practices](#best-practices)

## Introduction to Exceptions

Exceptions are events that occur during program execution that disrupt the normal flow of instructions. Exception handling allows programs to gracefully handle these unexpected situations.

### Why Exception Handling Matters

- **Robust Applications**: Prevents crashes and unexpected behavior
- **Error Recovery**: Allows programs to recover from errors
- **Debugging**: Provides detailed information about what went wrong
- **Resource Management**: Ensures proper cleanup of resources

### Basic Exception Handling Flow

```java
try {
    // Code that might throw an exception
    riskyOperation();
} catch (ExceptionType e) {
    // Handle the exception
    handleException(e);
} finally {
    // Always execute (optional)
    cleanup();
}
```

## Exception Hierarchy

Java's exception hierarchy is rooted in the `Throwable` class, which has two main subclasses: `Error` and `Exception`.

```
Throwable
├── Error (JVM errors - usually not caught)
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── VirtualMachineError
│
└── Exception
    ├── RuntimeException (Unchecked)
    │   ├── NullPointerException
    │   ├── IllegalArgumentException
    │   ├── IndexOutOfBoundsException
    │   ├── ClassCastException
    │   └── ArithmeticException
    │
    └── Checked Exceptions
        ├── IOException
        │   ├── FileNotFoundException
        │   └── EOFException
        ├── SQLException
        └── ClassNotFoundException
```

### Common Exception Types

| Exception Type | When It Occurs | Example |
|----------------|----------------|---------|
| `NullPointerException` | Accessing null object | `String s = null; s.length();` |
| `IndexOutOfBoundsException` | Invalid array/list index | `array[10]` on size 5 array |
| `IllegalArgumentException` | Invalid method argument | `Math.sqrt(-1)` |
| `ClassCastException` | Invalid type casting | `(String) new Integer(5)` |
| `ArithmeticException` | Math errors | Division by zero |
| `IOException` | I/O operation failures | File not found, network issues |
| `NumberFormatException` | Invalid number parsing | `Integer.parseInt("abc")` |

## Try-Catch Blocks

Try-catch blocks allow you to handle exceptions gracefully without crashing the program.

### Basic Syntax

```java
try {
    // Code that might throw an exception
    int result = divide(10, 0);
    System.out.println("Result: " + result);
} catch (ArithmeticException e) {
    // Handle the specific exception
    System.out.println("Cannot divide by zero: " + e.getMessage());
} catch (Exception e) {
    // Handle any other exception
    System.out.println("An error occurred: " + e.getMessage());
}
```

### Multiple Catch Blocks

```java
try {
    // Risky operations
    readFile("nonexistent.txt");
    processData(null);
} catch (FileNotFoundException e) {
    System.out.println("File not found: " + e.getMessage());
} catch (NullPointerException e) {
    System.out.println("Null value encountered: " + e.getMessage());
} catch (Exception e) {
    // Catch-all for unexpected exceptions
    System.out.println("Unexpected error: " + e.getMessage());
    e.printStackTrace();  // Print stack trace for debugging
}
```

### Exception Handling in Methods

```java
public void processFile(String filename) {
    try {
        // File processing logic
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            processLine(line);
        }
        reader.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
        // Could throw a custom exception or return error code
    } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
        // Handle I/O errors
    }
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/exceptions/ExceptionDemo.java`

## Finally Block

The `finally` block always executes, regardless of whether an exception was thrown or caught. It's typically used for resource cleanup.

### Basic Finally Usage

```java
FileInputStream fis = null;
try {
    fis = new FileInputStream("data.txt");
    // Process file
    int data = fis.read();
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
} finally {
    // Always close the file, even if an exception occurred
    if (fis != null) {
        try {
            fis.close();
        } catch (IOException e) {
            System.out.println("Error closing file: " + e.getMessage());
        }
    }
}
```

### Finally with Return Statements

```java
public int processData() {
    try {
        if (someCondition) {
            return 1;  // Finally still executes
        }
        return 0;
    } finally {
        // This always runs, even with return statements
        System.out.println("Cleanup completed");
    }
}
```

## Throw and Throws

### The `throw` Statement

Use `throw` to explicitly throw an exception:

```java
public void validateAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("Age cannot be negative");
    }
    if (age > 150) {
        throw new IllegalArgumentException("Age cannot be greater than 150");
    }
}
```

### The `throws` Declaration

Use `throws` in method signatures to declare that a method might throw checked exceptions:

```java
// Method that might throw IOException
public void readFile(String filename) throws IOException {
    FileReader reader = new FileReader(filename);
    // Read file logic
}

// Method that might throw multiple exceptions
public void processData(String filename) throws IOException, SQLException {
    readFile(filename);
    saveToDatabase();
}
```

### Calling Methods That Throw Exceptions

```java
public void callerMethod() {
    try {
        readFile("data.txt");
    } catch (IOException e) {
        System.out.println("File operation failed: " + e.getMessage());
    }
}

// Or propagate the exception
public void anotherCaller() throws IOException {
    readFile("data.txt");
}
```

## Custom Exceptions

Create custom exceptions to represent specific error conditions in your application.

### Creating Custom Exceptions

```java
// Basic custom exception
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Custom exception with additional data
public class AccountException extends Exception {
    private String accountNumber;
    private double balance;

    public AccountException(String message, String accountNumber, double balance) {
        super(message);
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
}
```

### Runtime Custom Exceptions

```java
// Unchecked custom exception (extends RuntimeException)
public class InvalidAccountStateException extends RuntimeException {
    public InvalidAccountStateException(String message) {
        super(message);
    }

    public InvalidAccountStateException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

### Using Custom Exceptions

```java
public class BankAccount {
    private double balance;

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Cannot withdraw " + amount + ". Current balance: " + balance);
        }
        balance -= amount;
    }

    public void validateAccount() {
        if (balance < 0) {
            throw new InvalidAccountStateException("Account balance cannot be negative");
        }
    }
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/exceptions/InsufficientBalanceException.java`

## Checked vs Unchecked Exceptions

### Checked Exceptions
- **Must be declared** in method signature with `throws`
- **Must be handled** by caller with try-catch or propagated
- **Compile-time checking** - compiler enforces handling
- **Examples**: `IOException`, `SQLException`, `ClassNotFoundException`

```java
// Checked exception - must handle or declare
public void readFile() throws IOException {
    FileReader reader = new FileReader("file.txt");
    // Read file...
}
```

### Unchecked Exceptions
- **Don't need to be declared** with `throws`
- **Don't need to be caught** (but can be)
- **Runtime errors** - not checked at compile time
- **Examples**: `NullPointerException`, `IllegalArgumentException`, `IndexOutOfBoundsException`

```java
// Unchecked exception - no throws declaration needed
public void processData(String data) {
    if (data == null) {
        throw new IllegalArgumentException("Data cannot be null");
    }
    // Process data...
}
```

### When to Use Each Type

**Use Checked Exceptions for:**
- Recoverable conditions (file not found, network errors)
- Conditions that caller can reasonably be expected to handle
- API design where failure is part of normal operation

**Use Unchecked Exceptions for:**
- Programming errors (null pointers, invalid arguments)
- Conditions that indicate bugs in the code
- Preconditions that should never occur in correct code

## Exception Chaining

Exception chaining allows you to wrap one exception in another, preserving the original cause.

### Basic Exception Chaining

```java
try {
    riskyOperation();
} catch (IOException e) {
    // Wrap the original exception
    throw new MyApplicationException("Failed to process data", e);
}
```

### Custom Exception with Chaining

```java
public class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }

    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

### Using Exception Chaining

```java
public void processFile(String filename) throws DataProcessingException {
    try {
        // Multiple operations that might fail
        validateFile(filename);
        readFile(filename);
        processContent();
    } catch (IOException e) {
        throw new DataProcessingException(
            "Failed to process file: " + filename, e);
    } catch (ValidationException e) {
        throw new DataProcessingException(
            "File validation failed: " + filename, e);
    }
}
```

### Accessing the Cause Chain

```java
try {
    processFile("data.txt");
} catch (DataProcessingException e) {
    System.out.println("Processing failed: " + e.getMessage());

    // Get the original cause
    Throwable cause = e.getCause();
    if (cause != null) {
        System.out.println("Original cause: " + cause.getMessage());
    }

    // Print full stack trace
    e.printStackTrace();
}
```

## Try-With-Resources

Try-with-resources automatically closes resources that implement `AutoCloseable`, eliminating the need for explicit finally blocks.

### Basic Syntax

```java
try (FileReader reader = new FileReader("file.txt");
     BufferedReader br = new BufferedReader(reader)) {

    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }

} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
}
// No need for finally block - resources are automatically closed
```

### Multiple Resources

```java
try (FileInputStream fis = new FileInputStream("input.txt");
     FileOutputStream fos = new FileOutputStream("output.txt");
     BufferedInputStream bis = new BufferedInputStream(fis);
     BufferedOutputStream bos = new BufferedOutputStream(fos)) {

    // Use the streams
    byte[] buffer = new byte[1024];
    int bytesRead;
    while ((bytesRead = bis.read(buffer)) != -1) {
        bos.write(buffer, 0, bytesRead);
    }

} catch (IOException e) {
    System.out.println("File operation failed: " + e.getMessage());
}
```

### Custom AutoCloseable Resources

```java
public class DatabaseConnection implements AutoCloseable {
    public DatabaseConnection() {
        // Initialize connection
        System.out.println("Opening database connection");
    }

    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }

    @Override
    public void close() {
        // Cleanup resources
        System.out.println("Closing database connection");
    }
}

// Usage
try (DatabaseConnection conn = new DatabaseConnection()) {
    conn.executeQuery("SELECT * FROM users");
    conn.executeQuery("UPDATE users SET active = 1");
} catch (Exception e) {
    System.out.println("Database operation failed: " + e.getMessage());
}
// Connection is automatically closed here
```

## Best Practices

### 🛡️ **Exception Handling Guidelines**

#### 1. **Catch Specific Exceptions First**
```java
// Good - specific to general
try {
    riskyOperation();
} catch (FileNotFoundException e) {
    // Handle file not found
} catch (IOException e) {
    // Handle other I/O errors
} catch (Exception e) {
    // Handle unexpected errors
}
```

#### 2. **Don't Catch Generic Exceptions**
```java
// Bad - catches everything including programming errors
try {
    riskyOperation();
} catch (Exception e) {  // Too broad
    // Handle everything
}

// Good - let programming errors propagate
try {
    riskyOperation();
} catch (IOException e) {  // Specific and recoverable
    // Handle I/O errors
}
```

#### 3. **Don't Swallow Exceptions**
```java
// Bad - silently ignores the error
try {
    riskyOperation();
} catch (Exception e) {
    // Do nothing - error is lost!
}

// Good - at least log the error
try {
    riskyOperation();
} catch (Exception e) {
    logger.error("Operation failed", e);
    // Or re-throw or handle appropriately
}
```

### 📋 **Resource Management**

#### 1. **Always Close Resources**
```java
// Good - try-with-resources
try (FileReader reader = new FileReader("file.txt")) {
    // Use reader
} catch (IOException e) {
    // Handle error
}

// Alternative - manual cleanup in finally
FileReader reader = null;
try {
    reader = new FileReader("file.txt");
    // Use reader
} finally {
    if (reader != null) {
        reader.close();
    }
}
```

#### 2. **Use Try-With-Resources**
```java
// Preferred for any AutoCloseable resources
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement stmt = conn.prepareStatement(sql);
     ResultSet rs = stmt.executeQuery()) {

    while (rs.next()) {
        // Process results
    }
} catch (SQLException e) {
    logger.error("Database operation failed", e);
}
```

### 🎯 **Exception Design**

#### 1. **Create Meaningful Custom Exceptions**
```java
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("User not found with ID: " + userId);
    }
}
```

#### 2. **Use Appropriate Exception Types**
- **Checked exceptions** for recoverable conditions
- **Unchecked exceptions** for programming errors
- **Custom exceptions** for domain-specific errors

#### 3. **Provide Context in Exception Messages**
```java
// Bad
throw new IllegalArgumentException("Invalid input");

// Good
throw new IllegalArgumentException(
    "Invalid age: " + age + ". Age must be between 0 and 120");
```

### 🔍 **Debugging and Logging**

#### 1. **Log Exceptions Properly**
```java
try {
    processOrder(order);
} catch (OrderProcessingException e) {
    logger.error("Failed to process order {}: {}", order.getId(), e.getMessage(), e);
    // Include full stack trace for debugging
}
```

#### 2. **Preserve Stack Traces**
```java
// When re-throwing, preserve the original cause
try {
    lowLevelOperation();
} catch (LowLevelException e) {
    throw new HighLevelException("Operation failed at high level", e);
}
```

### 📊 **Performance Considerations**

#### 1. **Avoid Expensive Operations in Catch Blocks**
```java
// Bad - expensive operation in catch
try {
    fastOperation();
} catch (Exception e) {
    performExpensiveLogging(e);  // Slow!
}

// Good - fast error handling
try {
    fastOperation();
} catch (Exception e) {
    logErrorAsync(e);  // Fast logging
}
```

#### 2. **Use Appropriate Exception Types**
- Avoid creating exception objects unnecessarily
- Use standard exceptions when possible
- Consider performance impact of stack trace generation

### 🔄 **Common Patterns**

#### Exception Translation
```java
public User findUser(Long id) {
    try {
        return userRepository.findById(id);
    } catch (DataAccessException e) {
        throw new UserNotFoundException(id, e);
    }
}
```

#### Exception Wrapping
```java
public void importData(String filename) throws ImportException {
    try {
        validateFile(filename);
        parseFile(filename);
        saveData();
    } catch (IOException | ValidationException e) {
        throw new ImportException("Failed to import data from " + filename, e);
    }
}
```

## Practice Exercises

1. **File Processor**: Create a program that reads a file, processes data, and handles various I/O exceptions
2. **Calculator with Validation**: Build a calculator that validates inputs and throws custom exceptions for invalid operations
3. **Database Operations**: Implement database operations with proper exception handling and resource management
4. **Configuration Loader**: Create a configuration loader that handles missing files and invalid formats gracefully
5. **Web Service Client**: Build a client that handles network timeouts, authentication failures, and server errors

## Next Steps

After mastering exception handling, explore:
- **Collections Framework** (`docs/COLLECTIONS.md`) - Data structures and algorithms
- **Streams and Lambdas** (`docs/STREAMS.md`) - Functional programming
- **Banking Application** - Real-world exception handling in the `banking/` folder

Proper exception handling is crucial for building robust, maintainable Java applications. It ensures your programs fail gracefully and provide useful debugging information when things go wrong.
