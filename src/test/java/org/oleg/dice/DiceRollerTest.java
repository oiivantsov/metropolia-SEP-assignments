package org.oleg.dice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiceRollerTest {
    private DiceRoller roller;

    @BeforeEach
    void setUp() {
        roller = new DiceRoller();
    }

    @Test
    void testRollDie() {
        for (int i = 0; i < 100; i++) {
            int roll = roller.rollDie();
            assertTrue(roll >= 1 && roll <= 6, "die roll should be between 1 and 6");
        }
    }

    @Test
    void testIsDouble() {
        assertTrue(roller.isDouble(3, 3), "return true for matching dice");
        assertFalse(roller.isDouble(2, 5), "return false for non-matching dice");
    }

    @Test
    void testRollUntilDouble() {
        int attempts = roller.rollUntilDouble();
        assertTrue(attempts > 0, "take at least 1 attempt to roll a double");
    }
}
