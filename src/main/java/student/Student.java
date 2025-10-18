package student;

public class Student {
    private String name;
    private int[] marks;

    public Student(String name, int subjects) {
        this.name = name;
        this.marks = new int[subjects];
    }

    public void setMarks(int[] marks) {
        if (marks == null) throw new IllegalArgumentException("marks cannot be null");
        this.marks = marks.clone();
    }

    public double calculateAverage() {
        if (marks == null || marks.length == 0) return 0.0;
        int total = 0;
        for (int m : marks) total += m;
        return total / (double) marks.length;
    }

    public String calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }

    public String getName() {
        return name;
    }
}
