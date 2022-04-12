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
     */
    public void attackMove(Fighter fighter) {
        int health = fighter.getHealth();
        int armor = calculatesArmorPoints(fighter.getArmor());
        int damage = calculatesAttackDamage(getAttack());

        health -= (damage-armor);
        fighter.setHealth(health);
    }

    /**
     * Calculates the damage after processing it with the percentage between 80% and 120%
     *
     * @param damage
     * @return
     */
    public int calculatesAttackDamage(int damage){
        RandomGenerator generator = new RandomGenerator();
        double percentage = (generator.generateRandomNumber()+80)/100;
        return (int)(damage*percentage);
    }

    public int calculatesArmorPoints(int armor){
        RandomGenerator generator = new RandomGenerator();
        double percentage = (generator.generateRandomNumber()+80)/100;
        return (int)(armor*percentage);
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
