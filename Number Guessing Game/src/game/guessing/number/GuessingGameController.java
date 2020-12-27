package game.guessing.number;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGameController implements ActionListener {
    private final GuessingGameView view;
    private final GuessingGameModel model;

    public GuessingGameController(GuessingGameModel model, GuessingGameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sourceName = e.getActionCommand();
        switch (sourceName) {
            case "Quit":
                view.dispose();
                System.exit(0);
            case "Submit Guess":
                view.updateGuessStatusLB(model.checkGuess(view.getPlayerGuess()));
                break;
            case "Play":
                view.playGame();
                break;
        }
    }
}
