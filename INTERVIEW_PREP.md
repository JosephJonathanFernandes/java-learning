# Interview & Viva Preparation — java-learning

This file collects common viva/interview questions (with concise model answers) tailored to this repository: Git workflow, `.gitignore`, Java fundamentals, and the `StudentGradeCalculator` example.

---

## Quick instructions
- Use this document to practice short viva answers and coding tasks.
- Try to answer verbally first, then check the model answer below.

---

## Git & workflow
Q: What commands did you run to add and commit files? Explain.
A: `git add .` stages all untracked/modified files. `git commit -m "message"` creates a new commit with staged changes. `git push -u origin main` uploads the local branch to the remote and sets upstream.

Q: Why did `git push` fail with "Could not resolve host: github.com"?
A: DNS or network issue; check internet connection, DNS resolution, proxy settings, or corporate firewall. Diagnosis: `ping github.com`, `Test-NetConnection github.com -Port 443` (PowerShell).

Q: How to remove a committed `ArrayDemo.class` but keep it locally?
A: `git rm --cached ArrayDemo.class` then commit and push. Add `*.class` to `.gitignore`.

Q: How to remove it from all history?
A: Use `git filter-branch` or `git filter-repo` to rewrite history; be careful — this rewrites commits and requires force-push and coordination.

---

## .gitignore
Q: How do you ignore all `.class` files?
A: Add `*.class` to `.gitignore`. This matches files recursively (including subdirectories).

Q: Will `.gitignore` stop tracking already committed files?
A: No. You must untrack them using `git rm --cached <file>`.

---

## Java basics
Q: What's the difference between `.java` and `.class` files?
A: `.java` is source code written by the programmer. `javac` compiles `.java` into `.class` bytecode, which the JVM executes.

Q: What is the required `main` signature?
A: `public static void main(String[] args)`

Q: What happens when `javac *.java` is run?
A: The compiler compiles each `.java` file. If classes depend on each other, javac resolves them and produces `.class` files.

---

## StudentGradeCalculator (specific)
Q: Describe program flow and inputs.
A: Program asks for student name, number of subjects (integer), then prompts for each subject mark via `nextInt()`. It calculates average and grade and prints results.

Q: Why cast to `double` when calculating average?
A: To avoid integer division and preserve fraction (e.g., 85.5 instead of 85).

Q: Input validation: what if a non-integer is entered?
A: `nextInt()` throws `InputMismatchException`. Use `Scanner.hasNextInt()` or read line and parse with try/catch.

Q: What about `subjects <= 0`?
A: Protect by validating `subjects` and prompting again or exiting with an error message.

