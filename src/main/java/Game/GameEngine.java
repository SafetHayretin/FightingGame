package Game;

import Heroes.Fighter;

public class GameEngine {
    Fighter player1;
    Fighter player2;

    public GameEngine(Fighter player1, Fighter player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    public void startBattle(){
        while(true){
            if(player1.getHealth() <= 0 || player2.getHealth() <= 0){
                break;
            }
            player1.attackMove(player2);
            player2.attackMove(player1);
        }
    }
}
