package eu.deltasorce.internship.fightinggame;

import eu.deltasorce.internship.fightinggame.game.GameEngine;
import eu.deltasorce.internship.fightinggame.heroes.*;

public class Application {

    public static void main(String[] args) {
        Fighter monk = new Monk("Wu-kong", 500, 80, 45);
        Fighter assassin = new Assassin("Eivor", 350, 75, 35);
        Fighter warrior = new Warrior("John Wick", 550, 85, 45);
        Fighter knight = new Knight("Moon Knight", 400, 80, 40);

        GameEngine engine = new GameEngine();

        //Fight 1
        System.out.println("Fight one:");
        engine.startTheFight(assassin, knight);

        //Fight 2
        System.out.println(("Fight two:"));
        engine.startTheFight(monk, warrior);
    }
}
