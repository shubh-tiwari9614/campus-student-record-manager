import java.io.*;
import java.util.ArrayList;

public class StudentRepository {
    private static final String FILE_NAME = "students.csv";

    public void save(ArrayList<Student> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("id,name,course,marks");
            writer.newLine();
            for (Student s : students) {
                writer.write(s.toCsv());
                writer.newLine();
            }
        }
    }

    public ArrayList<Student> load() throws IOException {
        ArrayList<Student> result = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return result;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean header = true;
            while ((line = reader.readLine()) != null) {
                if (header) { header = false; continue; }
                if (line.isBlank()) continue;

                String[] p = line.split(",", -1);
                if (p.length != 4) continue;

                try {
                    int id = Integer.parseInt(p[0].trim());
                    double marks = Double.parseDouble(p[3].trim());
                    result.add(new Student(id, p[1].trim(), p[2].trim(), marks));
                } catch (NumberFormatException ignored) {
                    // Skip malformed records.
                }
            }
        }
        return result;
    }
}
