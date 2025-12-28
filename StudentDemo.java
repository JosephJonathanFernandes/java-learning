import com.example.learningjava.model.Student;

public class StudentDemo {
    public static void main(String[] args) {
        // Create a Student instance with name and number of subjects
        Student student = new Student("Alice", 3);

        // Set marks for the subjects
        student.setMarks(new int[]{90, 85, 88});

        // Calculate and display the grade
        System.out.println("Student: " + student.getName());
        System.out.println("Average: " + student.calculateAverage());
        System.out.println("Grade: " + student.calculateGrade());
    }
}
