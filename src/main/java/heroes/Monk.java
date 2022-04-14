package heroes;

public class Monk extends Fighter {
    /**
     * Heroes.Fighter with 3 parameters
     *
     * @param health can't be negative
     * @param attack can't be negative
     * @param armor  can't be negative
     */
    public Monk(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    @Override
    public void attackEnemy(Fighter enemy) {
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
