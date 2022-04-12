package Heroes;

import Heroes.Fighter;

public class Monk extends Fighter {
    String type = "Monk";

    /**
     * Heroes.Fighter with 3 parameters
     *
     * @param health can't be negative
     * @param attack can't be negative
     * @param armor  can't be negative
     */
    public Monk(int health, int attack, int armor) {
        super(health, attack, armor);
    }

    @Override
    public void attackMove(Fighter enemy) {
        if(enemy.isBlockingPossible()){
            return;
        }

        int health = enemy.getHealth();
        int armor = calculatesArmorPoints(enemy.getArmor());
        int damage = calculatesAttackDamage(getAttack());

        health -= (damage-armor);
        enemy.setHealth(health);
    }
}
