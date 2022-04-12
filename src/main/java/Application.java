import Game.GameEngine;
import Heroes.Assassin;
import Heroes.Fighter;
import Heroes.Monk;

public class Application {

    public static void main(String[] args) {
        Fighter monk = new Monk(450, 80, 45);
        Fighter assassin = new Assassin(350, 75, 35);

        GameEngine engine = new GameEngine(monk, assassin);
        engine.startBattle();
    }
}
