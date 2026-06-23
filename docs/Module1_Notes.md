# Module 1: Design Patterns - Comprehensive Study Notes

## Overview
Design Patterns are reusable solutions to common problems that occur in software design. They represent best practices and can speed up development by providing tested, proven development paradigms.

## What are Design Patterns?
Design patterns are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code.

### Classification of Design Patterns

#### 1. Creational Patterns
Creational patterns deal with object creation mechanisms.

**Patterns Covered:**
- **Singleton** - Ensures single instance
- **Factory Method** - Creates objects without specifying exact classes
- **Abstract Factory** - Creates families of related objects
- **Builder** - Constructs complex objects step by step
- **Prototype** - Clones existing objects

#### 2. Structural Patterns
Structural patterns deal with object composition and relationships between entities.

**Common Patterns:**
- **Adapter** - Makes incompatible interfaces compatible
- **Bridge** - Decouples abstraction from implementation
- **Composite** - Composes objects into tree structures
- **Decorator** - Adds behavior to objects dynamically
- **Facade** - Provides unified interface to complex subsystems
- **Proxy** - Controls access to another object

#### 3. Behavioral Patterns
Behavioral patterns deal with object collaboration and responsibility distribution.

**Common Patterns:**
- **Command** - Encapsulates request as object
- **Iterator** - Accesses elements sequentially
- **Observer** - Notifies multiple objects of state changes
- **State** - Alters behavior when state changes
- **Strategy** - Defines family of algorithms
- **Template Method** - Defines algorithm skeleton

## Exercise 1: Singleton Pattern

### Definition
The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.

### Problem Statement
When you need exactly one instance of a class throughout the application:
- Logger for application-wide logging
- Database connection pool
- Configuration manager
- Thread pool executor

### Solution
Create a class with:
1. Private constructor (prevent instantiation)
2. Static instance variable
3. Static getInstance() method

### Implementation Approaches

#### Approach 1: Lazy Initialization (Discussed)
```java
public class Logger {
    private static Logger instance;
    
    private Logger() { }
    
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
```
**Pros:** Memory efficient
**Cons:** Not thread-safe

#### Approach 2: Eager Initialization
```java
public class Logger {
    private static final Logger instance = new Logger();
    
    private Logger() { }
    
    public static Logger getInstance() {
        return instance;
    }
}
```
**Pros:** Thread-safe, simple
**Cons:** Instance created even if never used

#### Approach 3: Thread-Safe Lazy Initialization
```java
public static synchronized Logger getInstance() {
    if (instance == null) {
        instance = new Logger();
    }
    return instance;
}
```
**Pros:** Thread-safe, lazy
**Cons:** Performance overhead from synchronization

#### Approach 4: Bill Pugh Singleton (Best Practice)
```java
public class Logger {
    private Logger() { }
    
    private static class LoggerHolder {
        private static final Logger instance = new Logger();
    }
    
    public static Logger getInstance() {
        return LoggerHolder.instance;
    }
}
```
**Pros:** Thread-safe, lazy, efficient
**Cons:** Slightly complex

#### Approach 5: Enum Singleton (Recommended)
```java
public enum Logger {
    INSTANCE;
    
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

// Usage
Logger.INSTANCE.log("Hello");
```
**Pros:** Thread-safe, serialization-safe, simplest
**Cons:** Different style from class-based

### Advantages of Singleton
✓ Single instance ensures consistency
✓ Global access point
✓ Memory efficient
✓ Lazy initialization possible
✓ Useful for shared resources

### Disadvantages of Singleton
✗ Testing becomes difficult
✗ Hidden dependencies
✗ Global state hard to reason about
✗ Can mask poor design

### When to Use
- Logging (application-wide logger)
- Configuration managers
- Database connection pools
- Thread pools
- Caches
- Session managers

## Exercise 2: Factory Method Pattern

### Definition
Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

### Problem Statement
Creating objects tightly couples code to concrete classes. We need a way to create objects without knowing their exact types.

**Example:** Creating different document types (Word, PDF, Excel) without client code knowing specifics.

### Solution
Use a factory class/method to encapsulate object creation logic.

