package heroes;

import utilities.RandomNumber;

/**
 * Fighter class with health, armor and attack.
 * He can attack other fighters.
 * When fighter attacks he deals damage to another fighter.
 * If the attacked fighter has armor his armor points went down after the attack.
 * If fighter is left with no armor points next attack he will take damage to  his health points.
 * When creating your fighter you can NOT set your health, armor or attack points to negative number.
 */
public abstract class Fighter {
    private String name;

    private int health;

    private int armor;

    private int attack;

    /**
     * Fighter with 3 parameters.
     *
     * @param health Stores fighter's health.
     * @param attack Stores fighter's attack points.
     * @param armor  Stores fighters' armor points.
     */
    public Fighter(String name, int health, int attack, int armor) {
        setName(name);
        setHealth(health);
        setAttack(attack);
        setArmor(armor);
    }

    /**
     * A way that fighters attack each other.
     * First check if enemy is able to block the attack.
     * Then calculates if attacker has a chance of doing critical damage.
     * Then fighter does the attack.
     */
    public final void attackEnemy(Fighter enemy) {
        if (enemy.isBlockingPossible()) {
            System.out.println(enemy.getName() + " blocked the attack.");
            return;
        }
        int multiplier = calculateDamageMultiplier();

        baseAttack(enemy, multiplier);
    }

    /**
     * Normal attack where fighter attacks the enemy.
     *
     * @param enemy      the opponent who we attack.
     * @param multiplier is coefficient that damage dealt is increased.
     */
    public void baseAttack(Fighter enemy, int multiplier) {
        int health = enemy.getHealth();
        int armor = calculateArmorPoints(enemy.getArmor());
        int damage = calculateAttackDamage(getAttack());

        damage = damage * multiplier;

        health -= (damage - armor);
        enemy.setHealth(health);

        System.out.println(getName() + " attacked " + enemy.getName() + " for " +
                (damage - armor) + " damage.");
    }


    /**
     * Checks if increasing damage is possible.
     * If it is possible return the times it is increased
     * If it is not return 1.
     */
    public abstract int calculateDamageMultiplier();

    /**
     * Calculates the damage after processing it with the percentage between 80% and 120%.
     */
    public int calculateAttackDamage(int damage) {
        double percentage = generatePercentage();
        return (int) (damage * percentage);
    }

    /**
     * Calculates armor after processing it with the percentage between 80% and 120%.
     */
    public int calculateArmorPoints(int armor) {
        double percentage = generatePercentage();
        return (int) (armor * percentage);
    }

    /**
     * @return percentage between 80% and 120%.
     */
    public double generatePercentage() {
        return (RandomNumber.generateRandomNumber(80, 120)) / 100;
    }

    public boolean isBlockingPossible() {
        return false;
    }

    public boolean isDamageIncreasePossible() {
        return false;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name can't be empty!");
        }
        this.name = name;
    }

    /**
     * Updates fighters health.
     */
    public void setHealth(int health) {
        if (health <= 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public void setArmor(int armor) {
        if (armor <= 0) {
            throw new IllegalArgumentException("Armor can't be negative number!");
        }
        this.armor = armor;
    }

    public void setAttack(int attack) {
        if (attack <= 0) {
            throw new IllegalArgumentException("Attack can't be negative number!");
        }
        this.attack = attack;
    }
}
