# Java Collections Framework

This comprehensive guide covers Java's Collections Framework, including Lists, Sets, Maps, and the Comparator/Comparable interfaces for sorting and ordering.

## 📋 Table of Contents
- [Collections Framework Overview](#collections-framework-overview)
- [List Interface](#list-interface)
- [Set Interface](#set-interface)
- [Map Interface](#map-interface)
- [Queue Interface](#queue-interface)
- [Comparable Interface](#comparable-interface)
- [Comparator Interface](#comparator-interface)
- [Collections Utility Class](#collections-utility-class)
- [Generic Collections](#generic-collections)
- [Performance Considerations](#performance-considerations)
- [Best Practices](#best-practices)

## Collections Framework Overview

The Collections Framework provides a unified architecture for storing and manipulating groups of objects. It consists of:

- **Interfaces**: Abstract data types (List, Set, Map, Queue)
- **Implementations**: Concrete classes (ArrayList, HashSet, HashMap)
- **Algorithms**: Sorting, searching, and manipulation methods

### Framework Hierarchy

```
Collection (Interface)
├── List (Interface)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
├── Set (Interface)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
└── Queue (Interface)
    ├── PriorityQueue
    └── LinkedList

Map (Interface)
├── HashMap
├── LinkedHashMap
├── TreeMap
└── Hashtable
```

## List Interface

Lists maintain ordered collections that allow duplicate elements and positional access.

### ArrayList - Dynamic Arrays

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList
        List<String> fruits = new ArrayList<>();

        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // Add at specific index
        fruits.add(1, "Mango");

        // Access elements
        String firstFruit = fruits.get(0);  // "Apple"

        // Modify elements
        fruits.set(2, "Grape");  // Replace "Banana" with "Grape"

        // Remove elements
        fruits.remove("Orange");  // Remove by value
        fruits.remove(0);         // Remove by index

        // Iterate through list
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Check size and contents
        System.out.println("Size: " + fruits.size());
        System.out.println("Contains Apple: " + fruits.contains("Apple"));
        System.out.println("Is empty: " + fruits.isEmpty());
    }
}
```

**Characteristics:**
- **Fast random access** (get/set by index: O(1))
- **Slow insertions/deletions** in middle (O(n))
- **Good for** read-heavy operations
- **Default capacity**: 10, grows by 1.5x when full

### LinkedList - Doubly Linked Lists

```java
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> tasks = new LinkedList<>();

        // Add elements
        tasks.add("Task 1");
        tasks.add("Task 3");
        tasks.addFirst("Task 0");    // Add to beginning
        tasks.addLast("Task 4");     // Add to end
        tasks.add(2, "Task 2");      // Add at index

        // Access elements
        String first = tasks.getFirst();    // "Task 0"
        String last = tasks.getLast();      // "Task 4"

        // Remove elements
        tasks.removeFirst();         // Remove from beginning
        tasks.removeLast();          // Remove from end
        tasks.remove("Task 2");      // Remove by value

        System.out.println("Remaining tasks: " + tasks);
    }
}
```

**Characteristics:**
- **Fast insertions/deletions** at ends (O(1))
- **Slow random access** (get/set: O(n))
- **Good for** frequent additions/removals
- **Implements both List and Deque interfaces**

**See Also:** `src/main/java/com/example/learningjava/examples/collections/ListDemo.java`

## Set Interface

Sets store unique elements without duplicates and don't maintain insertion order (except LinkedHashSet).

### HashSet - Hash Table Implementation

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> uniqueWords = new HashSet<>();

        // Add elements (duplicates are ignored)
        uniqueWords.add("hello");
        uniqueWords.add("world");
        uniqueWords.add("hello");  // Duplicate - ignored
        uniqueWords.add("java");

        System.out.println("Unique words: " + uniqueWords);
        // Output: [world, java, hello] (order not guaranteed)

        // Check membership
        System.out.println("Contains 'java': " + uniqueWords.contains("java"));

        // Remove elements
        uniqueWords.remove("world");

        // Iterate (order not guaranteed)
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }
}
```

### LinkedHashSet - Maintains Insertion Order

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> orderedUnique = new LinkedHashSet<>();

        orderedUnique.add("first");
        orderedUnique.add("second");
        orderedUnique.add("first");  // Duplicate - ignored
        orderedUnique.add("third");

        System.out.println("Ordered unique: " + orderedUnique);
        // Output: [first, second, third] (insertion order maintained)
    }
}
```

### TreeSet - Sorted Set

```java
import java.util.TreeSet;
import java.util.Set;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<Integer> sortedNumbers = new TreeSet<>();

        sortedNumbers.add(5);
        sortedNumbers.add(2);
        sortedNumbers.add(8);
        sortedNumbers.add(1);

        System.out.println("Sorted numbers: " + sortedNumbers);
        // Output: [1, 2, 5, 8] (automatically sorted)

        // Useful methods for sorted sets
        System.out.println("First: " + ((TreeSet<Integer>) sortedNumbers).first());
        System.out.println("Last: " + ((TreeSet<Integer>) sortedNumbers).last());
        System.out.println("Numbers < 5: " + ((TreeSet<Integer>) sortedNumbers).headSet(5));
        System.out.println("Numbers >= 5: " + ((TreeSet<Integer>) sortedNumbers).tailSet(5));
    }
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/collections/SetDemo.java`

## Map Interface

Maps store key-value pairs where each key maps to exactly one value.

### HashMap - Hash Table Implementation

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> studentGrades = new HashMap<>();

        // Put key-value pairs
        studentGrades.put("Alice", 95);
        studentGrades.put("Bob", 87);
        studentGrades.put("Charlie", 92);

        // Access values by key
        int aliceGrade = studentGrades.get("Alice");  // 95

        // Check if key exists
        if (studentGrades.containsKey("Bob")) {
            System.out.println("Bob's grade: " + studentGrades.get("Bob"));
        }

        // Iterate over entries
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Iterate over keys
        for (String name : studentGrades.keySet()) {
            System.out.println(name + " scored " + studentGrades.get(name));
        }

        // Iterate over values
        for (int grade : studentGrades.values()) {
            System.out.println("Grade: " + grade);
        }

        // Remove entries
        studentGrades.remove("Charlie");

        System.out.println("Final map: " + studentGrades);
    }
}
```

### LinkedHashMap - Maintains Insertion Order

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, String> capitals = new LinkedHashMap<>();

        capitals.put("USA", "Washington D.C.");
        capitals.put("UK", "London");
        capitals.put("France", "Paris");

        System.out.println("Capitals (insertion order): " + capitals);
        // Output: {USA=Washington D.C., UK=London, France=Paris}
    }
}
```

### TreeMap - Sorted Map

```java
import java.util.TreeMap;
import java.util.Map;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> sortedMap = new TreeMap<>();

        sortedMap.put("zebra", 1);
        sortedMap.put("apple", 2);
        sortedMap.put("banana", 3);

        System.out.println("Sorted by keys: " + sortedMap);
        // Output: {apple=2, banana=3, zebra=1}

        // Useful methods for sorted maps
        System.out.println("First key: " + ((TreeMap<String, Integer>) sortedMap).firstKey());
        System.out.println("Last key: " + ((TreeMap<String, Integer>) sortedMap).lastKey());
    }
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/collections/MapDemo.java`

## Queue Interface

Queues follow FIFO (First In, First Out) principle.

### PriorityQueue - Priority-based Ordering

```java
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Min-heap by default (smallest first)
        Queue<Integer> numbers = new PriorityQueue<>();

        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        // Elements are dequeued in priority order
        while (!numbers.isEmpty()) {
            System.out.println("Dequeued: " + numbers.poll());
        }
        // Output: 1, 2, 5, 8
    }
}
```

## Comparable Interface

Comparable allows objects to be compared and sorted naturally.

```java
public class Student implements Comparable<Student> {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Natural ordering: by marks (ascending)
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }

    // Getters
    public String getName() { return name; }
    public int getMarks() { return marks; }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}
