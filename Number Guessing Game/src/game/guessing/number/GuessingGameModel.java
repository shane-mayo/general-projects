package game.guessing.number;

public class GuessingGameModel {

    /*
    Things to track:
        bestScore
        playerGuess
        numberGuesses
        numberToGuess
     */
    private int bestScore;
    private int numberOfGuesses;
    private int numberToGuess;

    public GuessingGameModel() {
        bestScore = Integer.MAX_VALUE;
        numberOfGuesses = 0;
    }

    public int checkGuess(int playerGuess) {
        if (playerGuess == numberToGuess) {
            // player wins the game -- update the label
            return 0;
        } else if (playerGuess < numberToGuess) {
            // player guess is lower than the number to guess
            numberOfGuesses++;
            return -1;
        } else {
            // player guess is higher than the number to guess
            numberOfGuesses++;
            return 1;
        }
    }

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

    public void checkForBestScore(int score) {
        setBestScore(score);
    }

    private void setBestScore(int score) {
        if (score < bestScore) {
            bestScore = score;
        }
    }
}
