# Module 1 & 2: Viva Questions

## Module 1: Design Patterns - Viva Questions

### Easy Level

#### Q1: What is a Design Pattern?
**Answer:** Design patterns are reusable solutions to common problems in software design. They are templates that can be customized to solve specific design problems, representing best practices that can speed up development and improve code quality.

#### Q2: What is the Singleton Pattern?
**Answer:** The Singleton pattern ensures that a class has only one instance and provides a global point of access to it. It restricts instantiation through a private constructor and provides a static method to access the single instance.

#### Q3: How do you implement a Singleton?
**Answer:** 
- Make the constructor private
- Create a static instance variable
- Provide a static getInstance() method
- Check if instance is null; if so, create it; otherwise return existing instance

#### Q4: What is the Factory Method Pattern?
**Answer:** The Factory Method pattern is a creational pattern that provides an interface for creating objects without specifying their concrete classes. It lets subclasses decide which class to instantiate.

#### Q5: What is the difference between Singleton and Factory Method?
**Answer:** 
- Singleton ensures only one instance of a class
- Factory Method is about object creation without knowing concrete classes
- Singleton is about instance control; Factory Method is about decoupling object creation

### Medium Level

#### Q6: Why is the basic Singleton pattern not thread-safe?
**Answer:** The basic implementation uses a check-then-act pattern:
```java
if (instance == null) {
    instance = new Logger();
}
```
Between the null check and instantiation, another thread could also pass the check, creating multiple instances. This is a classic race condition.

#### Q7: How do you make Singleton thread-safe?
**Answer:** Multiple approaches:
1. **Eager Initialization** - Create instance at class loading
2. **Synchronized Method** - Use synchronized keyword (performance overhead)
3. **Double-Checked Locking** - Check before and after synchronization
4. **Bill Pugh Singleton** - Use static inner class (Java class loader synchronization)
5. **Enum Singleton** - Use enum (recommended, handles serialization)

#### Q8: What are the disadvantages of Singleton?
**Answer:**
- Difficult to test (hard to mock)
- Global state hides dependencies
- Makes code harder to reason about
- Hides poor design decisions
- Can make code coupling tight

#### Q9: Explain the Factory Method pattern with an example.
**Answer:** In our Document factory example:
- We have Document interface
- Multiple implementations (WordDocument, PdfDocument, ExcelDocument)
- DocumentFactory creates appropriate type based on input
- Client doesn't know concrete class, only interface
- Adding new document types doesn't require changing factory client code

#### Q10: What is the Open/Closed Principle?
**Answer:** The Open/Closed Principle states that software should be open for extension but closed for modification. Design patterns like Factory Method enable this by allowing new types to be added without changing existing code.

### Hard Level

#### Q11: What's the difference between Factory Method and Abstract Factory?
**Answer:**

| Aspect | Factory Method | Abstract Factory |
|--------|---|---|
| Creates | Single product | Family of related products |
| Intent | Object creation | Family of objects |
| Implementations | One factory class | Multiple factory classes |
| Use Case | Single hierarchy | Related product families |
| Example | Document factory | UI component factories for different OS |

#### Q12: Explain Bill Pugh Singleton vs Enum Singleton
**Answer:**

**Bill Pugh:**
```java
public class Singleton {
    private Singleton() {}
    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
```
- Thread-safe through class loader synchronization
- Lazy initialization
- Reflection can still break it

**Enum:**
```java
public enum Singleton {
    INSTANCE;
    public void doSomething() { }
}
```
- Simplest, most thread-safe
- Handles serialization automatically
- Reflection-proof
- Recommended in modern Java

#### Q13: When would you use Singleton vs Factory Method?
**Answer:**
- **Singleton:** When you need exactly one instance of a resource (logger, config)
- **Factory Method:** When you need flexible object creation and decoupling
- They can be combined: Factory can be a singleton that creates various objects

#### Q14: How does the Factory Method pattern support SOLID principles?
**Answer:**
- **SRP:** Factory handles object creation (single responsibility)
- **OCP:** Add new document types without modifying factory client code
- **LSP:** All document types are substitutable for Document interface
- **ISP:** Document interface exposes only necessary methods
- **DIP:** Depend on Document abstraction, not concrete classes

#### Q15: What are the consequences of breaking the Singleton pattern?
**Answer:**
- Multiple instances can be created via reflection
- Serialization/deserialization can create new instances
- Cloning can create new instances
- In multithreaded environments, synchronization problems can occur
- Subclassing can break the pattern

---

## Module 2: Data Structures & Algorithms - Viva Questions

### Easy Level

#### Q1: What is Linear Search?
**Answer:** Linear search sequentially checks each element in an array until the target is found. It compares the target with each element from the beginning until a match is found or the end is reached.

