package game.guessing.number;

/**
 * @author Shane Mayo
 * The GuessingGameModel class is representative of the data that the view must use in order
 * to display information pertinent to the GUI.
 */

public class GuessingGameModel {

    private int bestScore;
    private int numberOfGuesses;
    private int numberToGuess;

    public GuessingGameModel() {
        bestScore = Integer.MAX_VALUE;
        numberOfGuesses = 0;
    }

    /**
     * Checks the player guess to see if it is lower, higher or a winning number
     * @param playerGuess A value representing the player guess
     * @return A value representing if the guess is lower(-1), higher(1) or the winning number(0)
     */
    public int checkGuess(int playerGuess) {
        ++numberOfGuesses;
        if (playerGuess == numberToGuess) {
            setBestScore(numberOfGuesses);
            return 0;
        } else if (playerGuess < numberToGuess) {
            return -1;
        } else {
            return 1;
        }
    }

    // setters and getters start here
    public void setNumberToGuess(int numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public void setNumberOfGuesses(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
    }

    public int getBestScore() {
        return bestScore;
    }

    /**
     * A method to check if the current score is better than the best score of the session
     * @param score The current score that the player has, i.e. number of guesses for current session
     */
    private void setBestScore(int score) {
        if (score < bestScore) {
            bestScore = score;
        }
    }
}
