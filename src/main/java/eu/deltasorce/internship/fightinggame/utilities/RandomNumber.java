package eu.deltasorce.internship.fightinggame.utilities;

import java.util.Random;

public class RandomNumber {

    static Random random = new Random();

    /**
     * Generates random number between two numbers.
     */
    public static double generateRandomNumber(int min, int max) {
        return random.nextInt(max+1) + min;
    }

    /**
     * Generate random number to 100 for percentage.
     */
    public static int generatePercentage(){
        return random.nextInt(101);
    }
}
