package utilities;

import java.util.Random;

public class RandomNumber {
    static Random random = new Random();

    /**
     * Generates random number
     */
    public static int generateRandomNumber(int max) {
        return random.nextInt(max+1);
    }

    /**
     * Generates random number between two numbers
     */
    public static double generateRandomNumber(int min, int max) {
        return random.nextInt(max+1) + min;
    }
}
