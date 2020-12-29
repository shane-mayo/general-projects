package game.guessing.number;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GuessingGameController acts as a liaison between the GuessingGameView and GuessingGameModel
 * classes. It acts as the listener for player initiated events.
 */

public class GuessingGameController implements ActionListener {
    private final GuessingGameView view;
    private final GuessingGameModel model;

    public GuessingGameController(GuessingGameModel model, GuessingGameView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Trigger and action dependent on the source of the event
     * @param e An event that has occurred via the GUI
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String sourceName = e.getActionCommand();
        switch (sourceName) {
            case "Quit":
                view.dispose();
                System.exit(0);
            case "Submit Guess":
                view.setGuessStatusLB(model.checkGuess(view.getPlayerGuess()));
                break;
            case "Play":
                view.initGameStart();
                break;
        }
    }
}
