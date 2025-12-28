












# Java Learning Examples

Professional, modular, and secure Java codebase for learning and demonstrating core programming concepts. Built to recruiter-grade, open-source, and security standards.

## Problem

Learning Java from scattered code leads to bad habits and confusion. This project provides a clean, enterprise-ready structure for:
- Practicing Java fundamentals and OOP
- Demonstrating SOLID, Clean Code, and security best practices
- Showcasing professional, production-grade code for recruiters and contributors

## Architecture

See [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) for full details.

**Layers:**
- `model/`: Business entities (e.g., Student, Account)
- `service/`: Business logic and calculations
- `examples/`: Executable demos and CLI apps

**Key Principles:** SOLID, DRY, separation of concerns, configuration-driven, secure by default

## Tech Stack

- Java 17+
- Maven 3.x
- JUnit 5 (testing)
- Checkstyle, Spotless (lint/format)
- GitHub Actions (CI)

## Features

- Modular, scalable, and readable codebase
- Security-first (no hardcoded secrets, .env driven)
- 80%+ test coverage goal
- Professional documentation and architecture
- Easy to run, extend, and contribute

## Quick Start

### Prerequisites
- Java JDK 17+
- Maven 3.x


git clone https://github.com/your-org/java-learning.git
cd java-learning
mvn clean compile


# Run the student grade calculator example
mvn exec:java -Dexec.mainClass="com.example.learningjava.examples.StudentGradeCalculator"

# Run all tests
mvn test


mvn clean package






// Example usage
Student student = new Student("Alice", 3);
student.setMarks(new int[]{90, 85, 88});
System.out.println("Grade: " + student.calculateGrade());


java-learning/
├── src/main/java/com/example/learningjava/
│   ├── model/          # Business models
│   ├── service/        # Business logic
│   └── examples/       # Executable examples
├── src/test/java/      # Unit tests
├── docs/               # Documentation
├── scripts/            # Build scripts
└── config/             # Configuration



mvn test














### Installation

```bash
git clone https://github.com/your-org/java-learning.git
cd java-learning
mvn clean compile
```

### Running Examples

```bash
# Run the student grade calculator example
mvn exec:java -Dexec.mainClass="com.example.learningjava.examples.StudentGradeCalculator"

# Run the bank account system example
mvn exec:java -Dexec.mainClass="com.example.learningjava.examples.BankAccountSystem"
```

### Running Tests

```bash
mvn test
```

### Building

```bash
mvn clean package
```

## Usage

Explore the `examples/` package for runnable demos. See `model/` and `service/` for core logic. Extend or add new examples as needed.

## Project Structure

```
java-learning/
├── src/main/java/com/example/learningjava/
│   ├── model/          # Business models/entities
│   ├── service/        # Business logic/services
│   └── examples/       # Executable examples
├── tests/              # Unit & integration tests (mirrors src/)
├── docs/               # Documentation
├── config/             # Configuration & env setup
├── scripts/            # Automation scripts
├── .env.example        # Environment variable template
├── .gitignore          # Excludes secrets, build, system files
└── pom.xml             # Maven config
```

## Security

- No hardcoded secrets (see `.env.example`)
- Input validation and error handling throughout
- See [docs/SECURITY.md](docs/SECURITY.md) for policy and reporting

## Testing

- JUnit 5 for all unit/integration tests
- Example: see `tests/model/AccountTest.java`
- Coverage goal: 80%+ for business logic


## Linting, Formatting, and CI

- **Checkstyle** and **Spotless** for code style (see `checkstyle.xml`)
- **Pre-commit hooks**: Recommended for all contributors (see `docs/DEV_EXPERIENCE.md` for setup)
- **GitHub Actions CI**: Automated build, test, and lint on every push/PR ([.github/workflows/ci.yml](.github/workflows/ci.yml))

See [docs/DEV_EXPERIENCE.md](docs/DEV_EXPERIENCE.md) for full setup and recommendations.

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

## Documentation

- [Architecture](docs/ARCHITECTURE.md)
- [Security Policy](docs/SECURITY.md)
- [Changelog](docs/CHANGELOG.md)
- [Developer Experience](docs/DEV_EXPERIENCE.md)

## Value

- **Learners**: Teaches best practices, not just syntax
- **Recruiters**: Shows real-world, production-grade code
- **Contributors**: Easy to extend, review, and maintain

---

*Built for the Java community — professional, secure, and open.*
