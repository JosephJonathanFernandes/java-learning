# Contributing

Thanks for wanting to contribute! A few quick guidelines for this learning repo:

- Do not commit compiled `.class` files. Ensure `.gitignore` contains `*.class`.
- Before creating a PR, run `javac *.java` and make sure the code compiles.
- If you accidentally commit a `.class` file, remove it from the repo with:

```powershell
git rm --cached <file>.class
git commit -m "Remove compiled class file"
git push
```

- Keep examples small and focused. Add a new file per concept or clearly document changes in the PR.
- Add unit tests if you add logic that's testable. Use JUnit 5 if you introduce a build tool.

Thank you — maintainers will review small PRs quickly.
