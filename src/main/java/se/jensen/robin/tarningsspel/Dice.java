package se.jensen.robin.tarningsspel;

import java.util.Random;

public class Dice {

    int roll = 0;

    public int rollDice() {
        Random random = new Random();
        return roll = random.nextInt(1, 7);
    }

    public int getRoll() {
        return roll;
    }
}
