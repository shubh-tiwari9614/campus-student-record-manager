public class Student {
    private final int id;
    private String name;
    private String course;
    private double marks;

    public Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }

    public void update(String name, String course, double marks) {
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String toCsv() {
        return id + "," + name.replace(",", " ") + "," +
               course.replace(",", " ") + "," + marks;
    }

    @Override
    public String toString() {
        return String.format("%-6d %-22s %-18s %7.2f",
                id, name, course, marks);
    }
}
