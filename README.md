PROGRAMMING IN JAVA – PROJECT REPORT

PROJECT TITLE:
Campus Student Record Manager

STUDENT NAME:
SHUBH TIWARI

REGISTRATION NUMBER:
25BAI10799

COURSE:
Programming in Java


1. INTRODUCTION

Campus Student Record Manager is a command-line based Java application developed to maintain basic student academic records. The application allows the user to add, view, search, update, delete and sort student records. It also calculates the average marks and stores the records in a CSV file.


2. OBJECTIVES

• To develop a practical application using Java.
• To understand and apply Object-Oriented Programming concepts.
• To use ArrayList for storing multiple student records.
• To implement exception handling and input validation.
• To demonstrate file input and output in Java.
• To create an application that can be executed through the command line.


3. FEATURES

• Add a new student record.
• Display all student records.
• Search for a student using ID.
• Update student information.
• Delete a student record.
• Sort students by name.
• Calculate average marks.
• Save records into a CSV file.
• Load previously saved records.
• Handle invalid user input.


4. TECHNOLOGIES USED

Programming Language: Java
JDK Version: 17 or newer
Interface: Command Line
Data Storage: CSV File


5. JAVA CONCEPTS USED

Classes and Objects:
The project uses classes such as Student and StudentRepository to organize the program.

Encapsulation:
Student information is stored using private data members and accessed through methods.

Collections:
ArrayList is used to store and manage multiple student records.

Control Statements:
if, switch and loops are used for decision making and repeated operations.

Exception Handling:
try-catch blocks are used to handle invalid input and file-related errors.

File I/O:
BufferedReader and BufferedWriter are used to read and write student records.


6. MODULE DESCRIPTION

Student.java:
Contains the Student class and stores student ID, name, course and marks.

StudentRepository.java:
Handles saving student records to a CSV file and loading them when the program starts.

Main.java:
Contains the main program, menu and operations performed by the user.


7. WORKING / METHODOLOGY

1. The application starts and checks for previously saved records.
2. The main menu is displayed.
3. The user selects an operation.
4. Required information is taken from the user.
5. Input is validated.
6. The selected operation is performed.
7. The user can continue performing operations.
8. Records can be saved to the CSV file.
9. The program exits when the user selects Save and Exit.


8. COMPILATION AND EXECUTION

Compile the program using:

javac -d out src/*.java

Run the program using:

java -cp out Main


9. EXPECTED OUTPUT

The application displays a menu similar to:

========== CAMPUS STUDENT RECORD MANAGER ==========
1. Add student
2. Display students
3. Search student
4. Update student
5. Delete student
6. Sort by name
7. Show average marks
8. Save records
9. Save and exit


10. CONCLUSION

The Campus Student Record Manager demonstrates the practical use of Java programming concepts including classes and objects, encapsulation, collections, exception handling, sorting and file handling. The project provides a simple way to manage student academic records through a command-line interface.


11. FUTURE ENHANCEMENTS

• Add a graphical user interface.
• Add database connectivity using JDBC.
• Add login and authentication.
• Generate student performance reports.
• Add more academic information and filtering options.
