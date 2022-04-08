/**
 * Fighter class with health, armor and attack.
 * He can attack other fighters.
 * When fighter attacks he deals damage to another fighter.
 * If the attacked fighter has armor his armor points went down after the attack.
 * If fighter is left with no armor points next attack he will take damage to  his health points.
 * When creating your fighter you can NOT set your health, armor or attack points to negative number.
 */
public class Fighter {
    private int health;
    private int armor;
    private final int ATTACK;

    /**
     * Fighter with 3 parameters
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
     * A way that your fighter attacks the opponent
     * @param fighter
     */
    public void attackMove(Fighter fighter) {
        int health = fighter.getHealth();
        int armor = fighter.getArmor();
        int damage = getAttack();

        if (isArmorBroken()) {
            health -= damage;
            fighter.setHealth(health);
        } else {
            armor -= damage;
            fighter.setArmor(armor);

            if (armor < 0) {
                health += armor;
                fighter.setHealth(health);
            }
        }
    }

    /**
     * Checker if your fighter's armor is broken
     * If your armor is broken
     * @return true
     */
    public boolean isArmorBroken() {
        if (armor <= 0) {
            return true;
        } else return false;
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

    /**
     * Updates your armor
     * Can't be negative
     */
    public void setArmor(int armor) {
        if (armor <= 0) {
            this.armor = 0;
        } else {
            this.armor = armor;
        }
    }
}
