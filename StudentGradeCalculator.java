import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int subjects) {
        this.name = name;
        this.marks = new int[subjects];
    }

    void inputMarks(Scanner sc) {
        System.out.println("\nEnter marks for " + name + ":");
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    double calculateAverage() {
        int total = 0;
        for (int m : marks) total += m;
        return total / (double) marks.length;
    }

    char calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }

    void displayResult() {
        System.out.println("\n--- Result ---");
        System.out.println("Name: " + name);
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade: " + calculateGrade());
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        Student s = new Student(name, subjects);
        s.inputMarks(sc);
        s.displayResult();

        sc.close();
    }
}
