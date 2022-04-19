package eu.deltasorce.internship.fightinggame.game;

import eu.deltasorce.internship.fightinggame.heroes.Fighter;

/**
 * Game engine where the battle begins.
 * We create 2 fighters, they start attacking each other.
 * The only purpose of the class is to simulate fighting battle between 2 fighters.
 * It has one method that simulates the battle.
 * It has method that checks if player is still alive.
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

        if (isFighterAlive(player1)) {
            System.out.println(player1.getName() + " won the battle!");
        } else if (isFighterAlive(player2)) {
            System.out.println(player2.getName() + " won the battle!");
        } else System.out.println("Nobody won! It's draw.");
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
