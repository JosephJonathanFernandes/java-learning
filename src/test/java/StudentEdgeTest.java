import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentEdgeTest {

    @Test
    void testEmptyMarks() {
        Student s = new Student("Empty", 0);
        assertEquals(0.0, s.calculateAverage(), 0.0001);
        assertEquals("F", s.calculateGrade());
    }

    @Test
    void testNegativeMarksHandled() {
        Student s = new Student("Neg", 3);
        s.setMarks(new int[]{-10, 50, 60});
        // Negative marks allowed in this simple model, average should compute arithmetically
        assertEquals(((-10 + 50 + 60) / 3.0), s.calculateAverage(), 0.0001);
    }
}
