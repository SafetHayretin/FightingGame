package Extras;

import java.util.Random;

public class RandomNumber {
    static Random random = new Random();

    /**
     * Generates random number
     */
    public static int generateRandomNumber(int upperBound){
        return  random.nextInt(upperBound);
    }

    /**
     * Generates random number with prefixed upperBound
     */
    public static double generateRandomNumber(){
        return  random.nextInt(41);
    }
}