#### Q2: What is the time complexity of Linear Search?
**Answer:**
- Best Case: O(1) - element found at first position
- Average Case: O(n) - element in middle
- Worst Case: O(n) - element at end or not found

#### Q3: What is Binary Search?
**Answer:** Binary search divides the search space in half with each iteration by comparing the target with the middle element. It works only on sorted arrays and significantly reduces the search space.

#### Q4: What is the time complexity of Binary Search?
**Answer:**
- Best Case: O(1) - element at middle
- Average Case: O(log n)
- Worst Case: O(log n)

#### Q5: What is recursion?
**Answer:** Recursion is a programming technique where a function calls itself to solve smaller sub-problems of the same type. Every recursive function needs a base case to terminate and a recursive case that makes progress toward the base case.

### Medium Level

#### Q6: When should you use Linear Search vs Binary Search?
**Answer:**

| Factor | Linear | Binary |
|--------|--------|--------|
| Data sorted? | No need | Must be sorted |
| Dataset size | Small | Large |
| Search frequency | Occasional | Frequent |
| Pre-processing | None | Need to sort |
| Implementation | Simple | Complex |

#### Q7: What are the prerequisites for Binary Search?
**Answer:**
- Array must be sorted
- Array elements must be comparable
- No duplicates (optional, but affects expected output)
- Random access capability

#### Q8: Explain the difference between Iterative and Recursive Binary Search.
**Answer:**

**Iterative:**
```java
while (left <= right) {
    int mid = left + (right - left) / 2;
    // comparison logic
}
```
- Space: O(1)
- No stack overhead
- Easier to debug

**Recursive:**
```java
if (left > right) return -1;
int mid = left + (right - left) / 2;
return binarySearchRecursive(...);
```
- Space: O(log n) for call stack
- More elegant
- Stack overflow possible

#### Q9: What are the components of recursion?
**Answer:**
1. **Base Case** - Condition that terminates recursion
2. **Recursive Case** - Function calling itself
3. **Progress** - Each call moves toward base case
Without any of these, recursion fails or causes infinite loops

#### Q10: What is the problem with Naive Fibonacci recursion?
**Answer:**
```java
fib(n) = fib(n-1) + fib(n-2)
```
- Time Complexity: O(2^n) - Exponential!
- Many sub-problems calculated multiple times
- fib(40): Takes ~30 seconds
- fib(50): Practically unusable
Example: fib(5) calls:
- fib(4) and fib(3)
- fib(3) and fib(2) and fib(2) and fib(1)
- Notice fib(3), fib(2) calculated multiple times!

### Hard Level

#### Q11: What is memoization and how does it solve recursion problems?
**Answer:** Memoization stores results of expensive function calls and returns cached result when same inputs occur again.

```java
Map<Integer, Integer> memo = new HashMap<>();

public int fib(int n) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    
    int result = fib(n-1) + fib(n-2);
    memo.put(n, result);
    return result;
}
```

**Benefits:**
- Reduces time from O(2^n) to O(n)
- Each value calculated only once
- Remaining calls hit cache in O(1)

#### Q12: Analyze the compound interest recursion used in Financial Forecasting.
**Answer:**

**Problem:** FV = PV × (1 + r)^n

**Recursive Formula:**
```
FV(0) = PV
FV(n) = FV(n-1) × (1 + r)
```

**Time Complexity Analysis:**
- Naive Recursive: O(n) - Linear recursion (single call per level)
- Unlike Fibonacci (2^n), this has only one recursive call
- Each level reduces n by 1
- Total depth: n levels

**Space Complexity:**
- O(n) for call stack depth

**Better Solutions:**
- Iterative: O(n) time, O(1) space
- Mathematical: O(1) using Math.pow()

#### Q13: How does compound interest demonstrate the power of algorithms?
**Answer:**
```
Years: 30
Interest: 10% annually

Naive recursion: 30 levels × 1 operation = fast but conceptually shows recursion
Iterative: 30 iterations = same complexity, cleaner
Mathematical: FV = PV × (1.1)^30 = instant calculation using optimized exponentiation

Why it matters:
- Shows algorithm choice impacts performance
- For large n, mathematical approach is best
- Demonstrates different problem-solving approaches
- Real-world financial calculations depend on this
```

#### Q14: Compare different approaches to solve the same problem.
**Answer:**

For calculating FV = PV × (1 + r)^n:

| Approach | Time | Space | Code |
|----------|------|-------|------|
| Naive Recursive | O(n) | O(n) | Simple, elegant |
| Memo Recursive | O(n) | O(n) | Good learning |
| Iterative | O(n) | O(1) | Production quality |
| Mathematical | O(1) | O(1) | Best performance |

