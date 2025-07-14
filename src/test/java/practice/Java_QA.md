# Java SDET III Interview Questions & Answers (Non-Coding)

---

## 1. What are the four main OOPS principles in Java? Explain with examples.

**Answer:**
- **Abstraction:** Hiding internal details and showing only functionality. Achieved using abstract classes and interfaces.
  - *Example:* `List` is an interface; its implementation (e.g., `ArrayList`) is hidden from the user.
- **Encapsulation:** Wrapping data (variables) and code (methods) together as a single unit. Achieved using classes and access modifiers.
  - *Example:* Private fields with public getters/setters.
- **Inheritance:** Acquiring properties and behaviors from another class (parent/superclass).
  - *Example:* `class Dog extends Animal {}`
- **Polymorphism:** Ability to take many forms. Achieved via method overloading (compile-time) and overriding (runtime).
  - *Example:* `Animal a = new Dog(); a.speak();` (calls Dog's speak)

---

## 2. Can we create an object of an abstract class or interface?

**Answer:**
- **Abstract class:** Cannot instantiate directly. You can create an object of a subclass that extends the abstract class.
  - *Example:* `abstract class A {}` — `A a = new A(); // Error`
- **Interface:** Cannot instantiate directly. You can create an object of a class that implements the interface.
  - *Example:* `interface I {}` — `I i = new I(); // Error`
- **Anonymous class:** You can create an anonymous subclass/implementation:
  ```java
  A a = new A() { /* implementation */ };
  I i = new I() { /* implementation */ };
  ```

---

## 3. Can abstract classes have constructors? What is their use?

**Answer:**
- Yes, abstract classes can have constructors. They are called when a subclass object is created, to initialize fields of the abstract class.
  - *Example:*
    ```java
    abstract class A {
      A() { System.out.println("A's constructor"); }
    }
    class B extends A {
      B() { System.out.println("B's constructor"); }
    }
    // Output: A's constructor\nB's constructor
    ```

---

## 4. Can interfaces have variables and methods with implementation?

**Answer:**
- **Variables:** All variables in interfaces are implicitly `public static final` (constants).
- **Methods:**
  - Before Java 8: Only abstract methods (no body).
  - Java 8+: Can have `default` and `static` methods with implementation.
  - Java 9+: Can have `private` methods (for internal use).
  - *Example:*
    ```java
    interface I {
      int X = 10; // public static final
      void m(); // abstract
      default void d() { System.out.println("default"); }
      static void s() { System.out.println("static"); }
    }
    ```

---

## 5. What is a functional interface? Give an example.

**Answer:**
- An interface with exactly one abstract method. Used as the basis for lambda expressions and method references.
- Annotated with `@FunctionalInterface` (optional but recommended).
- *Example:*
  ```java
  @FunctionalInterface
  interface MyFunc {
    void execute();
  }
  // Usage:
  MyFunc f = () -> System.out.println("Hello");
  f.execute();
  ```
- Common examples: `Runnable`, `Callable`, `Comparator`, `Function<T,R>`.

---

## 6. Can we override static methods? Can we override private methods?

**Answer:**
- **Static methods:** Cannot be overridden, but can be hidden (method hiding). The method called depends on the reference type, not the object type.
- **Private methods:** Cannot be overridden as they are not visible to subclasses.
- *Example:*
  ```java
  class A { static void m() {} }
  class B extends A { static void m() {} } // Hides A.m(), doesn't override
  ```

---

## 7. What is the difference between abstract class and interface?

**Answer:**
| Feature                | Abstract Class                | Interface                      |
|------------------------|-------------------------------|-------------------------------|
| Methods                | Abstract & concrete           | Abstract (default/static from Java 8) |
| Variables              | Any type                      | public static final only       |
| Constructors           | Yes                           | No                            |
| Multiple inheritance   | No (single class)             | Yes (multiple interfaces)      |
| Access Modifiers       | Any                           | public only (for methods/fields) |

---

## 8. Can we have overloaded methods with different return types?

**Answer:**
- No, method overloading is not possible by just changing the return type. The parameter list must be different.
- *Example:*
  ```java
  int m() {}
  double m() {} // Error: duplicate method
  int m(int x) {} // OK: different parameters
  ```

---

## 9. What is the difference between method overloading and overriding?

**Answer:**
- **Overloading:** Same method name, different parameter list, same or different return type, within the same class or subclass.
- **Overriding:** Same method signature (name + parameters), in subclass, return type must be same (or covariant), used for runtime polymorphism.

---

## 10. Can a class extend multiple classes or implement multiple interfaces?

**Answer:**
- **Multiple inheritance (classes):** Not allowed in Java (to avoid diamond problem).
- **Multiple interfaces:** Allowed. A class can implement multiple interfaces.
  - *Example:*
    ```java
    class MyClass implements Interface1, Interface2 {}
    ```

---

## 11. What is the difference between '==' and '.equals()' in Java?

**Answer:**
- `==` compares references (memory addresses) for objects, or values for primitives.
- `.equals()` compares the actual content (if overridden, e.g., in `String`).
  - *Example:*
    ```java
    String a = new String("abc");
    String b = new String("abc");
    a == b; // false
    a.equals(b); // true
    ```

---

## 12. Can you explain the difference between composition, aggregation, and association?

**Answer:**
- **Association:** General relationship between two classes (e.g., Teacher and Student).
- **Aggregation:** Weak form of association; child can exist independently of parent (e.g., Department and Teacher).
- **Composition:** Strong form; child cannot exist without parent (e.g., House and Room).

---

## 13. What is the use of 'super' and 'this' keywords?

**Answer:**
- `this`: Refers to the current object instance. Used to access members, call constructors, etc.
- `super`: Refers to the immediate parent class object. Used to access parent members, call parent constructor.

---

## 14. Can you explain the SOLID principles?

**Answer:**
- **S**ingle Responsibility Principle: A class should have only one reason to change.
- **O**pen/Closed Principle: Software entities should be open for extension, closed for modification.
- **L**iskov Substitution Principle: Subtypes must be substitutable for their base types.
- **I**nterface Segregation Principle: Many client-specific interfaces are better than one general-purpose interface.
- **D**ependency Inversion Principle: Depend on abstractions, not concretions.

---

## 15. Can you explain the difference between 'final', 'finally', and 'finalize'?

**Answer:**
- `final`: Keyword to mark variable (constant), method (cannot override), or class (cannot extend).
- `finally`: Block in exception handling that always executes.
- `finalize()`: Method called by GC before object is destroyed (deprecated in Java 9+).

---

## 16. What is a marker interface? Give examples.

**Answer:**
- An interface with no methods or fields. Used to mark a class for special behavior by JVM or frameworks.
- *Examples:* `Serializable`, `Cloneable`, `Remote`.

---

## 17. Can an interface extend another interface? Can it extend a class?

**Answer:**
- An interface can extend one or more interfaces.
- An interface cannot extend a class.
  - *Example:*
    ```java
    interface A {}
    interface B extends A {}
    ```

---

## 18. Can a class be both abstract and final?

**Answer:**
- No. `abstract` means the class must be subclassed; `final` means it cannot be subclassed. They are mutually exclusive.

---

## 19. What is a default method in an interface?

**Answer:**
- Introduced in Java 8. Allows interfaces to have methods with implementation using the `default` keyword.
- *Example:*
  ```java
  interface I {
    default void show() { System.out.println("default"); }
  }
  ```

---

## 20. Can you explain the difference between checked and unchecked exceptions?

**Answer:**
- **Checked exceptions:** Checked at compile time. Must be handled or declared (e.g., `IOException`).
- **Unchecked exceptions:** Subclasses of `RuntimeException`. Not checked at compile time (e.g., `NullPointerException`).

---

## 21. What happens if you try to cast a parent object to a child type?

**Answer:**
- If the parent reference actually points to a child object, the cast is valid.
- If the parent reference points to a parent object, a `ClassCastException` is thrown at runtime.
- *Example:*
  ```java
  class Parent {}
  class Child extends Parent {}
  Parent p = new Child();
  Child c = (Child) p; // OK
  Parent p2 = new Parent();
  Child c2 = (Child) p2; // Throws ClassCastException
  ```

---

## 22. Can a constructor be overridden?

**Answer:**
- No, constructors cannot be overridden. They are not inherited by subclasses. However, a subclass can call a superclass constructor using `super()`.

---

## 23. What is the difference between shallow copy and deep copy?

**Answer:**
- **Shallow copy:** Copies object references, not the actual objects. Changes to referenced objects affect both copies.
- **Deep copy:** Copies the actual objects recursively. Changes to one object do not affect the other.
- *Example:*
  ```java
  List<String> a = new ArrayList<>();
  List<String> b = new ArrayList<>(a); // Shallow copy of list elements
  // For deep copy, clone or copy each element as well
  ```

---

## 24. What is the diamond problem? How does Java handle it?

**Answer:**
- The diamond problem occurs in multiple inheritance when two parent classes have a method with the same signature, and a child class inherits from both.
- Java avoids this by not allowing multiple inheritance of classes. For interfaces, if two interfaces have the same default method, the implementing class must override it.
- *Example:*
  ```java
  interface A { default void m() { System.out.println("A"); } }
  interface B { default void m() { System.out.println("B"); } }
  class C implements A, B {
    public void m() { A.super.m(); } // Must resolve ambiguity
  }
  ```

---

## 25. What is the difference between HashMap and Hashtable?

**Answer:**
- **HashMap:**
  - Not synchronized (not thread-safe)
  - Allows one null key and multiple null values
  - Faster
- **Hashtable:**
  - Synchronized (thread-safe)
  - No null keys or values allowed
  - Slower

---

## 26. What is fail-fast and fail-safe in Java collections?

**Answer:**
- **Fail-fast:** Iterators throw `ConcurrentModificationException` if the collection is modified while iterating (e.g., `ArrayList`, `HashMap`).
- **Fail-safe:** Iterators work on a clone of the collection, so no exception is thrown (e.g., `CopyOnWriteArrayList`, `ConcurrentHashMap`).

---

## 27. What is the difference between ArrayList and LinkedList?

**Answer:**
- **ArrayList:**
  - Backed by a dynamic array
  - Fast random access (O(1)), slow insert/delete (O(n))
- **LinkedList:**
  - Doubly-linked list
  - Slow random access (O(n)), fast insert/delete at ends (O(1))

---

## 28. What is the difference between Comparable and Comparator?

**Answer:**
- **Comparable:**
  - Interface for natural ordering
  - Implemented by the class itself (`compareTo` method)
- **Comparator:**
  - Separate object for custom ordering
  - Can define multiple comparators for different sort orders (`compare` method)
- *Example:*
  ```java
  class Person implements Comparable<Person> {
    public int compareTo(Person p) { return this.age - p.age; }
  }
  Comparator<Person> byName = (a, b) -> a.name.compareTo(b.name);
  ```

---

## 29. What is the use of the volatile keyword?

**Answer:**
- Ensures that changes to a variable are immediately visible to all threads. Prevents caching of the variable in threads. Used for flags or status variables in multithreaded code.

---

## 30. What is the difference between synchronized method and synchronized block?

**Answer:**
- **Synchronized method:** Locks the entire method; only one thread can execute it at a time.
- **Synchronized block:** Locks only a specific section of code or object, allowing finer control and potentially better performance.
- *Example:*
  ```java
  synchronized void m() { ... } // method
  void m() { synchronized(this) { ... } } // block
  ```

---

## 31. What is deadlock? How can you prevent it?

**Answer:**
- **Deadlock:** Two or more threads are blocked forever, each waiting for the other to release a lock.
- **Prevention:**
  - Lock ordering
  - Using tryLock with timeout
  - Avoiding nested locks
  - Using higher-level concurrency utilities

---

## 32. What is the difference between ExecutorService and Thread?

**Answer:**
- **Thread:** Represents a single thread of execution. Manual management.
- **ExecutorService:** High-level API for managing thread pools, scheduling, and task execution. Preferred for scalable, maintainable concurrent code.
- *Example:*
  ```java
  ExecutorService ex = Executors.newFixedThreadPool(2);
  ex.submit(() -> { ... });
  ex.shutdown();
  ```

---

## 33. What is a lambda expression? Give an example.

**Answer:**
- A concise way to represent an anonymous function (functional interface implementation). Introduced in Java 8.
- *Example:*
  ```java
  Runnable r = () -> System.out.println("Hello");
  List<String> list = Arrays.asList("a", "b");
  list.forEach(s -> System.out.println(s));
  ```

---

## 34. What is a stream in Java 8? How is it different from a collection?

**Answer:**
- **Stream:** Sequence of elements supporting sequential and parallel aggregate operations. Does not store data, is immutable, and can be processed in a functional style.
- **Collection:** Stores data, can be modified.
- *Example:*
  ```java
  List<String> list = Arrays.asList("a", "b", "c");
  list.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
  ```

---

## 35. Scenario: How would you design a thread-safe singleton in Java?

**Answer:**
- Use `enum` (best way), or double-checked locking with `volatile`:
  ```java
  public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
      if (instance == null) {
        synchronized (Singleton.class) {
          if (instance == null) {
            instance = new Singleton();
          }
        }
      }
      return instance;
    }
  }
  // Or:
  public enum SingletonEnum { INSTANCE; }
  ```

---

## 36. Scenario: How would you find and fix a memory leak in a Java application?

**Answer:**
- Use profiling tools (e.g., VisualVM, YourKit, JProfiler) to analyze heap dumps and memory usage.
- Look for objects that are not being garbage collected (e.g., static collections, listeners not removed).
- Fix by releasing references, using weak references, or correcting code logic.

---

## 37. Scenario: How would you handle concurrent modification of a shared list in a multi-threaded test automation framework?

**Answer:**
- Use thread-safe collections (e.g., `CopyOnWriteArrayList`, `Collections.synchronizedList`).
- Use proper synchronization or concurrent data structures from `java.util.concurrent`.
- Avoid sharing mutable state between threads if possible.

---

## 38. Scenario: How would you design a retry mechanism for a flaky API call in Java?

**Answer:**
- Use a loop with a maximum retry count and delay between retries.
- Optionally use libraries like `resilience4j` or `Guava Retryer` for advanced policies (exponential backoff, circuit breaker).
- *Example:*
  ```java
  int retries = 3;
  while (retries-- > 0) {
    try {
      callApi();
      break;
    } catch (Exception e) {
      if (retries == 0) throw e;
      Thread.sleep(1000);
    }
  }
  ```

---

## 39. Scenario: How would you ensure immutability of a class?

**Answer:**
- Make the class `final`.
- Make all fields `private final`.
- No setters; only getters.
- Initialize all fields in the constructor.
- If fields are mutable objects, return copies in getters.
- *Example:*
  ```java
  public final class Person {
    private final String name;
    public Person(String name) { this.name = name; }
    public String getName() { return name; }
  }
  ```

---

## 40. Scenario: How would you debug a flaky Selenium test that fails intermittently?

**Answer:**
- Analyze logs and screenshots for failure patterns.
- Check for timing issues (add explicit waits, avoid Thread.sleep).
- Ensure environment stability (network, server, browser versions).
- Isolate the test (run independently).
- Use retry logic for known flaky steps.
- Collaborate with developers if needed.

---

*Let me know if you want more on design patterns, Java 8+ features, or real-world SDET/managerial scenarios!*
