package numberguessinggame;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.util.concurrent.Flow;

public class GuessingGameGUI {

    public GuessingGameGUI() {

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 400);

        // main content panel
        JPanel contentPanel = new JPanel();

        // create the GroupLayout and set the content pane to use the GroupLayout
        GroupLayout layout = new GroupLayout(contentPanel);
        contentPanel.setLayout(layout);

        // turn on auto-gaps between components
        layout.setAutoCreateGaps(true);

        // automatically create gaps between components that touch the edge
        // of the container and the container
        layout.setAutoCreateContainerGaps(true);

        // Results section of game view --> Upper left portion of view --> score tracking, num of guesses tracking
        // guesses tf and label
        JTextField numGuessesTF = new JTextField(5);
        numGuessesTF.setEnabled(false);
        JLabel numGuessesLB = new JLabel("Guesses: ");
        // score tf and label
        JTextField scoreTF = new JTextField(5);
        scoreTF.setEnabled(false);
        JLabel scoreLB = new JLabel("Score: ");

        // game title label
        JLabel gameTitleLB = new JLabel("Number Guessing Game");
        gameTitleLB.setForeground(Color.RED);
        gameTitleLB.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        // player guess components
        JLabel parameterLB = new JLabel("Pick a number between 1 - 100");
        JTextField guessTF = new JTextField();
        JButton guessBT = new JButton("Submit Guess");


        // create the horizontal results group
        GroupLayout.SequentialGroup hResults = layout.createSequentialGroup();
        hResults.addComponent(numGuessesLB)
                .addComponent(numGuessesTF, 50, 50, 50)
                .addComponent(scoreLB)
                .addComponent(scoreTF, 50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(gameTitleLB)
                    .addComponent(parameterLB)
                    .addComponent(guessTF, 50, 50, 50)
                    .addComponent(guessBT));
        layout.setHorizontalGroup(hResults);

        // create the vertical results group
        GroupLayout.ParallelGroup vResults = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
        vResults.addComponent(numGuessesLB)
                .addComponent(numGuessesTF)
                .addComponent(scoreLB)
                .addComponent(scoreTF)
                .addGroup(layout.createSequentialGroup().addGap(35)
                    .addComponent(gameTitleLB).addGap(15)
                    .addComponent(parameterLB).addGap(15)
                    .addComponent(guessTF, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).addGap(15)
                    .addComponent(guessBT, 30, 30, 30));
        layout.setVerticalGroup(vResults);



        // add panels to the frame
        frame.setContentPane(contentPanel);

        // Only use pack when you have other components added to the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GuessingGameGUI();
    }
}
