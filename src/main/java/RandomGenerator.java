import java.util.Random;

public class RandomGenerator {
    Random random = new Random();

    /**
     * Generates random number between 0 and 40
     */
    public double generateRandomNumber(){
        return  random.nextInt(41);
    }
}
