import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandController implements ActionListener {

    private final GameMaster model;
    private final ScrabbleFrame frame;

    public CommandController(GameMaster model, ScrabbleFrame frame) {
        this.model = model;
        this.frame = frame;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(ScrabbleFrame.Commands.NEW_GAME.toString())) {
            model.newGame();
        }
        else if(e.getActionCommand().equals(ScrabbleFrame.Commands.QUIT.toString())) {
            model.quit();
        }
        else if(e.getActionCommand().equals(ScrabbleFrame.Commands.HELP.toString())) {
            model.help();
        }
        else if(e.getActionCommand().equals(ScrabbleFrame.Commands.ABOUT.toString())) {
            model.about();
        }
        else if(e.getActionCommand().equals(ScrabbleFrame.Commands.EXCHANGE.toString())) {
            model.exchangeTile(frame.getExchangeTileIndex());
        }
        else if(e.getActionCommand().equals(ScrabbleFrame.Commands.PASS.toString())) {
            model.changeTurn();
        }

    }
}
