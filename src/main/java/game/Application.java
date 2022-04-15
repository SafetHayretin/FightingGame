package game;

import heroes.*;

public class Application {

    public static void main(String[] args) {
        Fighter monk = new Monk("Wukong", 500, 80, 45);
        Fighter assassin = new Assassin("Eivor", 350, 75, 35);
        Fighter warrior = new Warrior("John Wick", 550, 85, 45);
        Fighter knight = new Knight("Moon Knight", 400, 80, 40);

        //Fight 1
        System.out.println("Fight one:");
        GameEngine fight1 = new GameEngine(knight, assassin);
        fight1.startBattle();

        //Fight 2
        System.out.println(("Fight two:"));
        GameEngine fight2 = new GameEngine(warrior, monk);
        fight2.startBattle();
    }
}
