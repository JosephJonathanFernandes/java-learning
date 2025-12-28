# Professional Java Learning Project

This repository is organized for clarity, modularity, and security. It follows best practices for open-source, enterprise-grade Java projects.

## Top-Level Structure

- `src/` — Core application logic (main code only)
- `tests/` — Unit and integration tests (mirrors src/ structure)
- `docs/` — Architecture, design, and security documentation
- `config/` — Configuration files and environment setup
- `scripts/` — Automation and utility scripts

## Java Source Layout

- `src/main/java/com/example/learningjava/model/` — Business models/entities
- `src/main/java/com/example/learningjava/service/` — Business logic/services (recommended for future growth)
- `src/main/java/com/example/learningjava/examples/` — Executable learning examples

## Testing

- `tests/` — Place all test code here, mirroring the package structure of `src/`
- Use JUnit 5 for unit and integration tests

## Configuration

- `.env.example` — Template for environment variables (never commit real secrets)
- `.gitignore` — Excludes build artifacts, secrets, and system files

## Ownership

- See `CONTRIBUTING.md` for contribution and code ownership guidelines

---

*For more details, see `docs/ARCHITECTURE.md`.*
