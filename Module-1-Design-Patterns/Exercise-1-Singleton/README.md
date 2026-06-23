
# Exercise-1-Singleton: Logger Implementation

## Overview
This exercise demonstrates the **Singleton Design Pattern** by implementing a thread-safe Logger singleton that ensures only one instance exists throughout the application lifecycle.

## Objective
To understand and implement the Singleton pattern, a creational design pattern that restricts the instantiation of a class to a single object.

## Files
- `Logger.java` - Singleton Logger implementation
- `SingletonTest.java` - Test class demonstrating singleton behavior

## Key Concepts

### Singleton Pattern
The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.

**Characteristics:**
- Private constructor to prevent instantiation
- Static instance variable
- Static method to access the instance
- Lazy initialization (instance created on first use)

### Implementation Details
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

## Time Complexity Analysis
- **getInstance()**: O(1) - Constant time lookup
- **log()**: O(n) - where n is length of log message (for printing)

## Space Complexity
O(1) - Constant space for single instance

## Advantages
- Ensures single instance of logger across application
- Global access point for logging
- Memory efficient for shared resources
- Simple to implement and use

## Disadvantages
- Can make testing difficult (hard to mock)
- Not thread-safe in basic implementation
- Global state can make code harder to reason about

## Thread Safety Note
The current implementation is **NOT thread-safe**. For production use, consider:
- Synchronized getInstance() method
- Eager initialization
- Bill Pugh Singleton (class loader synchronization)
- Enum Singleton (best practice in Java)

## Expected Output
```
Logger Instance Created
Application Started
Only One Instance Exists
```

## Variations
1. **Thread-safe Singleton** - Using synchronized keyword
2. **Lazy Initialization** - Current implementation
3. **Eager Initialization** - Instance created at class loading
4. **Enum Singleton** - Using enum for automatic singleton
5. **Bill Pugh Singleton** - Using inner static helper class

## Usage
```java
Logger logger = Logger.getInstance();
logger.log("Application started");
```

## Real-world Applications
- Database connection pool
- Logger implementations
- Configuration managers
- Thread pools
- Cache management
