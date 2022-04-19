package eu.deltasorce.internship.fightinggame.heroes;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {

    @Test
    void nameShouldThrowIllegalArgumentException() {
        //Given
        String name = "";
        int health = 500;
        int attack = 80;
        int armor = 45;

        //When
        Executable nameThrowsIllegalArgument = () -> new Knight(name, health, attack, armor);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void healthShouldThrowIllegalArgumentException() {
        //Given
        String name = "Kung Fu Panda";
        int health = 0;
        int attack = 80;
        int armor = 45;

        //When
        Executable healthThrowsIllegalArgument = () -> new Knight(name, health, attack, armor);

        //Then
        assertThrows(IllegalArgumentException.class, healthThrowsIllegalArgument);
    }

    @Test
    void attackShouldThrowIllegalArgumentException() {
        //Given
        String name = "Kung Fu Panda";
        int health = 500;
        int attack = -85;
        int armor = 45;

        //When
        Executable attackThrowsIllegalArgument = () -> new Knight(name, health, attack, armor);

        //Then
        assertThrows(IllegalArgumentException.class, attackThrowsIllegalArgument);
    }

    @Test
    void armorShouldThrowIllegalArgumentException() {
        //Given
        String name = "Kung Fu Panda";
        int health = 500;
        int attack = 80;
        int armor = -45;

        //When
        Executable armorThrowsIllegalArgument = () -> new Knight(name, health, attack, armor);

        //Then
        assertThrows(IllegalArgumentException.class, armorThrowsIllegalArgument);
    }

    @Test
    void criticalDamageShouldBeNinety() {
        //Given
        Fighter fighter = new Assassin("Kung Fu Panda", 400, 45, 20);
        int damage = 45;
        int multiplier = 2;

        //When
        int criticalDamage = fighter.calculateCriticalDamage(damage, multiplier);

        //Then
        assertEquals(90, criticalDamage);
    }

    @Test
    void calculatedPointsShouldBeBetween80And120() {
        //Given
        Fighter fighter = new Warrior("Kung Fu Panda", 400, 100, 40);
        int minPossibleDamage = 80;
        int maxPossibleDamage = 120;

        //When
        int calculatedDamage = fighter.calculatePoints(fighter.getAttack());

        //Then
        assertTrue(minPossibleDamage <= calculatedDamage && calculatedDamage <= maxPossibleDamage);
    }

    @RepeatedTest(40)
    void generatedPercentageShouldBeBetween80And120() {
        //Given
        Fighter fighter = new Monk("Kung Fu Panda", 400, 100, 40);
        //80%
        double minPercentage = 0.8;
        //120%
        double maxPercentage = 1.2;

        //When
        double percentage = fighter.calculatePercentage();

        //Then
        assertTrue(minPercentage <= percentage && percentage <= maxPercentage);
    }

    @Test
    void healthAfterUpdateShouldBe120() {
        //Given
        Fighter fighter = new Knight("Kung Fu Panda", 400, 100, 40);

        //When
        fighter.updateFighterHealthPoints(120, 80, 80);

        //Then
        assertEquals(120, fighter.getHealth());
    }

    @Test
    void healthAfterUpdateShouldBeZero() {
        //Given
        Fighter fighter = new Assassin("Kung Fu Panda", 400, 100, 40);

        //When
        fighter.updateFighterHealthPoints(40, 80, 25);

        //Then
        assertEquals(0, fighter.getHealth());
    }
}