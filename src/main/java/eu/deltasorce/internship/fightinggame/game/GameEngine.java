package eu.deltasorce.internship.fightinggame.game;

import eu.deltasorce.internship.fightinggame.heroes.Fighter;

/**
 * Game engine where the battle begins.
 * We create 2 fighters and the start attacking each other.
 */
public class GameEngine {
    /**
     * The battle starts, it goes till one of the player dies.
     * If their health goes to 0 the battle ends.
     */
    public void startTheFight(Fighter player1, Fighter player2) {
        while (isFighterAlive(player1) && isFighterAlive(player2)) {
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
    public boolean isFighterAlive(Fighter player) {
        return player.getHealth() > 0;
    }
}
