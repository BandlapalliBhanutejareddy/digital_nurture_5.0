# Exercise-2-FactoryMethod: Document Factory Pattern

## Overview
This exercise demonstrates the **Factory Method Design Pattern** by creating different document types (Word, PDF, Excel) through a centralized factory, decoupling client code from concrete document implementations.

## Objective
To understand and implement the Factory Method pattern, a creational design pattern that provides an interface for creating objects without specifying their exact classes.

## Files
- `Document.java` - Interface defining document contract
- `WordDocument.java` - Concrete implementation for Word documents
- `PdfDocument.java` - Concrete implementation for PDF documents
- `ExcelDocument.java` - Concrete implementation for Excel documents
- `DocumentFactory.java` - Factory for creating document instances
- `FactoryMethodTest.java` - Test and demo class

## Key Concepts

### Factory Method Pattern
The Factory Method pattern provides a way to create objects without specifying their concrete classes, promoting loose coupling and flexibility.

**Components:**
- **Creator (DocumentFactory)**: Defines factory method
- **Product (Document)**: Interface for created objects
- **Concrete Products**: WordDocument, PdfDocument, ExcelDocument

### Pattern Benefits
1. **Loose Coupling** - Client code doesn't need to know concrete classes
2. **Flexibility** - Easy to add new document types
3. **Maintainability** - Changes in object creation centralized in factory
4. **Extensibility** - New document types added without modifying existing code

## Time Complexity Analysis
- **createDocument()**: O(1) - Constant time factory lookup
- **generateContent()**: O(n) - where n is content size
- **All operations**: O(1) average case

## Space Complexity
- O(1) - Each document type uses constant extra space

## Design Pattern Structure

```
┌─────────────┐
│  Document   │ (Interface)
│  Interface  │
└──────┬──────┘
       │
       ├─────────────────┬─────────────────┬─────────────────┐
       │                 │                 │                 │
   ┌───┴───┐         ┌───┴───┐        ┌───┴───┐        ┌────┴────┐
   │ Word  │         │ PDF   │        │ Excel │        │ Factory │
   │ Doc   │         │ Doc   │        │ Doc   │        │         │
   └───────┘         └───────┘        └───────┘        └────┬────┘
                                                              │
                                      (creates and returns)───┘
```

## Implementation Pattern

```java
// Factory creates objects based on type
Document doc = DocumentFactory.createDocument("WORD");
doc.open();
doc.generateContent();
doc.save();
doc.close();
```

## Supported Document Types
- **Word**: "WORD", "DOC", "DOCX"
- **PDF**: "PDF"
- **Excel**: "EXCEL", "XLS", "XLSX"

## Expected Output
```
=== Factory Method Design Pattern Demo ===

--- Creating Word Document ---
Opening document in Microsoft Word Application
Generating Microsoft Word Document (.docx) content...
- Adding paragraphs with formatting
- Applying styles and themes
- Embedding images and objects
Saving document as .docx format
Closing Microsoft Word document

--- Creating PDF Document ---
Opening document in PDF Viewer Application
Generating PDF Document (.pdf) content...
...

--- Creating Excel Document ---
...
```

## Advantages
1. **Encapsulation** - Object creation logic isolated in factory
2. **Flexibility** - Easy to change how objects are created
3. **Scalability** - Easy to add new document types
4. **Open/Closed Principle** - Open for extension, closed for modification
5. **Single Responsibility** - Factory handles object creation

## Disadvantages
1. **Complexity** - Adds extra layer of abstraction
2. **Overkill** - May be unnecessary for simple scenarios
3. **Learning Curve** - Harder to understand for beginners

## Comparison with Other Patterns

| Pattern | Use Case | Complexity |
|---------|----------|-----------|
| Factory Method | Multiple related objects | Medium |
| Abstract Factory | Families of objects | High |
| Builder | Complex object construction | High |
| Prototype | Cloning objects | Medium |

## Real-world Applications
- Document generation systems
- UI component creation
- Database connection factories
- HTTP client factories
- Parser factories

## Extension: Adding New Document Type
To add a new document type (e.g., PowerPoint):
1. Create `PowerPointDocument` implementing `Document`
2. Add case in `DocumentFactory.createDocument()`
3. No changes needed to client code!

```java
case "POWERPOINT":
case "PPT":
case "PPTX":
    return new PowerPointDocument();
```

## Variations of Factory Method
1. **Simple Factory** - Single factory class (current implementation)
2. **Factory Method** - Abstract factory in base class
3. **Abstract Factory** - Family of factories for related objects
4. **Parameterized Factory** - Factory method with parameters

## Java Best Practices Demonstrated
- Interface-based design
- Polymorphism
- Error handling with IllegalArgumentException
- Case-insensitive factory method
- Null checking