**Selection Criteria:**
- Learning: Use naive or memoization
- Production: Use mathematical or iterative
- Performance: Mathematical wins
- Memory: Iterative wins

#### Q15: What is the Rule of 72 and how is it derived?
**Answer:**

**Rule of 72:**
```
Years to double ≈ 72 / (annual_rate × 100)

Example: 8% return
Years ≈ 72 / 8 = 9 years
```

**Derivation:**
```
FV = 2 × PV (doubling)
PV × (1 + r)^n = 2 × PV
(1 + r)^n = 2
n × ln(1 + r) = ln(2)
n = ln(2) / ln(1 + r)

For small r: ln(1 + r) ≈ r
So: n ≈ 0.693 / r

For r as percentage: n ≈ 69.3 / (rate%)
Approximately 72 for easier mental math
```

**Accuracy:**
- At 5%: Rule of 72 gives 14.4 years, exact is 14.2 (1.4% error)
- At 10%: Rule of 72 gives 7.2 years, exact is 7.27 (1% error)
- Works best for rates between 5-10%

### Scenario-based Questions

#### Q16: You have 1 million products. Customer searches for products in price range ₹1000-₹5000. Which algorithm and why?
**Answer:**
- **Algorithm:** Linear search (modified for range)
- **Why:** 
  - Products sorted by ID, not price
  - Need to find all products in range
  - Binary search for single value ineffective for range
  - Linear scan with filtering necessary
  - If products were pre-sorted by price, could use binary search for boundaries
  
**Performance:**
- Linear: ~500,000 comparisons
- With indexing: Much faster

#### Q17: Your financial forecasting app needs to calculate future value for investment of ₹1 million at 10% for 50 years. Which approach?
**Answer:**
- **Choose:** Mathematical (FV = PV × Math.pow(1 + r, n))
- **Why:**
  - O(1) time complexity
  - No stack overflow risk
  - Instant calculation
  - Production-ready
  
**Comparison:**
- Naive recursive: Slow (50 recursive calls)
- Iterative: 50 iterations, O(n)
- Mathematical: Instant, O(1)

#### Q18: A recursive function works for small inputs but fails for large ones (stack overflow). What's wrong?
**Answer:**
**Problem:** Call stack too deep
- Each recursive call adds to stack
- Default stack size limited (~1MB)
- Deep recursion exhausts stack

**Solutions:**
1. Convert to iterative (best)
2. Increase stack size (risky)
3. Use tail recursion optimization (limited in Java)
4. Use memoization to reduce call depth
5. Use trampolining techniques

#### Q19: Between two search algorithms, iterative binary search and recursive binary search, which would you choose for production code?
**Answer:**
**Choose: Iterative Binary Search**

**Reasons:**
- Space Complexity: O(1) vs O(log n)
- No stack overflow risk
- Easier to debug
- Better performance
- Industry standard

**Recursive is good for:**
- Learning recursion concepts
- Code elegance/elegance (minor)
- Problems naturally recursive (trees, graphs)

#### Q20: Explain how e-commerce companies use these algorithms in practice.
**Answer:**
**Linear Search:**
- Small category filters
- Recent products (unsorted)
- Brand/model specific searches

**Binary Search:**
- Main product catalog search
- Sorted inventory
- Quick lookups by ID or SKU

**Others (not covered but important):**
- **Hash Tables:** Fast product ID lookup
- **Inverted Index:** Full-text search
- **Tries:** Auto-complete suggestions
- **Bloom Filters:** Duplicate detection
- **B-Trees:** Database indexing

**Real Example:**
```
User searches for "laptop under ₹50,000"
1. Hash table lookup for "laptop" category
2. Binary search on sorted prices
3. Return filtered results
4. Rank by relevance (ML model)
5. Show paginated results
```

---

## Expected Answers Criteria

### For Design Pattern Questions:
- ✓ Explain the pattern clearly
- ✓ Provide practical example
- ✓ Mention when to use/not use
- ✓ Discuss advantages and disadvantages
- ✓ Relate to SOLID principles

### For Algorithm Questions:
- ✓ State time and space complexity
- ✓ Explain algorithm step-by-step
- ✓ Provide comparison with alternatives
- ✓ Mention prerequisites/assumptions
- ✓ Discuss real-world applications

### For Recursion Questions:
- ✓ Identify base case
- ✓ Explain recursive case
- ✓ Analyze complexity
- ✓ Compare with iterative approach
- ✓ Mention memoization if applicable

## Additional Resources for Practice
- Implement variations mentioned in questions
- Code all algorithms by hand
- Test with different inputs
- Analyze actual performance
- Design interview prep books