```

### Usage with Collections.sort()

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));

        // Sort using natural ordering (by marks)
        Collections.sort(students);

        System.out.println("Students sorted by marks:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/collections/ComparableDemo.java`

## Comparator Interface

Comparator allows custom comparison logic without modifying the class.

### Method 1: Anonymous Class

```java
import java.util.Comparator;

Comparator<Student> byName = new Comparator<Student>() {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
};
```

### Method 2: Lambda Expression

```java
Comparator<Student> byNameLambda = (s1, s2) -> s1.getName().compareTo(s2.getName());
```

### Method 3: Method Reference

```java
Comparator<Student> byNameRef = Comparator.comparing(Student::getName);
```

### Method 4: Separate Comparator Class

```java
public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
```

### Advanced Comparator Usage

```java
import java.util.Comparator;

public class ComparatorExamples {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 92),
            new Student("Charlie", 78)
        );

        // Sort by name (ascending)
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("By name: " + students);

        // Sort by marks (descending)
        students.sort(Comparator.comparing(Student::getMarks).reversed());
        System.out.println("By marks descending: " + students);

        // Sort by name length, then by name
        students.sort(Comparator.comparing((Student s) -> s.getName().length())
                             .thenComparing(Student::getName));
        System.out.println("By name length then name: " + students);
    }
}
```

**See Also:** `src/main/java/com/example/learningjava/examples/collections/ComparatorDemo.java`

## Collections Utility Class

The Collections class provides static methods for working with collections.

### Sorting and Searching

```java
import java.util.*;

public class CollectionsUtilityExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);

        // Sort the list
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        // Binary search (list must be sorted)
        int index = Collections.binarySearch(numbers, 8);
        System.out.println("Index of 8: " + index);

        // Reverse the list
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        // Shuffle randomly
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);

        // Find min/max
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));

        // Fill with specific value
        Collections.fill(numbers, 0);
        System.out.println("Filled with 0: " + numbers);
    }
}
```

