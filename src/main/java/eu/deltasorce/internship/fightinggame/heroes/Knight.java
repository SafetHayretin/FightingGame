package eu.deltasorce.internship.fightinggame.heroes;


import eu.deltasorce.internship.fightinggame.utilities.RandomNumber;

public class Knight extends Fighter {

    public Knight(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    @Override
    public int calculateDamageMultiplier() {
        if (isCriticalAttack()) {
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
    public boolean isCriticalAttack() {
        int criticalPercentage = 20;
        return RandomNumber.generatePercentage() <= criticalPercentage;
    }

    /**
     * Checks if blocking is possible.
     * Knight has 20% chance of blocking incoming attacks.
     *
     * @return True if he blocks the attack.
     */
    @Override
    public boolean isBlockingPossible() {
        int blockPercentage = 20;
        return RandomNumber.generatePercentage() <= blockPercentage;
    }
}
