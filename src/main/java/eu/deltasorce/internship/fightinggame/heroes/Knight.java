package eu.deltasorce.internship.fightinggame.heroes;

import static eu.deltasorce.internship.fightinggame.utilities.RandomNumberGenerator.generateNumberFromOneToHundred;

/**
 * Knight is fighter who has some base stats and special abilities like blocking damage and doing critical damage.
 * He has 20% chance of blocking damage.
 * He has 10% chance of doing critical damage.
 */
public class Knight extends Fighter {

    public Knight(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    @Override
    public int calculateDamageMultiplier() {
        return isCriticalAttack() ? 2 : 1;
    }

    /**
     * Checks if critical attack is possible.
     * Knight has 10% chance of activate critical attack.
     *
     * @return True if fighter can do critical damage.
     */
    public boolean isCriticalAttack() {
        int criticalPercentage = 10;
        return generateNumberFromOneToHundred() <= criticalPercentage;
    }

    /**
     * Checks if blocking is possible.
     * Knight has 20% chance of blocking incoming attacks.
     *
     * @return True if he blocks the attack.
     */
    @Override
    public boolean isBlockingAttack() {
        int blockPercentage = 20;
        return generateNumberFromOneToHundred() <= blockPercentage;
    }
}
