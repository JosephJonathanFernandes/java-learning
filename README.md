
# Java Learning Examples

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://openjdk.java.net/)
[![Maven](https://img.shields.io/badge/Maven-3.x-red.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-5-green.svg)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

Professional, modular, and secure Java codebase for learning and demonstrating core programming concepts. Built to enterprise-grade standards with comprehensive testing, security, and documentation.

## 🎯 Problem

Learning Java from scattered code leads to bad habits and confusion. This project provides a clean, enterprise-ready structure for:
- Practicing Java fundamentals and OOP principles
- Demonstrating SOLID, Clean Code, and security best practices
- Showcasing professional, production-grade code for recruiters and contributors

## 🏗️ Architecture

See [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) for full details.

**Core Layers:**
- `model/`: Business entities (Student, Account, SavingsAccount)
- `service/`: Business logic and calculations (AccountService)
- `examples/`: Executable demos and CLI applications

**Key Principles:** SOLID, DRY, separation of concerns, configuration-driven, secure by default

## 🛠️ Tech Stack

- **Java 17+** - Modern Java with latest features
- **Maven 3.x** - Build automation and dependency management
- **JUnit 5** - Comprehensive testing framework
- **Checkstyle & Spotless** - Code quality and formatting
- **GitHub Actions** - CI/CD pipeline

## ✨ Features

- 🏢 **Enterprise-grade structure** with proper separation of concerns
- 🔒 **Security-first approach** (no hardcoded secrets, input validation)
- 🧪 **Comprehensive testing** with 80%+ coverage goal
- 📚 **Professional documentation** and architecture guides
- 🚀 **Easy to run, extend, and contribute** to
- 🎯 **Learning-focused** with practical examples

## 🚀 Quick Start

### Prerequisites
- Java JDK 17 or higher
- Maven 3.x or higher

### Installation

```bash
git clone https://github.com/JosephJonathanFernandes/java-learning.git
cd java-learning
mvn clean compile
```

### Running Examples

```bash
# Run the student grade calculator example
mvn exec:java -Dexec.mainClass="com.example.learningjava.examples.StudentGradeCalculator"

# Run the bank account system example
mvn exec:java -Dexec.mainClass="com.example.learningjava.examples.BankAccountSystem"

# Run the calculator example
mvn exec:java -Dexec.mainClass="com.example.learningjava.examples.Calculator"
```

### Running Tests

```bash
mvn test
```

### Building the Project

```bash
mvn clean package
```

## 💡 Usage Examples

### Student Grade Calculator
```java
import com.example.learningjava.model.Student;

public class Example {
    public static void main(String[] args) {
        // Create a student with name and number of subjects
        Student student = new Student("Alice", 3);

        // Set marks for the subjects
        student.setMarks(new int[]{90, 85, 88});

        // Calculate and display results
        System.out.println("Student: " + student.getName());
        System.out.println("Average: " + student.calculateAverage());
        System.out.println("Grade: " + student.calculateGrade());
    }
}
```

## 📁 Project Structure

```
java-learning/
├── src/main/java/com/example/learningjava/
│   ├── model/          # Business models/entities
│   │   ├── Account.java
│   │   ├── Student.java
│   │   └── SavingsAccount.java
│   ├── service/        # Business logic/services
│   │   └── AccountService.java
│   └── examples/       # Executable examples/demos
│       ├── BankAccountSystem.java
│       ├── Calculator.java
│       ├── StudentGradeCalculator.java
│       └── ... (other examples)
├── src/test/java/      # Unit and integration tests
├── docs/               # Comprehensive documentation
│   ├── ARCHITECTURE.md
│   ├── SECURITY.md
│   ├── DEV_EXPERIENCE.md
│   └── ...
├── scripts/            # Build and automation scripts
├── config/             # Configuration files
├── .env.example        # Environment variable template
├── pom.xml             # Maven configuration
├── checkstyle.xml      # Code style configuration
└── README.md           # This file
```

## 🔒 Security

- ✅ No hardcoded secrets (environment-driven configuration)
- ✅ Input validation and comprehensive error handling
- ✅ Secure coding practices throughout
- 📖 See [docs/SECURITY.md](docs/SECURITY.md) for detailed security policy

## 🧪 Testing

- **JUnit 5** for all unit and integration tests
- **JaCoCo** for test coverage reporting
- **Coverage goal**: 80%+ for business logic
- **Example**: See `src/test/java/com/example/learningjava/model/StudentTest.java`

## 🔧 Development Tools

### Code Quality & Formatting
- **Checkstyle** - Static code analysis (configured in `checkstyle.xml`)
- **Spotless** - Code formatting with Google Java Format
- **Pre-commit hooks** - Automated quality checks (see `docs/DEV_EXPERIENCE.md`)

### CI/CD Pipeline
- **GitHub Actions** - Automated build, test, and lint on every push/PR
- **Quality gates** - Build fails on code style violations or test failures

## 🤝 Contributing

We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for detailed guidelines.

**Quick contribution steps:**
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Make your changes following our coding standards
4. Add/update tests as needed
5. Run `mvn clean test` to ensure everything works
6. Commit your changes (`git commit -m "Add: amazing feature"`)
7. Push to your branch and create a Pull Request

## 📚 Documentation

- 📋 **[Architecture Guide](docs/ARCHITECTURE.md)** - System design and principles
- 🔒 **[Security Policy](docs/SECURITY.md)** - Security guidelines and vulnerability reporting
- 🛠️ **[Developer Experience](docs/DEV_EXPERIENCE.md)** - Setup and development workflow
- 📝 **[Changelog](docs/CHANGELOG.md)** - Version history and updates
- 🎯 **[Interview Prep](docs/INTERVIEW_PREP.md)** - Java interview preparation guide

## 🎯 Value Proposition

- **👨‍🎓 Learners**: Learn best practices, not just syntax
- **👔 Recruiters**: See real-world, production-grade Java code
- **👥 Contributors**: Easy to extend, review, and maintain codebase
- **🏢 Enterprises**: Reference implementation for Java standards

---

*Built for the Java community — professional, secure, and open source.* 🚀
</content>
<task_progress>
- [ ] Review README.md content and structure
- [ ] Fix repository URLs
- [ ] Update project structure
- [ ] Clean up duplicate content
- [ ] Update CONTRIBUTING.md
- [ ] Check other docs files
- [ ] Add proper formatting and badges
</task_progress>
