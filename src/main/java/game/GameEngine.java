package game;

import heroes.Fighter;

/**
 * Game engine where the battle begins
 * We create 2 fighters and the start attacking each other
 */
public class GameEngine {
    Fighter player1;
    Fighter player2;

    public GameEngine(Fighter player1, Fighter player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * The battle starts and it goes till one of the player dies
     * If their health goes to 0 the battle ends
     */
    public void startBattle(){
        while(true){
            if(player1.getHealth() == 0 || player2.getHealth() == 0){
                break;
            }
            player1.attackEnemy(player2);
            player2.attackEnemy(player1);
        }
    }
}
