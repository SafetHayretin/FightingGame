package eu.deltasorce.internship.fightinggame.heroes;

import static eu.deltasorce.internship.fightinggame.utilities.RandomNumberGenerator.generateRandomNumber;

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
     * Fighter with 4 parameters.
     *
     * @param name   Store fighter's name.
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
        if (enemy.isBlockingAttack()) {
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
    private void baseAttack(Fighter enemy, int multiplier) {
        int healthOfTheAttackedHero = enemy.getHealth();
        int armorOfTheAttackedHero = calculatePoints(enemy.getArmor());
        int damageOfTheAttacker = calculatePoints(getAttack());

        damageOfTheAttacker = calculateCriticalDamage(damageOfTheAttacker, multiplier);

        enemy.updateFighterHealthPoints(healthOfTheAttackedHero, damageOfTheAttacker, armorOfTheAttackedHero);

        System.out.println(getName() + " attacked " + enemy.getName() + " for " +
                (damageOfTheAttacker - armorOfTheAttackedHero) + " damage. " + "Health left: " + enemy.getHealth());
    }

    public int calculateCriticalDamage(int damage, int multiplier) {
        return damage * multiplier;
    }

    /**
     * Checks if increasing damage is possible.
     * If it is possible return the times it is increased
     * If it is not return 1.
     */
    protected abstract int calculateDamageMultiplier();

    /**
     * Calculates points after processing it with the percentage between 80% and 120%.
     */
    public int calculatePoints(int points) {
        double percentage = calculatePercentage();
        return (int) (points * percentage);
    }

    /**
     * @return percentage between 80% and 120%.
     */
    public double calculatePercentage() {
        return (double) generateRandomNumber(80, 120) / 100;
    }

    protected boolean isBlockingAttack() {
        return false;
    }

    public void updateFighterHealthPoints(int health, int damage, int armor) {
        health = health - (damage - armor);
        this.health = Math.max(health, 0);
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
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty!");
        }
        this.name = name;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            throw new IllegalArgumentException("Health can't be negative number or zero!");
        }
        this.health = health;
    }

    public void setArmor(int armor) {
        if (armor <= 0) {
            throw new IllegalArgumentException("Armor can't be negative number or zero!");
        }
        this.armor = armor;
    }

    public void setAttack(int attack) {
        if (attack <= 0) {
            throw new IllegalArgumentException("Attack can't be negative number or zero!");
        }
        this.attack = attack;
    }
}
