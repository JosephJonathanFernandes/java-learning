package service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.learningjava.model.Account;
import com.example.learningjava.model.SavingsAccount;
import org.junit.jupiter.api.Test;

class AccountServiceTest {
  @Test
  void transferMovesFundsBetweenAccounts() {
    Account from = new Account("From", 200.0);
    Account to = new Account("To", 50.0);
    SavingsAccount svc = new SavingsAccount();
    svc.transfer(from, to, 100.0);
    assertEquals(100.0, from.getBalance(), 0.001);
    assertEquals(150.0, to.getBalance(), 0.001);
  }

  @Test
  void transferThrowsOnInvalidAmount() {
    Account from = new Account("From", 100.0);
    Account to = new Account("To", 100.0);
    SavingsAccount svc = new SavingsAccount();
    Exception ex =
        assertThrows(IllegalArgumentException.class, () -> svc.transfer(from, to, -10.0));
    assertTrue(ex.getMessage().contains("positive"));
  }
}
