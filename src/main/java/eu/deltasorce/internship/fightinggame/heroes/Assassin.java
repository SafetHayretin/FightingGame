package eu.deltasorce.internship.fightinggame.heroes;

import static eu.deltasorce.internship.fightinggame.utilities.RandomNumberGenerator.generateNumberFromOneToHundred;

public class Assassin extends Fighter {

    public Assassin(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * {@inheritDoc}
     * If fighter does critical, he triples the damage.
     */
    @Override
    public int calculateDamageMultiplier() {
        return isCriticalAttack() ? 3 : 1;
    }

    /**
     * Fighter has 30% chance of dealing critical damage.
     *
     * @return True if critical damage is possible.
     */
    public boolean isCriticalAttack() {
        int criticalPercentage = 30;
        return generateNumberFromOneToHundred() <= criticalPercentage;
    }
}
