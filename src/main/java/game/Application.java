package game;

import heroes.*;

public class Application {

    public static void main(String[] args) {
        Fighter monk = new Monk("Wukong",450, 80, 45);
        Fighter assassin = new Assassin("Eivor",350, 75, 35);
        Fighter warrior = new Warrior("John Wick", 550, 85, 55);
        Fighter knight = new Knight("Moon Knight", 400, 80, 50);

        //Fight 1
        System.out.println("Fight one:");
        GameEngine fight1 = new GameEngine(monk, assassin);
        fight1.startBattle();

        //Fight 2
        System.out.println(("Fight two:"));
        GameEngine fight2 = new GameEngine(warrior, knight);
        fight2.startBattle();
    }
}
