package heroes;

import utilities.RandomNumber;

public class Knight extends Fighter {

    public Knight(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateDamageMultiplier() {
        if (isDamageIncreasePossible()) {
            return 2;
        }
        return 1;
    }


    /**
     * Checks if critical attack is possible.
     * Knight has 30% chance of activate critical attack.
     *
     * @return True if fighter can do critical damage.
     */
    public boolean isDamageIncreasePossible() {
        int randomNumber = RandomNumber.generateRandomNumber(100);
        if (randomNumber <= 30) {
            return true;
        }
        return false;
    }

    /**
     * Checks if blocking is possible.
     * Knight has 20% chance of blocking incoming attacks.
     *
     * @return True if he blocks the attack.
     */
    @Override
    public boolean isBlockingPossible() {
        int randomNumber = RandomNumber.generateRandomNumber(100);
        if (randomNumber <= 20) {
            return true;
        }
        return false;
    }
}
