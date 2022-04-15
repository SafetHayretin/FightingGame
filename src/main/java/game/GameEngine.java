package game;

import heroes.Fighter;

/**
 * Game engine where the battle begins.
 * We create 2 fighters and the start attacking each other.
 */
public class GameEngine {
    private final Fighter player1;
    private final Fighter player2;

    public GameEngine(Fighter player1, Fighter player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * The battle starts and it goes till one of the player dies.
     * If their health goes to 0 the battle ends.
     */
    public void startBattle() {
        while (isFighterAlive()) {
            player1.attackEnemy(player2);
            player2.attackEnemy(player1);
            System.out.println();
        }
        System.out.println(player1.getName() + " " + player1.getHealth());
        System.out.println(player2.getName() + " " + player2.getHealth());
        System.out.println();
    }

    /**
     * Checks if fighters are alive.
     *
     * @return True if nobody is dead.
     */
    public boolean isFighterAlive() {
        return player1.getHealth() > 0 && player2.getHealth() > 0;
    }
}
