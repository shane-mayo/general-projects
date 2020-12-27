package game.guessing.number;

import java.util.Scanner;

/**
 * @author Shane Mayo
 *
 * Number Guessing Game
 * --------------------------------------------------------------------------------------------------
 * This game is a simple game where the player attempts to guess a random number between 1-100.
 * The game allows the player the choice to play the game, show an option menu,
 * or quit the game. When the player guesses correctly, the current round of the game ends,
 * showing the player the number of guesses that they took to guess the correct number.
 * The option menu is then shown directly after so that they player can make a choice as to
 * what the player wants to do next. The game will continue until the player chooses to quit the game.
 *
 * Menu options
 * ---------------------------------------------------------------------------------------------------
 * 0 will list the menu again --> Somewhat redundant, but available nonetheless
 * 1 starts the game
 * 9 quits the game
 *
 * 2-8 will throw an error and direct the user to choose a valid option from the menu
 *
 * Potential enhancements
 * ---------------------------------------------------------------------------------------------------
 * Adding a GUI for the player to interact with
 *      Aspects of the GUI can be dynamic --> higher or lower text, number of guesses, best score...etc.
 * Adding best score tracking, even after a session has been started and ended --> redundant because
 *      of the parameter placed on the randomly generated number, but possible to add simply for extended
 *      functionality
 *
 */

public class NumberGuessingGame {
    // 0 to quit
    // 1 to play
    // 9 to quit
    public static void main(String[] args) {
//        new GuessingGameView(new GuessingGameModel);
    }

    public NumberGuessingGame() {
        init();
        showMenu();
    }

    public void registerMenuChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter menu option: ");

        while (!sc.hasNextInt()) {
            System.out.print("ERROR: Enter valid menu option: ");
            sc.next();
        }
        int menuChoice = sc.nextInt();
        sc.nextLine();


        switch (menuChoice) {
            case 0:
                showMenu();
                break;
            case 1:
                play();
                break;
            case 2: case 3: case 4: case 5: case 6: case 7: case 8:
                System.out.println("ERROR: Please choose an option from the menu.");
                showMenu();
                registerMenuChoice();
                break;
            case 9:
                quitGame();
                break;
            default:
                sc.close();
                break;
        }

    }

    public void showMenu() {
        System.out.print("Options: \n" +
                "\t0 --> Show Menu\n" +
                "\t1 --> Play\n" +
                "\t9 --> Quit Game\n");
        registerMenuChoice();
    }

    public void init() {
        System.out.println("Starting game...");
    }

    public void play() {
        // generate the number to guess
        int numToGuess = (int)(Math.random() * 100) + 1;
        int guesses = 0;
        boolean isGameWon = false;

        // get the user guess
        Scanner sc = new Scanner(System.in);

        while (!isGameWon) {
            // check to make sure the user input is an integer
            System.out.print("Enter guess: ");
            while (!sc.hasNextInt()) {
                System.out.print("Enter guess: ");
                sc.next();
            }
            int userGuess = sc.nextInt();
            sc.nextLine();

            if (userGuess == numToGuess) {
                System.out.println("You win! " + userGuess + " is the correct number! \nNumber of guesses: " + guesses);
                isGameWon = true;
            } else if (userGuess < numToGuess) {
                System.out.println("The number to guess is greater than " + userGuess + ".");
                guesses++;
            } else {
                System.out.println("The number to guess is less than " + userGuess + ".");
                guesses++;
            }
        }
        showMenu();
    }

    public void quitGame() {
        System.out.println("Exiting Game");
        System.exit(0);
    }
}
