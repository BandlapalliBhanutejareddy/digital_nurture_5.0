# Cognizant Digital Nurture 5.0 - Java FSE Repository

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat&logo=java)
![License](https://img.shields.io/badge/License-MIT-green)
![Status](https://img.shields.io/badge/Status-Active-brightgreen)

## 📋 Project Overview

This repository contains comprehensive implementations of fundamental Java concepts required for the **Cognizant Digital Nurture 5.0** Full Stack Engineering (FSE) program. It covers two critical modules: Design Patterns and Data Structures & Algorithms (DSA).

### Program Information
- **Program Name:** Cognizant Digital Nurture 5.0
- **Track:** Java Full Stack Engineering (FSE)
- **Minimum Java Version:** JDK 17
- **Learning Duration:** Self-paced with guided exercises
- **Repository Type:** Educational

## 🎯 Learning Objectives

### Module 1: Design Patterns
Upon completion of Module 1, learners will be able to:

- **Understand Design Patterns**
  - Recognize and categorize design patterns
  - Understand SOLID principles and their application
  - Identify when to apply specific patterns

- **Implement Creational Patterns**
  - Implement Singleton pattern in various ways
  - Implement Factory Method pattern
  - Understand object creation best practices

- **Apply Patterns to Real-world Problems**
  - Encapsulate object creation logic
  - Decouple client code from implementations
  - Make code extensible and maintainable

### Module 2: Data Structures & Algorithms (DSA)
Upon completion of Module 2, learners will be able to:

- **Master Search Algorithms**
  - Implement and compare Linear Search
  - Implement and compare Binary Search
  - Understand complexity analysis
  - Choose appropriate algorithm for scenarios

- **Understand Recursion**
  - Implement recursive solutions
  - Analyze recursive complexity
  - Optimize recursive functions
  - Use memoization effectively

- **Apply DSA to Real-world Scenarios**
  - E-commerce product search optimization
  - Financial forecasting with recursion
  - Performance analysis and optimization

## 📁 Repository Structure

```
digital_nurture_5.0/
├── Module-1-Design-Patterns/
│   ├── Exercise-1-Singleton/
│   │   ├── Logger.java                 # Singleton implementation
│   │   ├── SingletonTest.java          # Test class
│   │   └── README.md                   # Detailed documentation
│   │
│   └── Exercise-2-FactoryMethod/
│       ├── Document.java               # Product interface
│       ├── WordDocument.java            # Concrete implementation
│       ├── PdfDocument.java             # Concrete implementation
│       ├── ExcelDocument.java           # Concrete implementation
│       ├── DocumentFactory.java         # Factory class
│       ├── FactoryMethodTest.java       # Test class
│       └── README.md                    # Detailed documentation
│
├── Module-2-DSA/
│   ├── Exercise-2-EcommerceSearch/
│   │   ├── Product.java                # Model class
│   │   ├── LinearSearch.java           # Linear search implementation
│   │   ├── BinarySearch.java           # Binary search implementation
│   │   ├── EcommerceSearchTest.java     # Test class with sample data
│   │   └── README.md                    # Detailed documentation
│   │
│   └── Exercise-7-FinancialForecasting/
│       ├── FinancialForecast.java       # Multiple recursive approaches
│       ├── FinancialForecastTest.java   # Test class with scenarios
│       └── README.md                    # Detailed documentation
│
├── docs/
│   ├── Module1_Notes.md                # Comprehensive Module 1 study notes
│   ├── Module2_Notes.md                # Comprehensive Module 2 study notes
│   └── Viva_Questions.md               # Interview preparation questions
│
└── README.md                           # This file
```

## 🧪 Exercises Overview

### Module 1: Design Patterns

#### Exercise 1: Singleton Pattern - Logger Implementation
**Objective:** Understand single instance pattern for shared resources

**Files:**
- `Logger.java` - Singleton logger with private constructor
- `SingletonTest.java` - Demonstrates singleton behavior

**Key Concepts:**
- Private constructor
- Static instance control
- Lazy initialization
- Global access point

**Expected Output:**
```
Logger Instance Created
Application Started
Only One Instance Exists
```

**Time Complexity:** O(1) for getInstance()

---

#### Exercise 2: Factory Method Pattern - Document Factory
**Objective:** Implement flexible object creation without specifying concrete classes

**Files:**
- `Document.java` - Interface defining contract
- `WordDocument.java` - Concrete Word format
- `PdfDocument.java` - Concrete PDF format
- `ExcelDocument.java` - Concrete Excel format
- `DocumentFactory.java` - Factory for creating documents
- `FactoryMethodTest.java` - Comprehensive tests

**Key Concepts:**
- Product interface
- Concrete products
- Factory encapsulation
- Polymorphic behavior
- Open/Closed Principle

**Expected Output:**
```
=== Factory Method Design Pattern Demo ===

--- Creating Word Document ---
Opening document in Microsoft Word Application
Generating Microsoft Word Document (.docx) content...
[Additional details...]
```

**Time Complexity:** O(1) for factory creation

---

### Module 2: Data Structures & Algorithms

#### Exercise 2: E-commerce Search - Linear & Binary Search
**Objective:** Compare search algorithms in real-world e-commerce context

**Files:**
- `Product.java` - Product model class
- `LinearSearch.java` - Sequential search algorithm
- `BinarySearch.java` - Divide-and-conquer search
- `EcommerceSearchTest.java` - Sample data and demonstrations

**Key Concepts:**

**Linear Search:**
- Time: O(n) worst case
- Space: O(1)
- Works on unsorted data
- Good for small datasets

**Binary Search:**
- Time: O(log n) worst case
- Space: O(1) iterative, O(log n) recursive
- Requires sorted data
- Good for large datasets

**Sample Data:** 10 product items with prices and quantities

**Expected Output:**
```
Product found at index 0 after 1 comparisons
Result: Product{ID=105, Name='Laptop', Price=45000.00, Qty=5}

Found 3 products in price range ₹500 - ₹2000
```

---

#### Exercise 7: Financial Forecasting - Recursive Calculation
**Objective:** Master recursion through financial calculations

**Files:**
- `FinancialForecast.java` - Multiple recursive approaches
- `FinancialForecastTest.java` - Real-world scenarios

**Implementations:**
1. **Naive Recursive** - Direct translation (O(n))
2. **Memoization** - Caching results (O(n) optimized)
3. **Iterative** - Loop-based (O(n), best)
4. **Mathematical** - Direct formula (O(1), optimal)

**Key Concepts:**
- Recursion components (base case, recursive case, progress)
- Compound interest formula
- Memoization benefits
- Complexity analysis

**Sample Scenarios:**
- Basic investment growth (₹10,000 at 8% for 5 years)
- Retirement planning (30-year horizon)
- College fund calculation
- Rule of 72 (doubling time)

**Expected Output:**
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
```

---

## 🚀 Getting Started

### Prerequisites
- **JDK 17** or higher
- Any Java IDE (VS Code, IntelliJ IDEA, Eclipse) or terminal
- Git (optional, for version control)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/cognizant/digital_nurture_5.0.git
   cd digital_nurture_5.0-BHANUTEJA
   ```

2. **Verify Java installation**
   ```bash
   java -version
   javac -version
   ```

3. **Compile all Java files**
   ```bash
   # Compile Module 1
   javac Module-1-Design-Patterns/Exercise-1-Singleton/*.java
   javac Module-1-Design-Patterns/Exercise-2-FactoryMethod/*.java

   # Compile Module 2
   javac Module-2-DSA/Exercise-2-EcommerceSearch/*.java
   javac Module-2-DSA/Exercise-7-FinancialForecasting/*.java
   ```

4. **Run the programs**
   ```bash
   # Run Exercise 1
   cd Module-1-Design-Patterns/Exercise-1-Singleton
   java SingletonTest

   # Run Exercise 2
   cd Module-1-Design-Patterns/Exercise-2-FactoryMethod
   java FactoryMethodTest

   # Run Exercise 2 (DSA)
   cd Module-2-DSA/Exercise-2-EcommerceSearch
   java EcommerceSearchTest

   # Run Exercise 7
   cd Module-2-DSA/Exercise-7-FinancialForecasting
   java FinancialForecastTest
   ```

## 📚 Learning Path

### Recommended Study Order

**Week 1: Design Patterns Fundamentals**
1. Read Module 1 study notes (`docs/Module1_Notes.md`)
2. Review Exercise 1: Singleton
3. Run and analyze SingletonTest output
4. Modify code to understand concepts

**Week 2: Factory Method Pattern**
1. Read Factory Method theory in Module 1 notes
2. Study Exercise 2: Factory Method
3. Run FactoryMethodTest with different inputs
4. Try adding a new document type (PowerPoint)

**Week 3: Search Algorithms**
1. Read Module 2 study notes (`docs/Module2_Notes.md`)
2. Review Exercise 2: E-commerce Search
3. Run EcommerceSearchTest with sample data
4. Compare performance metrics

**Week 4: Recursion & Real-world Application**
1. Study recursion concepts in Module 2 notes
2. Review Exercise 7: Financial Forecasting
3. Run FinancialForecastTest with different scenarios
4. Understand complexity trade-offs

**Week 5: Interview Preparation**
1. Review Viva Questions (`docs/Viva_Questions.md`)
2. Practice coding solutions without looking at implementations
3. Explain concepts verbally to solidify understanding
4. Solve extended scenarios

## 💻 How to Compile and Run

### Quick Compilation Script (Windows - PowerShell)
```powershell
# Navigate to project root
cd D:\digital_nurture_5.0-BHANUTEJA

# Compile all Java files
Get-ChildItem -Recurse -Include *.java | ForEach-Object {
    javac $_.FullName
}

# Run a specific test
cd Module-1-Design-Patterns\Exercise-1-Singleton
java SingletonTest
```

### Quick Compilation Script (Linux/Mac - Bash)
```bash
# Navigate to project root
cd digital_nurture_5.0-BHANUTEJA

# Compile all modules
find . -name "*.java" | xargs javac

# Run a specific test
cd Module-1-Design-Patterns/Exercise-1-Singleton
java SingletonTest
```

## 🔍 Code Quality Standards

This repository adheres to Java best practices:

- ✅ **Naming Conventions**
  - Classes: PascalCase (Logger, DocumentFactory)
  - Methods: camelCase (getInstance, createDocument)
  - Constants: UPPER_SNAKE_CASE (if any)

- ✅ **Code Style**
  - Proper indentation (4 spaces)
  - Comprehensive JavaDoc comments
  - Clear variable names
  - Single responsibility principle

- ✅ **Documentation**
  - Inline comments explaining logic
  - README files for each exercise
  - Complexity analysis included
  - Expected output provided

- ✅ **Error Handling**
  - Null checks where appropriate
  - Meaningful exception messages
  - Input validation

## 📊 Complexity Analysis Summary

### Module 1: Design Patterns

| Exercise | Operation | Time | Space |
|----------|-----------|------|-------|
| Singleton | getInstance() | O(1) | O(1) |
| Factory | createDocument() | O(1) | O(1) |

### Module 2: DSA

| Exercise | Algorithm | Best | Average | Worst | Space |
|----------|-----------|------|---------|-------|-------|
| E-Search | Linear | O(1) | O(n) | O(n) | O(1) |
| E-Search | Binary | O(1) | O(log n) | O(log n) | O(1)* |
| F-Cast | Naive Recursive | O(n) | O(n) | O(n) | O(n) |
| F-Cast | Iterative | O(n) | O(n) | O(n) | O(1) |
| F-Cast | Mathematical | O(1) | O(1) | O(1) | O(1) |

*O(log n) for recursive implementation

## 🔗 Related Concepts

### Design Patterns Used
- **Creational:** Singleton, Factory Method
- **SOLID Principles:** All exercises demonstrate OCP, DIP, SRP
- **Polymorphism:** Factory and interface-based design

### Algorithms Demonstrated
- **Searching:** Linear, Binary
- **Recursion:** Multiple implementations, memoization
- **Complexity Analysis:** Time and space trade-offs

### Data Structures Used
- **Arrays:** Product inventory
- **Hash Maps:** Memoization cache
- **Interfaces:** Factory abstraction

## 📖 Recommended Reading

### Design Patterns
- "Design Patterns: Elements of Reusable Object-Oriented Software" - Gang of Four
- "Head First Design Patterns" - Freeman & Freeman
- "Refactoring to Patterns" - Joshua Kerievsky

### Algorithms & Data Structures
- "Introduction to Algorithms" (CLRS) - Cormen, Leiserson, Rivest, Stein
- "Cracking the Coding Interview" - McDowell
- "Algorithm Design Manual" - Skiena

### Java-specific
- "Effective Java" - Joshua Bloch
- "Java Concurrency in Practice" - Goetz et al.
- Official Java Documentation

## 🤝 Contributing

This is an educational repository. For improvements:

1. Fork the repository
2. Create a feature branch
3. Make improvements with clear comments
4. Add test cases if applicable
5. Submit a pull request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## ✨ Key Features

- ✅ **Production-ready code** with proper error handling
- ✅ **Comprehensive documentation** for each exercise
- ✅ **Complexity analysis** included for all algorithms
- ✅ **Multiple implementation approaches** showing trade-offs
- ✅ **Real-world scenarios** using e-commerce and finance
- ✅ **Interview preparation material** with viva questions
- ✅ **Complete study notes** for both modules
- ✅ **Sample data** for testing and learning

## 🎓 Certification

Upon successful completion of all exercises and understanding of concepts, participants will have:

- Thorough understanding of design patterns
- Ability to implement search algorithms
- Mastery of recursion concepts
- Practical knowledge applicable to real projects
- Readiness for technical interviews

## 📞 Support

For questions or issues:
1. Review the exercise README files
2. Check the comprehensive module notes in `docs/`
3. Refer to Viva Questions for concept clarification
4. Examine the well-commented source code

## 🏆 Success Criteria

You have successfully completed this course when you can:

- [ ] Explain and implement Singleton pattern correctly
- [ ] Understand and use Factory Method pattern
- [ ] Implement both Linear and Binary search
- [ ] Compare algorithm complexities meaningfully
- [ ] Write recursive solutions efficiently
- [ ] Answer all viva questions confidently
- [ ] Apply concepts to new problems
- [ ] Explain trade-offs in design decisions

## 📋 Checklist for Repository Verification

- [x] All Java files compile successfully with JDK 17
- [x] All test classes run without errors
- [x] Documentation complete for all exercises
- [x] Complexity analysis included
- [x] Expected output provided
- [x] Sample data included
- [x] Study notes comprehensive
- [x] Viva questions well-explained
- [x] Code follows Java conventions
- [x] Comments explain key logic

---

## 📅 Last Updated
June 23, 2026

## 👤 Repository Maintainer
Cognizant Digital Nurture Program
Java FSE Track - Module 1 & 2 Implementation

---

**"Learn by doing, understand by building, excel by mastering fundamentals."**

For the latest updates and additional resources, visit the Cognizant Digital Nurture portal.
