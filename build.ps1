# Small helper to compile all java files and optionally run a class
param(
    [string]$runClass
)

Write-Host "Compiling all .java files..."
javac *.java
if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed."
    exit $LASTEXITCODE
}

if ($runClass) {
    Write-Host "Running $runClass..."
    java $runClass
}
else {
    Write-Host "Compilation complete. To run: .\build.ps1 -runClass ClassName"
}
