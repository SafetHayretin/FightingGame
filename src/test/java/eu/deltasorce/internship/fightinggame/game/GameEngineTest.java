package eu.deltasorce.internship.fightinggame.game;

import eu.deltasorce.internship.fightinggame.heroes.Assassin;
import eu.deltasorce.internship.fightinggame.heroes.Fighter;
import eu.deltasorce.internship.fightinggame.heroes.Monk;
import eu.deltasorce.internship.fightinggame.heroes.Warrior;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    @RepeatedTest(30)
    void assassinShouldWinTheBattleAndHisHeathShouldBeZero(){
        //Given
        GameEngine engine = new GameEngine();
        Fighter assassin = new Assassin("Eivor", 120, 50, 25);
        Fighter warrior = new Warrior("KungFu Panda", 25, 45, 5);

        //When
        engine.startTheFight(assassin, warrior);

        //Then
        assertEquals(0, warrior.getHealth());
    }

    @Test
    void monkShouldBeAbleToKillEnemy(){
        //Given
        GameEngine engine = new GameEngine();
        Fighter monk = new Monk("Monk", 120, 50, 25);
        Fighter warrior = new Warrior("KungFu Panda", 25, 45, 5);

        //When
        engine.startTheFight(monk, warrior);

        //Then
        assertEquals(0, warrior.getHealth());
    }

    @Test
    void warriorShouldBeAbleToKillEnemy(){
        //Given
        GameEngine engine = new GameEngine();
        Fighter monk = new Monk("Monk", 25, 25, 15);
        Fighter warrior = new Warrior("KungFu Panda", 125, 45, 5);

        //When
        engine.startTheFight(monk, warrior);

        //Then
        assertEquals(0, monk.getHealth());
    }
}