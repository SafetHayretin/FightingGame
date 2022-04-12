package Heroes;

import Heroes.Fighter;

public class Warrior extends Fighter {
    String type = "Warrior";

    /**
     * Heroes.Fighter with 3 parameters
     *
     * @param health can't be negative
     * @param attack can't be negative
     * @param armor  can't be negative
     */
    public Warrior(int health, int attack, int armor) {
        super(health, attack, armor);
    }

    /**
     * A way that your fighter attacks the opponent
     */
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
