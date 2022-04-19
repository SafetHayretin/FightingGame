package eu.deltasorce.internship.fightinggame.heroes;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class AssassinTest {

    @RepeatedTest(30)
    void warriorHealthShouldBeBetween0And70() {
        //Given
        Fighter assassin = new Assassin("Eivor", 120, 50, 25);
        Fighter warrior = new Warrior("Kung Fu Panda", 80, 45, 20);
        int minHealth = 0;
        int maxHealth = 70;

        //When
        assassin.attackEnemy(warrior);

        //Then
        assertTrue(minHealth <= warrior.getHealth() && warrior.getHealth() <= maxHealth);
    }
}