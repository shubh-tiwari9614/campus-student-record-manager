import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final StudentRepository repository = new StudentRepository();

    public static void main(String[] args) {
        loadData();
        boolean running = true;

        while (running) {
            showMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> sortStudents();
                case 7 -> showAverage();
                case 8 -> saveData();
                case 9 -> {
                    saveData();
                    running = false;
                    System.out.println("Program closed.");
                }
                default -> System.out.println("Choose a number from 1 to 9.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n========== CAMPUS STUDENT RECORD MANAGER ==========");
        System.out.println("1. Add student");
        System.out.println("2. Display students");
        System.out.println("3. Search student");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("6. Sort by name");
        System.out.println("7. Show average marks");
        System.out.println("8. Save records");
        System.out.println("9. Save and exit");
    }

    private static void addStudent() {
        int id = readInt("Student ID: ");
        if (findById(id) != null) {
            System.out.println("That ID is already in use.");
            return;
        }

        String name = readText("Student name: ");
        String course = readText("Course: ");
        double marks = readMarks();

        students.add(new Student(id, name, course, marks));
        System.out.println("Record added.");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        System.out.println("\nID     Name                   Course               Marks");
        System.out.println("-----------------------------------------------------------");
        for (Student s : students) System.out.println(s);
    }

    private static void searchStudent() {
        int id = readInt("Enter student ID: ");
        Student s = findById(id);
        System.out.println(s == null ? "Student not found." : "Record: " + s);
    }

    private static void updateStudent() {
        int id = readInt("Enter student ID to update: ");
        Student s = findById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = readText("New name: ");
        String course = readText("New course: ");
        double marks = readMarks();
        s.update(name, course, marks);
        System.out.println("Record updated.");
    }

    private static void deleteStudent() {
        int id = readInt("Enter student ID to delete: ");
        Student s = findById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(s);
        System.out.println("Record deleted.");
    }

    private static void sortStudents() {
        students.sort(Comparator.comparing(Student::getName,
                String.CASE_INSENSITIVE_ORDER));
        System.out.println("Records sorted by name.");
    }

    private static void showAverage() {
        if (students.isEmpty()) {
            System.out.println("No marks available.");
            return;
        }

        double total = 0;
        for (Student s : students) total += s.getMarks();
        System.out.printf("Average marks: %.2f%n", total / students.size());
    }

    private static Student findById(int id) {
        for (Student s : students)
            if (s.getId() == id) return s;
        return null;
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid whole number.");
            }
        }
    }

    private static double readMarks() {
        while (true) {
            try {
                System.out.print("Marks (0-100): ");
                double marks = Double.parseDouble(input.nextLine().trim());
                if (marks >= 0 && marks <= 100) return marks;
                System.out.println("Marks must be between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = input.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("This field cannot be empty.");
        }
    }

    private static void loadData() {
        try {
            students.addAll(repository.load());
            System.out.println(students.size() + " saved record(s) loaded.");
        } catch (IOException e) {
            System.out.println("No saved data could be loaded.");
        }
    }

    private static void saveData() {
        try {
            repository.save(students);
            System.out.println("Records saved to students.csv.");
        } catch (IOException e) {
            System.out.println("Could not save records: " + e.getMessage());
        }
    }
}
