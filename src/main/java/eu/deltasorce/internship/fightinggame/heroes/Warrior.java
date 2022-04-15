package eu.deltasorce.internship.fightinggame.heroes;

public class Warrior extends Fighter {

    public Warrior(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * {@inheritDoc}
     * Doesn't have the ability to do critical.
     */
    @Override
    public int calculateDamageMultiplier() {
        return 1;
    }


}
