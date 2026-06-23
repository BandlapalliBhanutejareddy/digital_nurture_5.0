# Exercise-7-FinancialForecasting: Recursive Financial Calculations

## Overview
This exercise demonstrates recursion through financial forecasting, calculating compound interest and investment growth using multiple recursive approaches with complexity analysis.

## Objective
To understand recursive problem-solving, different recursion strategies (naive, memoization, iterative), and their performance implications in financial calculations.

## Files
- `FinancialForecast.java` - Core financial forecasting implementations
- `FinancialForecastTest.java` - Test class with real-world scenarios

## Key Concepts

### Recursion Explained
Recursion is a technique where a function calls itself to solve smaller sub-problems.

**Components of Recursion:**
1. **Base Case** - Condition to stop recursion
2. **Recursive Case** - Function calling itself with smaller problem
3. **Progress** - Problem becomes simpler with each call

**General Pattern:**
```
recursiveFunction(n):
    if n == base case:
        return base value
    else:
        return recursiveFunction(n-1) [modified]
```

### Financial Formula
**Compound Interest Formula:**
```
FV = PV × (1 + r)^n

Where:
  FV = Future Value
  PV = Present Value (initial investment)
  r = Annual interest rate (decimal)
  n = Number of years
```

### Recursive Approach
Converting the formula into recursion:
```
FV(0) = PV (base case - no years)
FV(n) = FV(n-1) × (1 + r) (recursive case)
```

## Implementation Strategies

### 1. Naive Recursive Implementation
```java
double calculateFutureValue(double pv, double r, int n) {
    if (n == 0) return pv;
    return calculateFutureValue(pv, r, n-1) * (1 + r);
}
```

**Characteristics:**
- Simple and elegant
- Direct translation of recursion concept
- **VERY INEFFICIENT** for large n
- Repeated calculations cause exponential growth

**Time Complexity:** O(2^n) - Exponential (TERRIBLE)
**Space Complexity:** O(n) - Call stack depth

**Example: n=5 function calls**
```
FV(5)
├── FV(4)
│   ├── FV(3)
│   │   ├── FV(2)
│   │   │   ├── FV(1)
│   │   │   └── FV(1)
│   │   └── FV(2)
│   └── FV(3)
└── FV(4)
... exponential growth
```

**Practical Limits:**
- n ≤ 20: Noticeable slowdown
- n ≤ 35: Several seconds
- n ≤ 40: Minutes or hours
- n ≥ 50: Practically unusable

### 2. Memoization (Caching) Approach
```java
Map<String, Double> cache = new HashMap<>();

double calculateWithMemo(double pv, double r, int n) {
    String key = pv + ":" + r + ":" + n;
    if (cache.contains(key)) return cache.get(key);
    
    if (n == 0) return pv;
    double result = calculateWithMemo(pv, r, n-1) * (1 + r);
    cache.put(key, result);
    return result;
}
```

**Characteristics:**
- Stores previously calculated results
- Eliminates repeated calculations
- Still uses recursion
- Much faster than naive approach

**Time Complexity:** O(n) - Linear (each value calculated once)
**Space Complexity:** O(n) - Cache storage + call stack

**Call Sequence:**
```
FV(5) → not in cache → calculate
FV(4) → not in cache → calculate
FV(3) → not in cache → calculate
FV(2) → not in cache → calculate
FV(1) → not in cache → calculate
FV(0) → base case
[Return and cache each result]
```

**Performance Improvement:** ~2^n to n (huge!)

### 3. Iterative Approach (Loop-based)
```java
double calculateIterative(double pv, double r, int n) {
    double fv = pv;
    for (int i = 0; i < n; i++) {
        fv *= (1 + r);
    }
    return fv;
}
```

**Characteristics:**
- Uses loop instead of recursion
- Most intuitive for this problem
- Excellent performance
- No recursion overhead

**Time Complexity:** O(n) - Linear
**Space Complexity:** O(1) - Constant (no extra storage)

**Execution Flow:**
```
i=0: fv = pv × (1+r)
i=1: fv = fv × (1+r)
i=2: fv = fv × (1+r)
...
i=n: done
```

### 4. Mathematical Approach (Direct Formula)
```java
double calculateMathematical(double pv, double r, int n) {
    return pv * Math.pow(1 + r, n);
}
```

