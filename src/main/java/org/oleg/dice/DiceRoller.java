package org.oleg.dice;

import java.util.Random;

public class DiceRoller {
    private Random random;

    public DiceRoller() {
        this.random = new Random();
    }

    public int rollDie() {
        return random.nextInt(6) + 1;
    }

    public boolean isDouble(int die1, int die2) {
        return die1 == die2;
    }

    public int rollUntilDouble() {
        int attempts = 0;
        int die1, die2;
        do {
            die1 = rollDie();
            die2 = rollDie();
            attempts++;
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
        } while (!isDouble(die1, die2));

        System.out.println("You rolled a double!");
        System.out.println("After " + attempts + " tries, both dice reached the same value.");
        return attempts;
    }

    public static void main(String[] args) {
        System.out.println("Rolling the dice...");
        DiceRoller roller = new DiceRoller();
        roller.rollUntilDouble();
    }
}
