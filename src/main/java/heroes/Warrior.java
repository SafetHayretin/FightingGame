package heroes;

public class Warrior extends Fighter {

    public Warrior(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateDamageMultiplier() {
        return 1;
    }


}
