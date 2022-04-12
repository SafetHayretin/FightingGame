package Heroes;

import Extras.RandomNumber;

public class Assassin extends Fighter {
    String type = "Assassin";

    /**
     * Heroes.Fighter with 3 parameters
     *
     * @param health can't be negative
     * @param attack can't be negative
     * @param armor  can't be negative
     */
    public Assassin(int health, int attack, int armor) {
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

        if(isDamageIncreasePossible()){
            damage = damage * 3;
        }

        health -= (damage-armor);
        enemy.setHealth(health);
    }

    public boolean isDamageIncreasePossible(){
        int randomNumber = RandomNumber.generateRandomNumber(100);
        if(randomNumber < 30){
            return true;
        }
        return false;
    }

}
