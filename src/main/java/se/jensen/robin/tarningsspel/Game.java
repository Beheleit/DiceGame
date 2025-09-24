package se.jensen.robin.tarningsspel;

import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Player[] players = new Player[2];
    Dice dice = new Dice();
    boolean gameOver = true;

    public void startGame() {
        System.out.println("Welcome to the Dice Game!");
        System.out.println("Would you like to start? Type (Play/Quit)?");

        starText();
        if (!gameOver) {
            playGame();
        }


        System.out.println("Goodbye!!");
        scanner.close();
    }

    private void starText() {
        String choice;
        boolean isTrue = false;

        do {
            choice = scanner.nextLine();
            switch (choice.toUpperCase()) {
                case "PLAY":
                    System.out.println("You typed Play");
                    isTrue = false;
                    gameOver = false;
                    break;
                case "QUIT":
                    System.out.println("You typed Quit");
                    isTrue = false;
                    gameOver = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again!");
                    System.out.println("Type (Play/Quit)?");
                    isTrue = true;
                    break;

            }
        } while (isTrue);
    }

    public void playGame() {
        setPlayers(0);
        setPlayers(1);
        gameOver = false;

        do {
            System.out.println("Your dice will roll automatically!");

            rollDice(0);
            rollDice(1);

            if (players[0].getScore() > players[1].getScore()) {
                System.out.println("Congratulations! " + players[0].getFullName() + " you have won the game!");
            } else {
                System.out.println("Congratulations! " + players[1].getFullName() + " you have won the game!\n");
            }

            System.out.println("Would you like to play again (Play/Quit)?");

            starText();

        } while (!gameOver);

    }

    private void rollDice(int playerNumber) {

        for (int i = 0; i < 2; i++) {
            players[playerNumber].addToScore(dice.rollDice());
            System.out.println(" You rolled a " + dice.getRoll() + "!");
        }
        System.out.println("Your total score is: " + players[playerNumber].getScore());
    }


    public void setPlayers(int playerNumber) {
        System.out.println("Hello Player " + (playerNumber + 1) + "!\nPlease enter your First and Last name!");
        String firstName;
        String lastName;
        players[playerNumber] = new Player();

        do {
            firstName = scanner.nextLine();
            lastName = scanner.nextLine();

            try {
                players[playerNumber].setFirstName(firstName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                firstName = null;
            }

            try {
                players[playerNumber].setLastName(lastName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                lastName = null;
            }

        } while (firstName == null || lastName == null);
    }

}