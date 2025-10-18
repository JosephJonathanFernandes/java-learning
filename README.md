# Java Learning Examples

Small collection of simple Java example programs for learning core Java concepts (variables, loops, arrays, methods, OOP, input/output, etc.).

## Files
- `ArrayDemo.java` - array examples
- `Calculator.java` - simple calculator
- `Hello.java` - Hello world
- `IfElseDemo.java` - conditional examples
- `InputDemo.java` - reading user input
- `LoopDemo.java` - loop examples
- `MethodDemo.java` - methods and return values
- `OOPDemo.java` - object-oriented intro
- `Practice.java` - miscellaneous practice code
- `StudentGradeCalculator.java` - simple student grade calculator (interactive)

## Compile & run (Windows PowerShell)
To compile all files in the folder:

```powershell
javac *.java
```

To compile a single file and run it (example `StudentGradeCalculator`):

```powershell
javac StudentGradeCalculator.java
java StudentGradeCalculator
```

Notes
- This project contains small learning examples; there is no build system (Maven/Gradle) by default.
- The `.gitignore` excludes `.class` files and common IDE folders. If you add a build tool, update `.gitignore` accordingly.

Contributions
- Feel free to add more example files or small unit tests. If you submit PRs, ensure no compiled `.class` files are included.

Interview prep
- `INTERVIEW_PREP.md` - viva and interview questions with short model answers tailored to this repo.

Contributing & helpers
- `CONTRIBUTING.md` - contribution guidelines and quick rules.
- `build.ps1` - Windows PowerShell helper to compile all `.java` files and optionally run a class. Usage:

```powershell
.\build.ps1 -runClass StudentGradeCalculator
```

- `build-and-test.ps1` - helper to compile sources and run JUnit 5 tests without Maven. Usage:

```powershell
.\build-and-test.ps1
```

Requirements: Java JDK (javac and java) on PATH. The script downloads the JUnit console jar into `lib/` and compiles to `out/`.
