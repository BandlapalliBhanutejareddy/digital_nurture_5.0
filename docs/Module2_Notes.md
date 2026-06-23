# Module 2: Data Structures & Algorithms - Comprehensive Study Notes

## Overview
Data Structures and Algorithms form the foundation of efficient programming. This module covers fundamental algorithms (searching, sorting) and recursion with practical applications.

## Part 1: Search Algorithms

### Why Search Matters
Searching is one of the most frequent operations:
- Finding specific records in database
- Auto-complete in search engines
- Finding minimum/maximum values
- Duplicate detection

### 1. Linear Search

#### Algorithm Concept
Check each element sequentially until target is found.

```
Algorithm LinearSearch(array, target):
    for i = 0 to array.length - 1:
        if array[i] == target:
            return i (found)
    return -1 (not found)
```

#### Step-by-step Example
```
Array: [10, 20, 30, 40, 50]
Target: 30

Step 1: Check 10 ≠ 30
Step 2: Check 20 ≠ 30
Step 3: Check 30 = 30 → Found at index 2
```

#### Complexity Analysis
- **Time Complexity:**
  - Best Case: O(1) - Element at first position
  - Average Case: O(n) - Approximately middle position
  - Worst Case: O(n) - Element at last position or not found

- **Space Complexity:** O(1) - No extra space

#### Trade-offs

| Aspect | Linear Search |
|--------|---|
| Unsorted data | ✓ Works |
| Large dataset | ✗ Slow |
| Pre-processing | ✗ Not needed |
| Implementation | ✓ Simple |

#### When to Use
- Small datasets (< 1000 elements)
- Data is unsorted
- Few searches needed
- Simplicity is priority

#### Variations
- **Sentinel Linear Search** - Add sentinel at end to save comparison
- **Linear Search with Early Exit** - Used in our implementation
- **Recursive Linear Search** - Call recursively on subarray

### 2. Binary Search

#### Algorithm Concept
Divide search space in half with each iteration by comparing with middle element.

```
Algorithm BinarySearch(sortedArray, target):
    left = 0
    right = sortedArray.length - 1
    
    while left <= right:
        mid = (left + right) / 2
        if sortedArray[mid] == target:
            return mid (found)
        else if sortedArray[mid] < target:
            left = mid + 1 (search right half)
        else:
            right = mid - 1 (search left half)
    
    return -1 (not found)
```

#### Step-by-step Example
```
Sorted Array: [10, 20, 30, 40, 50, 60, 70, 80, 90]
Target: 30

Iteration 1: left=0, right=8, mid=4
  Array[4]=50, 50 > 30 → right=3

Iteration 2: left=0, right=3, mid=1
  Array[1]=20, 20 < 30 → left=2

Iteration 3: left=2, right=3, mid=2
  Array[2]=30, 30 == 30 → Found!
```

#### Complexity Analysis
- **Time Complexity:**
  - Best Case: O(1) - Element at middle
  - Average Case: O(log n)
  - Worst Case: O(log n)

- **Space Complexity:**
  - Iterative: O(1) - Constant
  - Recursive: O(log n) - Call stack

#### Logarithmic Growth Impact

| Array Size | Linear (worst) | Binary (worst) |
|------------|---|---|
| 10 | 10 | 4 |
| 100 | 100 | 7 |
| 1,000 | 1,000 | 10 |
| 10,000 | 10,000 | 14 |
| 1,000,000 | 1,000,000 | 20 |
| 1 Billion | 1 Billion | 30 |

#### Key Prerequisite
**Array MUST be sorted!** Binary search fails on unsorted data.

#### Recursive vs Iterative
```java
// Iterative - Better space complexity
public static int binarySearchIterative(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}

// Recursive - More elegant but uses stack
public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
    if (left > right) return -1;
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, right);
    else return binarySearchRecursive(arr, target, left, mid - 1);
}
```

#### When to Use
- Large sorted datasets
- Multiple searches needed
- Performance is critical
- Logarithmic complexity needed

#### Variations
- **Recursive Binary Search** - Use recursion
- **Interpolation Search** - Better for uniform distribution
- **Exponential Search** - Good for unbounded arrays
- **Jump Search** - Alternative for sorted arrays

### 3. Comparison: Linear vs Binary

| Criteria | Linear | Binary |
|----------|--------|--------|
| Requires Sorting | No | Yes |
| Best Case | O(1) | O(1) |
| Average Case | O(n) | O(log n) |
| Worst Case | O(n) | O(log n) |
| Space | O(1) | O(1) iterative, O(log n) recursive |
| Simple Implementation | Yes | No |
| Dataset Size | Small | Large |
| Scalability | Poor | Excellent |

## Part 2: Recursion

### What is Recursion?
Recursion is a programming technique where a function calls itself to solve a problem by breaking it into smaller similar sub-problems.

### Key Components

#### 1. Base Case
The terminating condition that prevents infinite recursion.

```java
if (n == 0) return 1; // Base case
```

#### 2. Recursive Case
The function calling itself with a simpler version of the problem.

```java
return n * factorial(n - 1); // Recursive case
```

#### 3. Progress
Each recursive call must move toward the base case.

```java
// Each call has n-1, getting closer to 0
factorial(5) → factorial(4) → factorial(3) → ... → factorial(0)
```

### Types of Recursion

#### 1. Linear Recursion
Function calls itself at most once.

```java
// Example: Factorial
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

**Characteristics:**
- Single recursive call
- Call stack grows linearly
- Easier to understand

#### 2. Multiple Recursion
Function calls itself multiple times.

```java
// Example: Fibonacci
public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

**Characteristics:**
- Multiple recursive calls
- Call stack grows exponentially
- Often very inefficient

#### 3. Mutual Recursion
Functions call each other.

