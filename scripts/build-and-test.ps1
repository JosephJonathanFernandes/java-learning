# Builds the project and runs JUnit 5 tests without Maven
# Usage: .\build-and-test.ps1

param(
    [string]$junitVersion = "1.10.0",
    [string]$junitJar = "junit-platform-console-standalone.jar"
)

$root = Split-Path -Parent (Split-Path -Parent $MyInvocation.MyCommand.Definition)
Set-Location $root

$libDir = Join-Path $root "lib"
if (!(Test-Path $libDir)) { New-Item -ItemType Directory -Path $libDir | Out-Null }

$jarPath = Join-Path $libDir $junitJar
if (!(Test-Path $jarPath)) {
    Write-Host "Downloading junit-platform-console-standalone..."
    $url = "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$junitVersion/junit-platform-console-standalone-$junitVersion.jar"
    Invoke-WebRequest -Uri $url -OutFile $jarPath
}

$srcMain = Join-Path $root "src\main\java"
$srcTest = Join-Path $root "tests"
$buildDir = Join-Path $root "out"
if (Test-Path $buildDir) { Remove-Item -Recurse -Force $buildDir }
New-Item -ItemType Directory -Path $buildDir | Out-Null

# Compile main sources
Write-Host "Compiling main sources..."
$mainFiles = Get-ChildItem -Path $srcMain -Recurse -Filter *.java | ForEach-Object { $_.FullName }
if ($mainFiles.Count -gt 0) {
    javac -d $buildDir $mainFiles
} else {
    Write-Host "No main sources found to compile."
}

# Compile test sources (include classpath to junit jar)
Write-Host "Compiling test sources..."
$testFiles = Get-ChildItem -Path $srcTest -Recurse -Filter *.java | ForEach-Object { $_.FullName }
if ($testFiles.Count -gt 0) {
    javac -cp "$jarPath;$buildDir" -d $buildDir $testFiles
} else {
    Write-Host "No test sources found to compile."
}

# Run tests using the console launcher
Write-Host "Running JUnit console launcher..."
$cmd = "java -jar `"$jarPath`" -cp `"$buildDir`" --scan-class-path"
Write-Host $cmd
Invoke-Expression $cmd
