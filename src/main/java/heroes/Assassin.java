package heroes;

import utilities.RandomNumber;

public class Assassin extends Fighter {

    public Assassin(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateDamageMultiplier() {
        if (isDamageIncreasePossible()) {
            return 3;
        }
        return 1;
    }


    /**
     * Fighter has 30% chance of dealing critical damage.
     *
     * @return True if critical damage is possible.
     */
    public boolean isDamageIncreasePossible() {
        int randomNumber = RandomNumber.generateRandomNumber(100);
        if (randomNumber <= 30) {
            return true;
        }
        return false;
    }


}
