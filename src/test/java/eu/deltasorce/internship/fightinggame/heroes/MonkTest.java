package eu.deltasorce.internship.fightinggame.heroes;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class MonkTest {

    @RepeatedTest(30)
    void monkHealthShouldStayBetween0And120() {
        //Given
        Fighter monk = new Monk("Monk", 120, 50, 25);
        Fighter knight = new Knight("HorseMan", 120, 45, 5);
        int minHealth = 0;
        int maxHealth = 120;

        //When
        knight.attackEnemy(monk);

        //Then
        assertTrue(minHealth <= monk.getHealth() && monk.getHealth() <= maxHealth);
    }
}