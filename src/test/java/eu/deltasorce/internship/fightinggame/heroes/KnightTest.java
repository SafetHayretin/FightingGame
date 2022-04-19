package eu.deltasorce.internship.fightinggame.heroes;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @RepeatedTest(30)
    void knightHealthShouldStayBetween0And120() {
        //Given
        Fighter assassin = new Assassin("Eivor", 120, 50, 25);
        Fighter knight = new Knight("HorseMan", 120, 45, 5);
        int minHealth = 0;
        int maxHealth = 120;

        //When
        assassin.attackEnemy(knight);

        //Then
        assertTrue(minHealth <= knight.getHealth() && knight.getHealth() <= maxHealth);
    }

    @RepeatedTest(30)
    void warriorHealthShouldBeBetween0And70() {
        //Given
        Fighter knight = new Knight("Prince of Persia", 120, 50, 25);
        Fighter warrior = new Warrior("Kung Fu Panda", 80, 45, 20);
        int minHealth = 0;
        int maxHealth = 70;

        //When
        knight.attackEnemy(warrior);

        //Then
        assertTrue(minHealth <= warrior.getHealth() && warrior.getHealth() <= maxHealth);
    }
}