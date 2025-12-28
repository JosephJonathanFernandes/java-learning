# Linting, Formatting, and Developer Experience

## Linting & Formatting

- **Checkstyle**: Enforced via `checkstyle.xml` (Google Java Style Guide)
- **Spotless**: Automatic code formatting (Maven plugin)
- **EditorConfig**: Add `.editorconfig` for consistent whitespace (recommended)

## Pre-commit Hooks

Use [pre-commit](https://pre-commit.com/) to enforce code quality before every commit.

**Example `.pre-commit-config.yaml`:**

```yaml
repos:
  - repo: https://github.com/pre-commit/pre-commit-hooks
    rev: v4.4.0
    hooks:
      - id: trailing-whitespace
      - id: end-of-file-fixer
  - repo: https://github.com/diffplug/spotless
    rev: v6.22.0
    hooks:
      - id: spotless
```

**Setup:**
1. Install pre-commit: `pip install pre-commit`
2. Run `pre-commit install` in the repo root
3. Commit as usual; hooks will run automatically

## Recommended Tools

- **IDE**: IntelliJ IDEA, VS Code (with Java extensions)
- **Formatter**: Built-in IDE formatter, or [Spotless](https://github.com/diffplug/spotless)
- **Static Analysis**: [SonarLint](https://www.sonarlint.org/), [Checkstyle](https://checkstyle.org/)

## CI Pipeline

- See `.github/workflows/ci.yml` for GitHub Actions setup
- Enforces build, test, and style checks on every push/PR

## Coverage

- Use [JaCoCo](https://www.jacoco.org/jacoco/) for code coverage
- Target: 80%+ for business logic

---
*See README.md for more developer experience tips and links.*
