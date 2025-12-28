import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {
    @Test
    public void testHello() {
        Hello hello = new Hello();
        assertEquals("Hello, World!", hello.greet());
    }
}