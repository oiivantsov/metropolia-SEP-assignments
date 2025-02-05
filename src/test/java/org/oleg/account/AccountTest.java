package org.oleg.account;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void testInitialBalance() {
        assertEquals(0.0, account.getBalance(), "initially balance should be 0");
    }

    @Test
    void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), "should be 100 after depositing 100");
    }

    @Test
    void testWithdrawValidAmount() {
        account.deposit(200.0);
        double withdrawn = account.withdraw(150.0);
        assertEquals(150.0, withdrawn, "should be 150");
        assertEquals(50.0, account.getBalance(), "should be 50 after withdrawing 150 from 200");
    }

    @Test
    void testWithdrawInvalidAmount() {
        account.deposit(100.0);
        double withdrawn = account.withdraw(200.0);
        assertEquals(0.0, withdrawn, "0 when trying to withdraw more than balance");
        assertEquals(100.0, account.getBalance(), "unchanged when withdrawal fails");
    }

    @Test
    void testNegativeDeposit() {
        account.deposit(-50.0);
        assertEquals(0.0, account.getBalance(), "no change when depositing a neg amount");
    }

    @Test
    void testNegativeWithdraw() {
        account.deposit(100.0);
        double withdrawn = account.withdraw(-30.0);
        assertEquals(0.0, withdrawn, "0 for negative withdrawal requests");
        assertEquals(100.0, account.getBalance(), "unchanged when trying to withdraw a neg amount");
    }
}
