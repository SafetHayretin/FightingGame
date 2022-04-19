package eu.deltasorce.internship.fightinggame.heroes;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @RepeatedTest(30)
    void warriorHealthShouldBeZero() {
        //Given
        Fighter assassin = new Assassin("Eivor", 120, 50, 25);
        Fighter warrior = new Warrior("KungFu Panda", 25, 45, 5);

        //When
        assassin.attackEnemy(warrior);

        //Then
        assertEquals(0, warrior.getHealth());
    }

}