```java
public static boolean isEven(int n) {
    if (n == 0) return true;
    return isOdd(n - 1);
}

public static boolean isOdd(int n) {
    if (n == 0) return false;
    return isEven(n - 1);
}
```

### Recursion vs Iteration

| Aspect | Recursion | Iteration |
|--------|-----------|-----------|
| Style | Elegant | Direct |
| Performance | Often slower | Usually faster |
| Stack Usage | Uses call stack | Uses loop variable |
| Readability | Can be unclear | Usually clear |
| Debugging | Harder (deep stack) | Easier |
| Memory | Higher (stack depth) | Lower |

### The Recursion Problem: Fibonacci

#### Naive Recursive Fibonacci
```java
public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

**Time Complexity:** O(2^n) - Exponential! Very slow!

**Why so slow?**
```
fib(5) calls fib(4) and fib(3)
fib(4) calls fib(3) and fib(2)
fib(3) calls fib(2) and fib(1)
fib(2) calls fib(1) and fib(0)

Notice: fib(3) is calculated multiple times!
fib(2) is calculated even more times!
```

**Comparison:**
- fib(30): ~26 million calls, 1 second
- fib(35): ~29 million calls, 3 seconds
- fib(40): ~165 million calls, 30+ seconds

#### Memoization (Caching) Solution
```java
static Map<Integer, Integer> memo = new HashMap<>();

public static int fibonacci(int n) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    
    int result = fibonacci(n - 1) + fibonacci(n - 2);
    memo.put(n, result);
    return result;
}
```

**Time Complexity:** O(n) - Linear! Much better!

**How it works:**
- First call: fib(5) calculates
- Stores result in map
- Second call: fib(5) returns from map immediately

**Results:**
- fib(50) with memoization: milliseconds
- fib(100) with memoization: milliseconds

#### Dynamic Programming Solution
```java
public static int fibonacci(int n) {
    if (n <= 1) return n;
    
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    return dp[n];
}
```

**Time Complexity:** O(n) - Linear
**Space Complexity:** O(n) - Array storage

### Recursion in Financial Forecasting

#### Problem
Calculate compound interest: FV = PV × (1 + r)^n

#### Recursive Formula
```
FV(0) = PV (base case)
FV(n) = FV(n-1) × (1 + r) (recursive case)
```

#### Naive Recursive
```java
public static double futureValue(double pv, double r, int n) {
    if (n == 0) return pv;
    return futureValue(pv, r, n - 1) * (1 + r);
}
```

**Time Complexity:** O(n)
**Why?** Only one recursive call per level (linear recursion)

#### With Memoization
```java
Map<String, Double> cache = new HashMap<>();

public static double futureValue(double pv, double r, int n) {
    String key = pv + ":" + r + ":" + n;
    if (cache.containsKey(key)) return cache.get(key);
    
    if (n == 0) return pv;
    double result = futureValue(pv, r, n - 1) * (1 + r);
    cache.put(key, result);
    return result;
}
```

**Improvement:** Same O(n) but avoids redundant calculations if same values queried

#### Iterative (Better)
```java
public static double futureValue(double pv, double r, int n) {
    double fv = pv;
    for (int i = 0; i < n; i++) {
        fv *= (1 + r);
    }
    return fv;
}
```

**Time Complexity:** O(n)
**Space Complexity:** O(1)

#### Mathematical (Best)
```java
public static double futureValue(double pv, double r, int n) {
    return pv * Math.pow(1 + r, n);
}
```

**Time Complexity:** O(1) (assuming Math.pow is optimized)
**Space Complexity:** O(1)

## Part 3: E-commerce Application

### Real-world Search Scenarios

#### Scenario 1: Product by ID
- Usually: Binary search (products indexed by ID)
- Fallback: Linear search (if unsorted)

#### Scenario 2: Price Range Search
- Linear search: Scan and collect all in range
- OR: Binary search to find boundaries, then collect range

#### Scenario 3: Category Search
- Hash table: Map category to products
- Cannot use binary search (not comparable)

#### Scenario 4: Full-text Search
- Specialized: Trie or inverted index
- Very different from simple linear/binary

### Performance in E-commerce

#### Impact of Algorithm Choice
```
1 Million Products:
- Linear Search: ~500,000 comparisons average
- Binary Search: ~20 comparisons

Time Difference:
- Linear: 500ms (at 1 million ops/sec)
- Binary: 0.02ms

User Experience:
- Linear: Noticeable lag
- Binary: Instant
```

#### Why it matters
- User types quickly (auto-complete)
- Needs results in real-time
- Algorithm choice directly impacts UX
- Binary search is non-negotiable for large catalogs

## Summary of Concepts

### Search Algorithms
- Linear: Simple, works on unsorted, O(n)
- Binary: Fast, needs sorted data, O(log n)
- Choose based on data characteristics and frequency of search

### Recursion
- Elegant but can be inefficient
- Base case and recursive case essential
- Memoization fixes exponential problems
- Use when problem has recursive structure

### Financial Forecasting
- Recursion principle: each year builds on previous
- Multiple approaches: recursive, iterative, mathematical
- Choose based on performance needs and code clarity

## Best Practices

### 1. Algorithm Selection
- Understand data characteristics
- Consider search frequency
- Measure performance
- Don't assume—profile!

### 2. Recursion Usage
- Use for naturally recursive problems (tree, graph)
- Avoid for simple loops
- Add memoization if calculating repeatedly
- Consider iterative alternative

### 3. Testing
- Test with small datasets
- Test with large datasets
- Test boundary conditions
- Measure performance

## Recommended Further Reading
- "Introduction to Algorithms" by CLRS
- "Cracking the Coding Interview" - Search, Sort, Recursion sections
- Algorithm textbooks and online courses
