# Campus Student Record Manager

A command-line Java application for maintaining student academic records.

## Features
- Add, display, search, update and delete students
- Sort records by name
- Calculate average marks
- Save/load records using a CSV file
- Input validation and exception handling
- Runs directly from a terminal

## Requirements
Java JDK 17 or newer.

## Compile
```bash
javac -d out src/*.java
```

## Run
```bash
java -cp out Main
```

The program creates `students.csv` when records are saved.

## Structure
```text
campus-student-record-manager/
├── src/
│   ├── Main.java
│   ├── Student.java
│   └── StudentRepository.java
├── README.md
└── Project_Report.txt
```
