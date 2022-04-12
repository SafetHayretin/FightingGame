package Heroes;

import Extras.RandomNumber;

/**
 * Heroes.Fighter class with health, armor and attack.
 * He can attack other fighters.
 * When fighter attacks he deals damage to another fighter.
 * If the attacked fighter has armor his armor points went down after the attack.
 * If fighter is left with no armor points next attack he will take damage to  his health points.
 * When creating your fighter you can NOT set your health, armor or attack points to negative number.
 */
public abstract class Fighter {
    private int health;
    private int armor;
    private final int ATTACK;

    /**
     * Heroes.Fighter with 3 parameters
     * @param health can't be negative
     * @param attack can't be negative
     * @param armor can't be negative
     */
    public Fighter(int health, int attack, int armor) {
        if(health < 0 || attack < 0 || armor < 0){
            throw new IllegalArgumentException("Can't assign negative parameters!");
        }
        this.health = health;
        this.ATTACK = attack;
        this.armor = armor;
    }

    /**
     * Every children class must have way to attack enemy
     */
    public abstract void attackMove(Fighter enemy);

    /**
     * Calculates the damage after processing it with the percentage between 80% and 120%
     */
    public int calculatesAttackDamage(int damage){
        double percentage = (RandomNumber.generateRandomNumber()+80)/100;
        return (int)(damage*percentage);
    }

    /**
     * Calculates armor after processing it with the percentage between 80% and 120%
     */
    public int calculatesArmorPoints(int armor){
        double percentage = (RandomNumber.generateRandomNumber()+80)/100;
        return (int)(armor*percentage);
    }

    public boolean isBlockingPossible(){
        return false;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return ATTACK;
    }

    public int getArmor() {
        return armor;
    }

    /**
     * Updates your health
     * Can't be negative
     */
    public void setHealth(int health) {
        if (health <= 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }
}
