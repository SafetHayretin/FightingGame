package eu.deltasorce.internship.fightinggame.utilities;

import java.util.Random;

public final class RandomNumberGenerator {

    static Random random = new Random();

    /**
     * Generates random number between two numbers.
     */
    public static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Generate random number to 100.
     */
    public static int generateNumberFromOneToHundred() {
        return random.nextInt(101);
    }
}
