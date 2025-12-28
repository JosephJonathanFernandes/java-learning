package examples;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class BankAccountSystemIntegrationTest {
  @Test
  void testBankAccountSystemDepositWithdraw() {
    // Simulate user input: name, deposit, deposit, withdraw, view, exit
    String simulatedInput = "TestUser\n100\n1\n50\n2\n30\n3\n4\n";
    InputStream originalIn = System.in;
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    try {
      com.example.learningjava.examples.BankAccountSystem.main(new String[] {});
      // No exception = pass (for demo; real test would capture output)
    } finally {
      System.setIn(originalIn);
    }
  }
}
