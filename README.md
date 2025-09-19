# String Calculator Kata (Java, TDD)

This project is an implementation of the **String Calculator Kata** in **Java**, developed using **Test Driven Development (TDD)** with **JUnit 5**.  

The kata demonstrates the **Red → Green → Refactor** cycle and incremental feature development while maintaining clean commits in Git.  

---

## ✨ Features Implemented
- ✅ Handles empty string → returns `0`.  
- ✅ Handles single numbers and comma-separated numbers.  
- ✅ Supports unknown number of inputs.  
- ✅ Supports newlines (`\n`) as delimiters along with commas.  
- ✅ Custom delimiters:
  - Single-character → `//;\n1;2`
  - Any length → `//[***]\n1***2***3`
  - Multiple delimiters → `//[*][%]\n1*2%3`
  - Multiple multi-character delimiters → `//[**][%%]\n1**2%%3`
- ✅ Throws exception on negative numbers:
  - Message includes all negative numbers.  
- ✅ Ignores numbers greater than `1000`.  
- ✅ Tracks how many times `add()` was called (`GetCalledCount`).  
- ✅ Supports an **event listener** (`AddListener`) that triggers after every `add()` call.  

---

## 📂 Project Structure
├── src
│ └── StringCalculator.java
├── test
│ └── StringCalculatorTest.java
├── out # compiled class files
├── lib # JUnit jar here (junit-platform-console-standalone-x.y.z.jar)
└── README.md



---

## ⚙️ Requirements
- Java 11+  
- JUnit 5 (`junit-platform-console-standalone-x.y.z.jar`) → download from [Maven Repository](https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone)  

---

## 🧪 How to Run

### 1. Compile sources and tests
```bash
	javac -d out -cp .:lib/* src/StringCalculator.java test/StringCalculatorTest.java
### 2. Run all tests
	java -cp out:lib/* org.junit.platform.console.ConsoleLauncher --scan-class-path


📚 What I Learned

Writing tests before code (TDD mindset).

Using JUnit 5: assertions, exception testing, test organization.

Java string parsing with regex.

Proper Git workflow with meaningful, incremental commits.

Building clean, extensible code (delimiters, listeners).




🖥️ Run Locally
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>
# Place JUnit jar in lib/
javac -d out -cp .:lib/* src/StringCalculator.java test/StringCalculatorTest.java
java -cp out:lib/* org.junit.platform.console.ConsoleLauncher --scan-class-path



This project demonstrates TDD, unit testing, clean commits, and Java fundamentals. It’s a solid portfolio piece to show software engineering discipline beyond just coding.



