**Characteristics:**
- Direct formula application
- No recursion or loops
- Single operation
- Maximum efficiency

**Time Complexity:** O(1) - Constant (assuming Math.pow is O(1))
**Space Complexity:** O(1) - Constant

**Note:** Math.pow() uses optimized algorithms (exponentiation by squaring)

## Time Complexity Comparison

| Method | Time | Space | For n=20 | For n=30 | For n=40 |
|--------|------|-------|----------|----------|----------|
| Naive | O(2^n) | O(n) | ~1ms | ~1s | ~1000s |
| Memoization | O(n) | O(n) | ~0.01ms | ~0.015ms | ~0.02ms |
| Iterative | O(n) | O(1) | ~0.005ms | ~0.0075ms | ~0.01ms |
| Mathematical | O(1) | O(1) | ~0.001ms | ~0.001ms | ~0.001ms |

## Key Insights

### Rule of 72
Approximates years needed to double investment:
```
Years to double ≈ 72 / (rate × 100)

Example: At 8% return
Years ≈ 72 / 8 = 9 years
```

### Doubling Effect
- 10 years at 7%: 1.97x (nearly doubles)
- 20 years at 7%: 3.87x
- 30 years at 7%: 7.61x (doubles 3 times)

### Recursion Lessons

1. **Problem Structure** - Check if problem has optimal substructure
2. **Base Case** - Essential to prevent infinite recursion
3. **Performance** - Naive recursion can be exponential
4. **Memoization** - Simple fix for repeated calculations
5. **When to Use** - Recursion shines for tree/graph problems

## Expected Output Example

```
--- Scenario 1: Basic Investment Growth ---
Investment Details:
  Principal: ₹10000.0
  Annual Rate: 8.0%
  Duration: 5 years

Future Value Calculations:
  Naive Recursive: ₹14693.28 (Time: 0.15 ms)
  Memoization: ₹14693.28 (Time: 0.02 ms)
  Iterative: ₹14693.28 (Time: 0.01 ms)
  Mathematical: ₹14693.28 (Time: 0.00 ms)

--- Yearly Growth Breakdown ---
Year | Amount (₹) | Interest Earned (₹)
0    | 10,000.00  | 0.00
1    | 10,800.00  | 800.00
2    | 11,664.00  | 864.00
3    | 12,597.12  | 933.12
4    | 13,604.89  | 1,007.77
5    | 14,693.28  | 1,088.39
```

## Real-world Applications

1. **Personal Finance**
   - Retirement planning
   - College fund calculation
   - Loan repayment schedules

2. **Investment Management**
   - Portfolio growth projection
   - Risk analysis
   - Comparative investments

3. **Business Finance**
   - Project ROI calculation
   - Capital budgeting
   - Depreciation schedules

4. **Banking**
   - Loan calculations
   - Savings account growth
   - Credit card interest

## Practice Scenarios

### Scenario 1: Emergency Fund
- Goal: Build 6 months emergency fund (₹150,000)
- Monthly savings: ₹5,000
- Expected return: 5% annually
- Question: How many months to reach goal?

### Scenario 2: Retirement Planning
- Current age: 30
- Retirement age: 60
- Current savings: ₹500,000
- Monthly contribution: ₹20,000
- Expected return: 10% annually
- Question: Amount at retirement?

### Scenario 3: Investment Comparison
- Same initial amount
- Different return rates (5%, 7%, 10%)
- Question: Which doubles first?

## Advanced Topics

### Compound Interest Variations
- **Continuous Compounding:** FV = PV × e^(r×n)
- **Monthly Compounding:** FV = PV × (1 + r/12)^(n×12)
- **Daily Compounding:** FV = PV × (1 + r/365)^(n×365)

### Recursion Optimization Techniques
1. **Tail Recursion** - Can be optimized to iteration
2. **Mutual Recursion** - Functions calling each other
3. **Tail Call Optimization** - JVM limitation

## Key Learning Outcomes

1. ✓ Understand recursion concepts and components
2. ✓ Recognize exponential complexity problems
3. ✓ Implement memoization optimization
4. ✓ Apply mathematical formulas efficiently
5. ✓ Make informed algorithm selection decisions
6. ✓ Analyze real-world financial scenarios

## Recommended Reading
- "Cracking the Coding Interview" - Recursion & Dynamic Programming
- "Introduction to Algorithms" - CLRS
- Personal finance planning guides
