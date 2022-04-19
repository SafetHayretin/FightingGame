package eu.deltasorce.internship.fightinggame.heroes;


import eu.deltasorce.internship.fightinggame.utilities.RandomNumberGenerator;

public class Monk extends Fighter {

    public Monk(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateDamageMultiplier() {
        return 1;
    }

    /**
     * Checks if blocking is possible.
     * Knight has 30% chance of blocking incoming attacks.
     *
     * @return True if he blocks the attack.
     */
    @Override
    public boolean isBlockingAttack() {
        int blockPercentage = 30;
        return RandomNumberGenerator.generateNumberFromOneToHundred() <= blockPercentage;
    }
}
