package game.guessing.number;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * In the MVC pattern, this class acts as the view
 *
 * The GUI for the number guessing game will include information about:
 * Player score --> lowest number of guesses during current gaming session
 * Number of player guesses for current round
 * Parameter text --> "Choose number between 1 - 100"
 * A button to submit the guess
 * A button to play the game --> either first starting, or playing again
 * A button to quit the game --> simply exits the game using System.exit(0)
 * Text that displays dependent on the player guess being higher or lower than the number to guess
 */

public class GuessingGameView extends JFrame {
    private static final String LOWER = " is lower than number to guess.";
    private static final String HIGHER = " is higher than number to guess.";
    private static final String WIN = "YOU WIN!";
    private final JButton playBT;
    private final JButton quitBT;
    private final JTextField guessTF;
    private final JButton guessBT;
    private final JTextField scoreTF;
    private final JTextField numGuessesTF;
    private final JLabel guessStatusLB;

    private final GuessingGameModel model;

    public GuessingGameView(GuessingGameModel model) {
        super("Number Guessing Game");
        this.model = model;

        // main content panel
        JPanel contentPanel = new JPanel();

        // create the GroupLayout and set the content pane to use the GroupLayout
        GroupLayout layout = new GroupLayout(contentPanel);
        contentPanel.setLayout(layout);

        // make padding and margins automatic
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        contentPanel.setBorder(new EmptyBorder(0, 15, 35, 15));

        // Results section of game view --> Upper left portion of view --> score tracking, num of guesses tracking
        // guesses tf and label
        numGuessesTF = new JTextField(5);
        numGuessesTF.setText("--");
        numGuessesTF.setHorizontalAlignment(SwingConstants.CENTER);
        numGuessesTF.setEditable(false);
        JLabel numGuessesLB = new JLabel("Guesses");

        // score tf and label
        scoreTF = new JTextField(5);
        scoreTF.setText("--");
        scoreTF.setHorizontalAlignment(SwingConstants.CENTER);
        scoreTF.setEditable(false);
        JLabel scoreLB = new JLabel("Best Score");

        // game title label
        JLabel gameTitleLB = new JLabel("Number Guessing Game");
        gameTitleLB.setForeground(Color.RED);
        gameTitleLB.setFont(new Font("Sans-Serif", Font.BOLD, 28));

        // player guess components
        JLabel parameterLB = new JLabel("Pick a number between 1 - 100");
        guessTF = new JTextField();
        guessTF.setHorizontalAlignment(SwingConstants.CENTER);
        guessTF.setEnabled(false);
        guessBT = new JButton("Submit Guess");
        guessBT.setEnabled(false);

        // play and quit buttons
        playBT = new JButton("Play");
        quitBT = new JButton("Quit");

        // guess status of the player's guess
        // lower than, greater than, winner
        guessStatusLB = new JLabel("");

        // create horizontal layout of the GUI
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(numGuessesLB)
                                        .addComponent(numGuessesTF, 50, 50, 50)
                                        .addComponent(scoreLB)
                                        .addComponent(scoreTF, 50, 50, 50)
                                        .addGroup(
                                                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                        .addComponent(gameTitleLB)
                                                        .addComponent(parameterLB)
                                                        .addComponent(guessTF, 50, 50, 50)
                                                        .addComponent(guessBT)
                                                        .addGroup(
                                                                layout.createSequentialGroup()
                                                                        .addComponent(playBT, 75, 75, 75)
                                                                        .addGap(35)
                                                                        .addComponent(quitBT, 75, 75, 75)
                                                        )
                                        )
                        )
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, 70)
                                        .addComponent(guessStatusLB)
                        )
        );

        // create the vertical layout of the GUI
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                // Left side components
                                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(numGuessesLB)
                                        .addComponent(numGuessesTF, 25, 25, 25)
                                        .addComponent(scoreLB)
                                        .addComponent(scoreTF, 25, 25, 25)
                                        .addGroup(
                                                // Right side components
                                                layout.createSequentialGroup()
                                                        .addComponent(gameTitleLB)
                                                        .addGap(15)
                                                        .addComponent(parameterLB)
                                                        .addGroup(
                                                                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(guessStatusLB)
                                                                        .addComponent(guessTF, 25, 25, 25)
                                                        )
                                                        .addComponent(guessBT, 40, 40, 40)
                                                        .addGap(40)
                                                        .addGroup(
                                                                layout.createParallelGroup()
                                                                        .addComponent(playBT)
                                                                        .addComponent(quitBT)
                                                        )
                                        )
                        )
        );


        // content to the frame
        this.setContentPane(contentPanel);
    }

    /**
     * Sets the controller as the listener for the action items of the GUI
     * @param listener A controller object that acts as an action listener
     */
    public void registerListener(GuessingGameController listener) {
        playBT.addActionListener(listener);
        quitBT.addActionListener(listener);
        guessBT.addActionListener(listener);
    }

    /**
     * Retrieves the player's guess from the corresponding TextField
     * @return An int value representing the player's guess
     */
    public int getPlayerGuess() {
        return Integer.parseInt(guessTF.getText());
    }

    /**
     * Updates the score TextField on the GUI
     */
    public void updateBestScore() {
        scoreTF.setText(String.valueOf(model.getBestScore()));
    }

    /**
     * Updates the guesses TextField on the GUI
     */
    public void updateNumberOfGuesses() {
        numGuessesTF.setText(String.valueOf(model.getNumberOfGuesses()));
    }

    /**
     * Sets the status label depending on the player guess being lower, higher, or a winning number
     * @param code A value representing the guess being lower, higher, or a winning number
     */
    public void setGuessStatusLB(int code) {
        String guessStatus = String.valueOf(this.getPlayerGuess());
        if (code == 0) {
            // player wins
            guessStatusLB.setFont(new Font("Sans-Serif", Font.BOLD, 28));
            guessStatusLB.setForeground(Color.RED);
            guessStatusLB.setText(WIN);
            updateBestScore();
            updateNumberOfGuesses();
            initGameWon();
        } else if (code < 0) {
            // players guess is lower than the number to guess
            guessStatusLB.setText(guessStatus + LOWER);
            updateNumberOfGuesses();
        } else {
            // players guess is higher than the number to guess
            guessStatusLB.setText(guessStatus + HIGHER);
            updateNumberOfGuesses();
        }
    }

    /**
     * A method to reset the game to a default state when a new game is started
     */
    public void initGameStart() {
        guessBT.setEnabled(true);
        guessTF.setEnabled(true);
        guessStatusLB.setText("");
        playBT.setEnabled(false);
        guessTF.setText("");
        numGuessesTF.setText("0");
        model.setNumberToGuess((int)(Math.random() * 100) + 1);
        model.setNumberOfGuesses(0);
    }

    /**
     * A method to deactivate and activate components of the GUI when the game is won
     */
    public void initGameWon() {
        guessBT.setEnabled(false);
        guessTF.setEnabled(false);
        playBT.setEnabled(true);
    }
}

