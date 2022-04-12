package Heroes;

import Extras.RandomNumber;
import Heroes.Fighter;

public class Knight extends Fighter{
    String type = "Knight";

    /**
     * Heroes.Fighter with 3 parameters
     * @param health can't be negative
     * @param attack can't be negative
     * @param armor  can't be negative
     */
    public Knight(int health, int attack, int armor) {
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
            damage = damage * 2;
        }

        health -= (damage-armor);
        enemy.setHealth(health);
    }

    public boolean isDamageIncreasePossible(){
        int randomNumber = RandomNumber.generateRandomNumber(10);
        if(randomNumber == 3){
            return true;
        }
        return false;
    }

    @Override
    public boolean isBlockingPossible(){
        int randomNumber = RandomNumber.generateRandomNumber(5);
        if(randomNumber == 3) {
            return true;
        }
        return false;
    }
}