### Creating Unmodifiable Collections

```java
List<String> modifiable = new ArrayList<>();
modifiable.add("Java");
modifiable.add("Python");

// Create unmodifiable view
List<String> unmodifiable = Collections.unmodifiableList(modifiable);

// This will throw UnsupportedOperationException
// unmodifiable.add("JavaScript");
```

## Generic Collections

Generics ensure type safety and eliminate casting.

### Generic Class Example

```java
public class GenericBox<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}

// Usage
GenericBox<String> stringBox = new GenericBox<>();
stringBox.set("Hello World");

GenericBox<Integer> intBox = new GenericBox<>();
intBox.set(42);
```

### Bounded Type Parameters

```java
// Only Number and its subclasses
public class Calculator<T extends Number> {
    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}

// Usage
Calculator<Integer> intCalc = new Calculator<>();
Calculator<Double> doubleCalc = new Calculator<>();
```

### Wildcards

```java
// Unbounded wildcard
public static void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}

// Upper bounded wildcard
public static double sum(List<? extends Number> numbers) {
    double total = 0;
    for (Number number : numbers) {
        total += number.doubleValue();
    }
    return total;
}

// Lower bounded wildcard
public static void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
    list.add(3);
}
```

## Performance Considerations

### Time Complexity Comparison

| Operation | ArrayList | LinkedList | HashSet | HashMap |
|-----------|-----------|------------|---------|---------|
| get(index) | O(1) | O(n) | - | - |
| add(element) | O(1)* | O(1) | O(1) | O(1) |
| add(index, element) | O(n) | O(n) | - | - |
| remove(index) | O(n) | O(n) | O(1) | O(1) |
| contains | O(n) | O(n) | O(1) | O(1) |

*O(1) amortized for ArrayList

### Space Complexity

- **ArrayList**: O(n) - stores elements + some overhead
- **LinkedList**: O(n) - stores elements + node references
- **HashSet/HashMap**: O(n) - stores elements + hash table overhead
- **TreeSet/TreeMap**: O(n) - stores elements + tree structure

### Choosing the Right Collection

- **ArrayList**: Fast access by index, good for read-heavy operations
- **LinkedList**: Fast insertions/deletions, good for queue/stack operations
- **HashSet/HashMap**: Fast lookups, when order doesn't matter
- **LinkedHashSet/LinkedHashMap**: Ordered insertion, fast lookups
- **TreeSet/TreeMap**: Sorted order, range queries, slower operations

## Best Practices

### 🚀 **Performance Tips**
- **Choose appropriate collection** based on access patterns
- **Initialize with proper capacity** when known
- **Use bulk operations** when possible (addAll, removeAll)
- **Consider primitive collections** for large datasets (when available)

### 🛡️ **Safety and Correctness**
- **Use generics** to ensure type safety
- **Handle null values** appropriately (most collections allow nulls)
- **Synchronize concurrent access** when needed
- **Validate inputs** before operations

### 📖 **Readability and Maintainability**
- **Use meaningful variable names** for collections
- **Add comments** for complex collection operations
- **Consider method extraction** for complex collection logic
- **Use appropriate interfaces** (List, Set, Map) rather than implementations

### 🔄 **Common Patterns**

#### Converting Between Collections

```java
// List to Set (remove duplicates)
List<String> list = Arrays.asList("a", "b", "a", "c");
Set<String> set = new HashSet<>(list);

// Set to List
List<String> listFromSet = new ArrayList<>(set);

// Array to List
String[] array = {"x", "y", "z"};
List<String> listFromArray = Arrays.asList(array);
```

#### Defensive Copying

```java
// Return defensive copy to prevent external modification
public List<String> getItems() {
    return new ArrayList<>(items);  // Return copy, not original
}

// Accept defensive copy
public void setItems(List<String> newItems) {
    this.items = new ArrayList<>(newItems);  // Store copy
}
```

#### Stream Operations

```java
// Modern approach using streams
List<String> result = names.stream()
    .filter(name -> name.length() > 3)
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());
```

## Practice Exercises

1. **Student Management System**: Use ArrayList to store students, HashMap for name-to-student lookup
2. **Word Frequency Counter**: Use HashMap to count word occurrences in text
3. **Unique Email Addresses**: Use HashSet to store unique email addresses
4. **Priority Task Manager**: Use PriorityQueue for task scheduling
5. **Sorted Phone Book**: Use TreeMap for alphabetically sorted contacts

## Next Steps

After mastering collections, explore:
- **Streams and Lambdas** (`docs/STREAMS.md`) - Modern functional programming
- **Exception Handling** (`docs/EXCEPTIONS.md`) - Error management
- **Banking Application** - Real-world usage in the `banking/` folder

Collections are fundamental to Java development. Understanding when and how to use different collection types is crucial for writing efficient and maintainable code.
