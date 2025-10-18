import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testCalculateAverage() {
        Student s = new Student("Alice", 3);
        s.setMarks(new int[]{90, 80, 70});
        assertEquals(80.0, s.calculateAverage(), 0.0001);
    }

    @Test
    void testCalculateGradeA() {
        Student s = new Student("Bob", 4);
        s.setMarks(new int[]{95, 92, 90, 93});
        assertEquals("A", s.calculateGrade());
    }

    @Test
    void testCalculateGradeB() {
        Student s = new Student("Chris", 2);
        s.setMarks(new int[]{80, 76});
        assertEquals("B", s.calculateGrade());
    }

    @Test
    void testCalculateGradeFAndZero() {
        Student s = new Student("Dave", 1);
        s.setMarks(new int[]{0});
        assertEquals(0.0, s.calculateAverage(), 0.0001);
        assertEquals("F", s.calculateGrade());
    }
}
