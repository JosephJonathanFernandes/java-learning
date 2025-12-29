# Java Streams and Lambda Expressions

This comprehensive guide covers Java 8+ Streams API and functional programming concepts including lambda expressions, method references, and the key operations: filter, map, and reduce.

## 📋 Table of Contents
- [Introduction to Streams](#introduction-to-streams)
- [Lambda Expressions](#lambda-expressions)
- [Method References](#method-references)
- [Creating Streams](#creating-streams)
- [Intermediate Operations](#intermediate-operations)
- [Terminal Operations](#terminal-operations)
- [Filter Operation](#filter-operation)
- [Map Operation](#map-operation)
- [Reduce Operation](#reduce-operation)
- [Parallel Streams](#parallel-streams)
- [Best Practices](#best-practices)

## Introduction to Streams

Streams represent a sequence of elements that can be processed in a declarative way. Unlike collections, streams don't store data - they provide a pipeline for processing data.

### Key Characteristics

- **Lazy Evaluation**: Operations are only executed when a terminal operation is invoked
- **Functional Style**: Uses lambda expressions and method references
- **Immutability**: Original data source is never modified
- **Chainable**: Multiple operations can be chained together

### Stream Pipeline

```
Source → Intermediate Operations → Terminal Operation → Result
```

```java
// Example pipeline
List<String> result = names.stream()           // Source
    .filter(name -> name.length() > 3)         // Intermediate
    .map(String::toUpperCase)                  // Intermediate
    .sorted()                                  // Intermediate
    .collect(Collectors.toList());             // Terminal
```

## Lambda Expressions

Lambda expressions provide a concise way to represent anonymous functions. They are the foundation of functional programming in Java.

### Basic Syntax

```java
(parameters) -> expression
(parameters) -> { statements; }
```

### Examples

```java
// No parameters
Runnable runnable = () -> System.out.println("Hello");

// One parameter
Function<String, Integer> length = str -> str.length();

// Multiple parameters
BinaryOperator<Integer> sum = (a, b) -> a + b;

// With explicit types
BinaryOperator<Integer> multiply = (Integer a, Integer b) -> {
    return a * b;
};

// Complex logic
Predicate<String> isLongWord = word -> {
    System.out.println("Checking: " + word);
    return word.length() > 5;
};
```

### Variable Capture

```java
public class LambdaCapture {
    public static void main(String[] args) {
        int factor = 2;

        // Lambda can access local variables (effectively final)
        Function<Integer, Integer> multiplier = x -> x * factor;

        System.out.println(multiplier.apply(5));  // Output: 10
    }
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/streams/LambdaSortDemo.java`

## Method References

Method references provide a shorthand for lambda expressions that call existing methods.

### Types of Method References

```java
// 1. Static method reference
Function<String, Integer> parseInt = Integer::parseInt;

// 2. Instance method reference (on specific instance)
String prefix = "Mr. ";
Function<String, String> addPrefix = prefix::concat;

// 3. Instance method reference (on parameter)
Function<String, Integer> length = String::length;

// 4. Constructor reference
Supplier<List<String>> listFactory = ArrayList::new;
Function<String, Integer> stringToInt = Integer::new;
```

### Examples

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Method reference for static method
names.stream().map(String::toUpperCase);

// Method reference for instance method
names.stream().filter(String::isEmpty);

// Method reference for constructor
names.stream().map(String::new);
```

## Creating Streams

There are several ways to create streams from different data sources.

### From Collections

```java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> streamFromList = list.stream();
Stream<String> parallelStream = list.parallelStream();
```

### From Arrays

```java
String[] array = {"x", "y", "z"};
Stream<String> streamFromArray = Arrays.stream(array);
Stream<String> partialStream = Arrays.stream(array, 1, 3); // "y", "z"
```

### From Values

```java
Stream<String> streamOfValues = Stream.of("apple", "banana", "cherry");
Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
```

### Infinite Streams

```java
// Generate infinite stream
Stream<Integer> infiniteNumbers = Stream.iterate(1, n -> n + 1);

// Generate with limit
List<Integer> firstTen = Stream.iterate(1, n -> n + 1)
    .limit(10)
    .collect(Collectors.toList());

// Random numbers
Stream<Double> randoms = Stream.generate(Math::random).limit(5);
```

### From Files

```java
try {
    Stream<String> lines = Files.lines(Paths.get("file.txt"));
    lines.forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();
}
```

## Intermediate Operations

Intermediate operations transform a stream into another stream. They are lazy and only execute when a terminal operation is called.

### Common Intermediate Operations

#### filter(Predicate<T>)
Filters elements based on a condition.

```java
List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");

List<String> longFruits = fruits.stream()
    .filter(fruit -> fruit.length() > 5)
    .collect(Collectors.toList());
// Result: ["banana", "cherry"]
```

#### map(Function<T, R>)
Transforms each element to another type.

```java
List<String> words = Arrays.asList("hello", "world");

List<Integer> lengths = words.stream()
    .map(String::length)
    .collect(Collectors.toList());
// Result: [5, 5]
```

#### flatMap(Function<T, Stream<R>>)
Flattens nested structures.

```java
List<List<String>> nestedList = Arrays.asList(
    Arrays.asList("a", "b"),
    Arrays.asList("c", "d")
);

List<String> flatList = nestedList.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());
// Result: ["a", "b", "c", "d"]
```

#### distinct()
Removes duplicate elements.

```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3);

List<Integer> distinctNumbers = numbers.stream()
    .distinct()
    .collect(Collectors.toList());
// Result: [1, 2, 3]
```

#### sorted() / sorted(Comparator)
Sorts elements.

```java
List<String> fruits = Arrays.asList("banana", "apple", "cherry");

List<String> sortedFruits = fruits.stream()
    .sorted()
    .collect(Collectors.toList());
// Result: ["apple", "banana", "cherry"]

List<String> reverseSorted = fruits.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());
```

#### limit(long) / skip(long)
Limits or skips elements.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

List<Integer> firstThree = numbers.stream()
    .limit(3)
    .collect(Collectors.toList());
// Result: [1, 2, 3]

List<Integer> skipFirstThree = numbers.stream()
    .skip(3)
    .collect(Collectors.toList());
// Result: [4, 5, 6, 7, 8, 9, 10]
```

#### peek(Consumer<T>)
Performs an action on each element without modifying the stream.

```java
List<String> result = Arrays.asList("a", "b", "c").stream()
    .peek(System.out::println)  // Debug: prints each element
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

## Terminal Operations

Terminal operations produce a result or side effect, triggering the execution of the stream pipeline.

### Common Terminal Operations

#### collect(Collectors)
Collects elements into various data structures.

```java
List<String> list = stream.collect(Collectors.toList());
Set<String> set = stream.collect(Collectors.toSet());
String joined = stream.collect(Collectors.joining(", "));
```

#### forEach(Consumer<T>)
Performs an action for each element.

```java
names.stream().forEach(System.out::println);
names.forEach(System.out::println);  // Collection.forEach (not a stream operation)
```

#### reduce(BinaryOperator<T>)
Combines elements into a single result.

```java
Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
Integer sumWithIdentity = numbers.stream().reduce(0, Integer::sum);
```

#### count()
Returns the number of elements.

```java
long count = stream.count();
```

#### findFirst() / findAny()
Finds elements (short-circuiting operations).

```java
Optional<String> first = stream.findFirst();
Optional<String> any = stream.findAny();
```

#### anyMatch() / allMatch() / noneMatch()
Checks if elements match a predicate.

```java
boolean anyLong = words.stream().anyMatch(word -> word.length() > 5);
boolean allLong = words.stream().allMatch(word -> word.length() > 5);
boolean noneLong = words.stream().noneMatch(word -> word.length() > 5);
```

#### min() / max()
Finds minimum/maximum elements.

```java
Optional<Integer> min = numbers.stream().min(Integer::compare);
Optional<Integer> max = numbers.stream().max(Integer::compare);
```

## Filter Operation

The `filter()` operation selects elements that match a given predicate.

### Basic Filtering

```java
List<Student> students = Arrays.asList(
    createStudent("Alice", 85),
    createStudent("Bob", 92),
    createStudent("Charlie", 78),
    createStudent("Diana", 96),
    createStudent("Eve", 88)
);

// Filter students with marks >= 90
List<Student> highScorers = students.stream()
    .filter(student -> student.getMarks() >= 90)
    .collect(Collectors.toList());

System.out.println("High scorers: " + highScorers);
```

### Complex Filtering

```java
// Filter by multiple conditions
List<Student> excellentStudents = students.stream()
    .filter(student -> student.getMarks() >= 90 && student.getName().startsWith("A"))
    .collect(Collectors.toList());

// Filter with method reference
List<String> longNames = students.stream()
    .map(Student::getName)
    .filter(name -> name.length() > 4)
    .collect(Collectors.toList());
```

### Advanced Filtering Patterns

```java
// Filter with null check
List<String> nonNullNames = students.stream()
    .map(Student::getName)
    .filter(Objects::nonNull)
    .collect(Collectors.toList());

// Filter with range check
List<Student> averageStudents = students.stream()
    .filter(student -> {
        int marks = student.getMarks();
        return marks >= 70 && marks <= 85;
    })
    .collect(Collectors.toList());
```

**See Also:** `src/main/java/com/example/learningjava/examples/streams/StreamFilterDemo.java`

## Map Operation

The `map()` operation transforms each element in the stream to another type.

### Basic Mapping

```java
List<String> names = students.stream()
    .map(Student::getName)
    .collect(Collectors.toList());

List<Integer> marks = students.stream()
    .map(Student::getMarks)
    .collect(Collectors.toList());
```

### Type Transformation

```java
// String to Integer
List<String> stringNumbers = Arrays.asList("1", "2", "3", "4", "5");
List<Integer> numbers = stringNumbers.stream()
    .map(Integer::parseInt)
    .collect(Collectors.toList());

// Object to formatted string
List<String> descriptions = students.stream()
    .map(student -> student.getName() + " scored " + student.getMarks())
    .collect(Collectors.toList());
```

### Complex Mapping

```java
// Map to custom objects
List<StudentDTO> dtos = students.stream()
    .map(student -> new StudentDTO(student.getName(), student.getMarks()))
    .collect(Collectors.toList());

// Map with conditional logic
List<String> grades = students.stream()
    .map(student -> {
        int marks = student.getMarks();
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else return "F";
    })
    .collect(Collectors.toList());
```

### Method Reference Mapping

```java
// Using method references
List<String> upperCaseNames = students.stream()
    .map(Student::getName)
    .map(String::toUpperCase)
    .collect(Collectors.toList());

List<Integer> nameLengths = students.stream()
    .map(Student::getName)
    .map(String::length)
    .collect(Collectors.toList());
```

**See Also:** `src/main/java/com/example/learningjava/examples/streams/StreamMapDemo.java`

## Reduce Operation

The `reduce()` operation combines all elements in the stream into a single result.

### Basic Reduction

```java
// Sum of all marks
Optional<Integer> totalMarks = students.stream()
    .map(Student::getMarks)
    .reduce(Integer::sum);

// With identity value (avoids Optional)
Integer totalMarksWithIdentity = students.stream()
    .map(Student::getMarks)
    .reduce(0, Integer::sum);
```

### Custom Reduction Logic

```java
// Find student with highest marks
Optional<Student> topStudent = students.stream()
    .reduce((s1, s2) -> s1.getMarks() > s2.getMarks() ? s1 : s2);

// Concatenate all names
String allNames = students.stream()
    .map(Student::getName)
    .reduce("", (a, b) -> a + (a.isEmpty() ? "" : ", ") + b);

// Calculate product
Integer product = students.stream()
    .map(Student::getMarks)
    .reduce(1, (a, b) -> a * b);
```

### Advanced Reduction

```java
// Find maximum marks
OptionalInt maxMarks = students.stream()
    .mapToInt(Student::getMarks)
    .max();

// Calculate average
OptionalDouble average = students.stream()
    .mapToInt(Student::getMarks)
    .average();

// Count students above average
long aboveAverage = students.stream()
    .mapToInt(Student::getMarks)
    .filter(marks -> marks > average.orElse(0.0))
    .count();
```

### Statistics with Reduction

```java
// Custom statistics
IntSummaryStatistics stats = students.stream()
    .mapToInt(Student::getMarks)
    .summaryStatistics();

System.out.println("Count: " + stats.getCount());
System.out.println("Sum: " + stats.getSum());
System.out.println("Min: " + stats.getMin());
System.out.println("Max: " + stats.getMax());
System.out.println("Average: " + stats.getAverage());
```

**See Also:** `src/main/java/com/example/learningjava/examples/streams/StreamReduceDemo.java`

## Parallel Streams

Parallel streams can improve performance for large datasets by utilizing multiple CPU cores.

### Creating Parallel Streams

```java
// From collection
Stream<String> parallelStream = list.parallelStream();

// Convert sequential to parallel
Stream<String> parallelFromSequential = sequentialStream.parallel();

// Convert parallel to sequential
Stream<String> sequentialFromParallel = parallelStream.sequential();
```

### When to Use Parallel Streams

```java
// Good candidates for parallel processing
List<Integer> largeNumbers = // ... thousands of elements

// Parallel computation
int sum = largeNumbers.parallelStream()
    .filter(n -> n % 2 == 0)
    .mapToInt(n -> n * n)
    .sum();

// File processing
try {
    long totalLines = Files.walk(Paths.get("large-directory"))
        .parallel()
        .filter(Files::isRegularFile)
        .filter(path -> path.toString().endsWith(".java"))
        .mapToLong(path -> {
            try {
                return Files.lines(path).count();
            } catch (IOException e) {
                return 0L;
            }
        })
        .sum();
} catch (IOException e) {
    e.printStackTrace();
}
```

### Parallel Stream Considerations

```java
// Be careful with stateful operations
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// This might not work as expected in parallel
List<Integer> result = numbers.parallelStream()
    .peek(System.out::println)  // Non-deterministic order
    .collect(Collectors.toList());

// Avoid shared mutable state
class Accumulator {
    private int sum = 0;

    // Don't do this in parallel streams
    public void add(int value) {
        sum += value;  // Race condition!
    }
}
```

### Performance Guidelines

- Use parallel streams for CPU-intensive operations
- Avoid for small datasets (overhead > benefit)
- Ensure operations are stateless and independent
- Consider using `Collectors.toConcurrentMap()` for better parallel performance
- Profile before and after to measure actual benefits

## Best Practices

### 🚀 **Performance Tips**
- **Use appropriate data types**: `mapToInt()`, `mapToDouble()` for primitives
- **Chain efficiently**: Order operations to reduce intermediate results
- **Avoid unnecessary boxing**: Use primitive streams when possible
- **Consider parallel execution**: For large datasets and CPU-intensive operations

### 🛡️ **Correctness Guidelines**
- **Avoid stateful operations**: Don't modify shared state in lambda expressions
- **Handle null values**: Use `Objects::nonNull` or `Objects::isNull` in filters
- **Be careful with exceptions**: Checked exceptions need special handling
- **Understand laziness**: Streams are lazy - operations don't execute until terminal operation

### 📖 **Readability and Maintainability**
- **Use method references**: When possible, prefer `String::toUpperCase` over `s -> s.toUpperCase()`
- **Extract complex lambdas**: Move complex logic to separate methods
- **Add comments**: For non-obvious stream operations
- **Use meaningful variable names**: Especially in lambda parameters

### 🔄 **Common Patterns**

#### Builder Pattern with Streams

```java
public class Person {
    private String name;
    private int age;
    private String city;

    // Constructor and getters...

    public static List<Person> createSamplePeople() {
        return Stream.of(
            new Person("Alice", 25, "New York"),
            new Person("Bob", 30, "London"),
            new Person("Charlie", 35, "Paris")
        ).collect(Collectors.toList());
    }
}
```

#### Grouping and Partitioning

```java
// Group by city
Map<String, List<Person>> peopleByCity = people.stream()
    .collect(Collectors.groupingBy(Person::getCity));

// Partition by age
Map<Boolean, List<Person>> partitionedByAge = people.stream()
    .collect(Collectors.partitioningBy(person -> person.getAge() >= 30));
```

#### Complex Filtering and Mapping

```java
List<String> result = people.stream()
    .filter(person -> person.getAge() >= 18)
    .filter(person -> !"Unknown".equals(person.getCity()))
    .map(Person::getName)
    .map(String::toUpperCase)
    .distinct()
    .sorted()
    .collect(Collectors.toList());
```

## Practice Exercises

1. **Word Processor**: Use streams to process text files - count words, find longest/shortest words, filter by length
2. **Student Statistics**: Calculate class statistics using map, filter, and reduce operations
3. **Data Transformation**: Convert between different data formats using map operations
4. **Parallel Processing**: Implement parallel stream processing for large datasets
5. **Custom Collectors**: Create custom collectors for specific aggregation needs

## Debugging Streams

### Common Debugging Techniques

```java
// Use peek() for debugging
List<String> result = words.stream()
    .filter(word -> {
        System.out.println("Filtering: " + word);
        return word.length() > 3;
    })
    .map(word -> {
        System.out.println("Mapping: " + word);
        return word.toUpperCase();
    })
    .peek(System.out::println)  // Debug intermediate result
    .collect(Collectors.toList());

// Convert to list to inspect intermediate results
List<String> intermediate = words.stream()
    .filter(word -> word.length() > 3)
    .collect(Collectors.toList());  // Inspect here

List<String> finalResult = intermediate.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

## Next Steps

After mastering Streams and Lambdas, explore:
- **Exception Handling** (`docs/EXCEPTIONS.md`) - Error management and custom exceptions
- **Banking Application** - Real-world application in the `banking/` folder
- **Advanced Topics** - Generics, Reflection, Concurrency

Streams represent a paradigm shift towards functional programming in Java. Mastering these concepts will significantly improve your ability to write clean, efficient, and maintainable code.
