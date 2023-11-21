package englishlearningapp.englearning.Game;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public abstract class Game implements Initializable {

    public Game() {
    }

    public abstract void startGame() throws IOException;
    public abstract void resetGame();
    public abstract void resetGame(Event event) throws IOException;
    public abstract void handleGame() ;
    public abstract void handleGame(KeyEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException ;

    public abstract void playTimer(KeyEvent eventkey) throws IOException, UnsupportedAudioFileException, LineUnavailableException;
    public abstract void playTimer(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException;
    public abstract void playTimer(ActionEvent event, TextArea textArea) throws IOException, UnsupportedAudioFileException, LineUnavailableException;

}
