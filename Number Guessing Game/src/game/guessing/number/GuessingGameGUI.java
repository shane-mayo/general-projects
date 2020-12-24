package game.guessing.number;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.util.concurrent.Flow;

/**
 * The GUI for the number guessing game will include information about:
 *      Player score --> lowest number of guesses during current gaming session
 *      Number of player guesses for current round
 *      Parameter text --> "Choose number between 1 - 100"
 *      A button to submit the guess
 *      A button to play the game --> either first starting, or playing again
 *      A button to quit the game --> simply exits the game using System.exit(0)
 *      An image that is related to making a guess
 *      Text that displays dependent on the player guess being higher or lower than the number to guess
 */

public class GuessingGameGUI {

    public GuessingGameGUI() {

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // main content panel
        JPanel contentPanel = new JPanel();

        // create the GroupLayout and set the content pane to use the GroupLayout
        GroupLayout layout = new GroupLayout(contentPanel);
        contentPanel.setLayout(layout);

        // make padding and margins automatic
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Results section of game view --> Upper left portion of view --> score tracking, num of guesses tracking
        // guesses tf and label
        JTextField numGuessesTF = new JTextField(5);
        numGuessesTF.setEnabled(false);
        JLabel numGuessesLB = new JLabel("Guesses");
        // score tf and label
        JTextField scoreTF = new JTextField(5);
        scoreTF.setEnabled(false);
        JLabel scoreLB = new JLabel("Best Score");

        // game title label
        JLabel gameTitleLB = new JLabel("Number Guessing Game");
        gameTitleLB.setForeground(Color.RED);
        gameTitleLB.setFont(new Font("Sans-Serif", Font.BOLD, 28));

        // player guess components
        JLabel parameterLB = new JLabel("Pick a number between 1 - 100");
        JTextField guessTF = new JTextField();
        JButton guessBT = new JButton("Submit Guess");

        // play and quit buttons
        JButton playBT = new JButton("Play");
        JButton quitBT = new JButton("Quit");

        JLabel guessStatusLB = new JLabel("Placeholder Text"); // no default descriptor will change depending on the user guess


        // create the horizontal results group
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addComponent(numGuessesLB)
                    .addGap(5)
                .addComponent(numGuessesTF, 50, 50, 50)
                .addComponent(scoreLB)
                        .addGap(5)
                .addComponent(scoreTF, 50, 50, 50)
                .addGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(gameTitleLB)
                        .addComponent(parameterLB)
                        .addComponent(guessTF, 60, 60, 60)
                        .addComponent(guessBT)
                        .addGroup(
                                layout.createSequentialGroup()
                                .addComponent(playBT, 100, 100, 100)
                                        .addGap(20)
                                .addComponent(quitBT, 100, 100, 100)
                        )
                )
        );

        // create the vertical results group
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(numGuessesLB)
                .addComponent(numGuessesTF, 25, 25, 25)
                .addComponent(scoreLB)
                .addComponent(scoreTF, 25, 25, 25)
                .addGroup(
                        // starting from the game title and vertically positioning one after another
                        layout.createSequentialGroup()
                                .addGap(25)
                        .addComponent(gameTitleLB)
                                .addGap(30)
                        .addComponent(parameterLB)
                                .addGap(10)
                        .addComponent(guessTF, 25, 25, 25)
                                .addGap(10)
                        .addComponent(guessBT, 35, 35, 35)
                                .addGap(45)
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(playBT)
                                .addComponent(quitBT)
                                .addGap(65)
                        )
                )
        );


        // content to the frame
        frame.setContentPane(contentPanel);

        // Only use pack when you have other components added to the frame
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