```markdown
# Interview & Viva Preparation — java-learning

This file is a concise, interview-ready collection of viva and technical questions covering:
- Git & repo workflow
- `.gitignore` and repo hygiene
- README / documentation
- Java fundamentals and tooling
- Project-specific questions (files in this repo, with focus on `StudentGradeCalculator`)
- Practical tasks and short model answers you can rehearse

How to use
- Try answering each question verbally in 30–60s, then check the short model answer below.
- Use the "Practical tasks" section to run small commands and demonstrate knowledge live in an interview.

---

## 1) Git & workflow (viva-style)

Q: Which commands did you run to add, commit and push files? Explain each.
A: `git add <file|.>` stages changes; `git commit -m "msg"` records a snapshot locally; `git push -u origin main` uploads the branch to remote and sets upstream (`-u` sets tracking).

Q: What does `git status` show and why run it before committing?
A: It shows staged, unstaged, and untracked files; useful to ensure you only commit intended changes.

Q: Why would `git push` fail with "Could not resolve host: github.com" and how do you diagnose?
A: DNS/network issue (no internet, proxy, or firewall). Diagnose with `ping github.com`, `Test-NetConnection github.com -Port 443` (PowerShell) or check proxy settings.

Q: A `.class` file is already committed — how do you stop tracking it but keep it locally?
A: Add `*.class` to `.gitignore`, then run `git rm --cached path/to/File.class` and commit the change.

Q: How do you remove a file from all git history?
A: Use history-rewrite tools (`git filter-repo` preferred, or `git filter-branch`), then force-push; coordinate with collaborators — this rewrites commits.

---

## 2) `.gitignore` and repo hygiene

Q: How to ignore all compiled class files?
A: Add `*.class` to `.gitignore` (matches files in all directories).

Q: If a file is already tracked, does `.gitignore` stop git from tracking it?
A: No. You must untrack it with `git rm --cached <file>` and commit.

Q: Common patterns you should include in a Java learning repo
A: `*.class`, `bin/`, `build/`, `.idea/`, `.vscode/`, `*.log`, and OS files like `.DS_Store`/`Thumbs.db`.

---

## 3) README & CONTRIBUTING (short questions)

Q: What belongs in a minimal README for this repo?
A: Purpose, file list, compile/run instructions (platform-specific), notes about `.gitignore` and contribution hints.

Q: What should `CONTRIBUTING.md` mention for a beginner-friendly repo?
A: How to run/build, coding style expectations, don't commit `.class` files, how to run tests, PR checklist.

---

## 4) Java fundamentals & tooling

Q: What's the difference between a `.java` and a `.class` file?
A: `.java` is source code; `javac` compiles it to `.class` bytecode which runs on the JVM.

Q: What is the `main` method signature the JVM looks for?
A: `public static void main(String[] args)`

Q: What do `javac` and `java` do?
A: `javac` compiles source to bytecode; `java` launches the JVM to run bytecode.

Q: What is classpath and when must you set it?
A: Classpath tells JVM where to find classes and resources; set it when using external jars or non-default locations (via `-cp` or environment variable).

Q: What is the difference between JDK and JRE?
A: JDK contains tools for development (compiler, etc.); JRE contains the runtime (JVM) only.

---

## 5) Project-specific questions (per file)

For each small example file, interviewers may ask what concept it demonstrates and a short improvement. Be ready to answer for these files:

- `Hello.java` — prints text; demonstrates entry point.
- `ArrayDemo.java` — arrays, traversal, average calculation (note: shows casting to `double`).
- `Calculator.java` — interactive menu, `Scanner`, switch/do-while, basic validation for divide-by-zero.
- `IfElseDemo.java` — `if/else if/else` and `switch` usage.
- `InputDemo.java` — `Scanner.nextLine()` vs `nextInt()`; watch for newline consumption issues.
- `LoopDemo.java` — `for`, `while`, `do-while` loops.
- `MethodDemo.java` — static methods, return values.
- `OOPDemo.java` — simple class with fields and method; demonstrates instantiation and method call.
- `Practice.java` — grouping helpers and a driver class for small examples.
- `StudentGradeCalculator.java` — interactive `Student` class, collects marks, computes average and grade, and prints results.

When asked: explain one file in 60s (what it does, what it tests, one improvement). Example improvement: add input validation and unit tests.

---

## 6) Deep dive: `StudentGradeCalculator` (viva + coding)

Q: Walk through the program flow and expected inputs.
A: Reads student name (`nextLine()`), number of subjects (`nextInt()`), then loops `subjects` times calling `nextInt()` for marks. It computes average via `calculateAverage()` and grade via `calculateGrade()` and prints both.

Q: Why cast to `double` when computing average?
A: To avoid integer division and preserve fractional averages.

Q: What exceptions or bad inputs can occur and how to handle them?
A: `InputMismatchException` for non-integer input; `ArrayIndexOutOfBounds` if subjects <= 0; handle using validation loops, `Scanner.hasNextInt()`, and try/catch.

Q: How to make this testable (unit tests)?
A: Extract pure logic into methods that accept parameters (e.g., `double calculateAverage(int[] marks)` static method). Write JUnit tests for boundary and typical cases.

Q: How to extend grading to A+/A/A- style?
A: Replace `calculateGrade()` logic with more granular ranges and return strings (e.g., "A+", "A"). Keep thresholds configurable.

---

## 7) Practical tasks (to run during a mock viva)

1) Compile & run a program:
```powershell
javac StudentGradeCalculator.java
java StudentGradeCalculator
```

2) Untrack compiled classes and push:
```powershell
git rm --cached *.class
git commit -m "Remove compiled class files"
git push
```

3) Verify network/DNS for `git push` failure (PowerShell):
```powershell
Test-NetConnection github.com -Port 443
```

4) Add a simple unit test (example outline):
- Extract `calculateAverage(int[])` and `calculateGrade(double)` and write JUnit tests for expected grades.

---

## 8) Short model answers & quick tips (cheat sheet)
- `git add .` — stage changes
- `git commit -m "msg"` — commit
- `git push -u origin main` — push and set upstream
- To untrack a file: `git rm --cached <file>` then commit
- Put `*.class` in `.gitignore` to avoid committing compiled files
- Use `Scanner.hasNextInt()` or `try { Integer.parseInt(s) } catch` for safe input
- Make logic pure (no I/O) to simplify unit testing
- Prefer `git filter-repo` over `filter-branch` when rewriting history

---

## 9) Mock viva options
- I can run a mock viva where I ask 10 questions and score answers.
- Or I can convert these into printable flashcards or a single PDF for revision.

If you want, I can now:
- run the `git rm --cached` commands to untrack `.class` files,
- add a sample JUnit test and a GitHub Actions workflow, or
- run a short mock viva session.

---

Good luck 

```

