package game.guessing.number;

import javax.swing.*;

/**
 * The GuessingGameMain class initializes a new game
 */

public class GuessingGameMain {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GuessingGameModel model = new GuessingGameModel();
                GuessingGameView view = new GuessingGameView(model);
                GuessingGameController controller = new GuessingGameController(model, view);

                view.registerListener(controller);

                view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                view.setResizable(false);
                view.pack();
                view.setLocationRelativeTo(null);
                view.setVisible(true);
            }
        });
    }
}
