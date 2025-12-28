package model;

import com.example.learningjava.model.Account;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void depositIncreasesBalance() {
        Account acc = new Account("Test User", 100.0);
        acc.deposit(50.0);
        assertEquals(150.0, acc.getBalance(), 0.001);
    }

    @Test
    void withdrawDecreasesBalance() {
        Account acc = new Account("Test User", 100.0);
        acc.withdraw(40.0);
        assertEquals(60.0, acc.getBalance(), 0.001);
    }

    @Test
    void withdrawThrowsOnInsufficientFunds() {
        Account acc = new Account("Test User", 50.0);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> acc.withdraw(100.0));
        assertTrue(ex.getMessage().contains("Insufficient"));
    }
}