```
Client → Factory → Product
                  ├── WordDocument
                  ├── PdfDocument
                  └── ExcelDocument
```

### Components

#### 1. Product Interface
```java
public interface Document {
    void open();
    void generateContent();
    void save();
    void close();
}
```

#### 2. Concrete Products
- WordDocument implements Document
- PdfDocument implements Document
- ExcelDocument implements Document

#### 3. Factory
```java
public class DocumentFactory {
    public static Document createDocument(String type) {
        switch(type.toUpperCase()) {
            case "WORD": return new WordDocument();
            case "PDF": return new PdfDocument();
            case "EXCEL": return new ExcelDocument();
            default: throw new IllegalArgumentException("Unknown type");
        }
    }
}
```

#### 4. Client Code
```java
Document doc = DocumentFactory.createDocument("WORD");
doc.open();
doc.generateContent();
doc.save();
doc.close();
```

### Advantages
✓ Decouples client from concrete classes
✓ Easy to add new types (Open/Closed Principle)
✓ Centralized object creation logic
✓ Easier to maintain and modify

### Disadvantages
✗ Adds complexity
✗ May be overkill for simple cases
✗ Additional indirection

### Factory Method vs. Abstract Factory

| Factor | Factory Method | Abstract Factory |
|--------|---|---|
| Creates | Single object | Family of objects |
| Classes | One factory | Multiple factories |
| Use Case | Single product type | Related product families |
| Complexity | Simple | Complex |

### Real-world Examples
- **Spring Framework** - BeanFactory, ObjectFactory
- **JDBC** - DriverManager creates connections
- **Collections** - List.of(), Set.of(), Map.of()
- **Thread pools** - Executors.newFixedThreadPool()

## Key Design Principles

### SOLID Principles (Relevant to Design Patterns)

#### Single Responsibility Principle (SRP)
Each class should have only one reason to change.
- Logger only logs
- Factory only creates
- Document only manages document operations

#### Open/Closed Principle (OCP)
Software should be open for extension, closed for modification.
- Add new document types without changing existing code
- Add new Singleton variations without breaking Logger

#### Liskov Substitution Principle (LSP)
Subtypes must be substitutable for their base types.
- Any Document implementation can replace Document interface
- Code using Document interface works with any implementation

#### Interface Segregation Principle (ISP)
Clients should depend on specific interfaces, not general ones.
- Document interface only exposes needed methods
- Clients don't depend on unnecessary methods

#### Dependency Inversion Principle (DIP)
Depend on abstractions, not concrete implementations.
- Factory returns Document interface (abstraction)
- Client codes to Document, not WordDocument

## Best Practices

### 1. Choose Right Pattern
- Understand problem before applying pattern
- Don't over-engineer simple solutions
- Consider consequences

### 2. Combine Patterns
- Patterns often work together
- Factory Method often used with Strategy
- Singleton often holds shared resources

### 3. Keep It Simple
- Start simple, add complexity if needed
- Over-use of patterns makes code harder to understand
- "If it's not broken, don't fix it"

### 4. Document Why
- Comment why pattern is used
- Explain alternatives considered
- Help future developers understand

## Common Mistakes

### Mistake 1: Over-Engineering
**Wrong:** Using Factory for creating simple objects
**Right:** Use Factory only when object creation is complex or varies

### Mistake 2: Ignoring Thread Safety
**Wrong:** Non-thread-safe Singleton in multi-threaded app
**Right:** Use synchronized, eager, or enum approach

### Mistake 3: Hidden Dependencies
**Wrong:** Factory creates global state invisibly
**Right:** Make dependencies explicit through parameters

### Mistake 4: Breaking Patterns
**Wrong:** Modifying Singleton after creation
**Right:** Keep patterns pure, don't add exceptions

## Summary

| Pattern | Purpose | Key Benefit |
|---------|---------|------------|
| Singleton | Single instance | Consistency, resource sharing |
| Factory Method | Object creation | Decoupling, flexibility |

## Recommended Further Reading
- "Design Patterns: Elements of Reusable Object-Oriented Software" by Gang of Four
- "Head First Design Patterns" - Easy to understand explanations
- Official documentation for frameworks using these patterns
