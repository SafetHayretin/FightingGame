package eu.deltasorce.internship.fightinggame.heroes;


import eu.deltasorce.internship.fightinggame.utilities.RandomNumber;

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
        if (isCriticalAttack()) {
            return 3;
        }
        return 1;
    }

    /**
     * Fighter has 30% chance of dealing critical damage.
     *
     * @return True if critical damage is possible.
     */
    public boolean isCriticalAttack() {
        int criticalPercentage = 30;
        return RandomNumber.generatePercentage() <= criticalPercentage;
    }


}
