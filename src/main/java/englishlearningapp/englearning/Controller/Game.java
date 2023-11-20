package englishlearningapp.englearning.Controller;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public abstract class Game implements Initializable {

    public Game() {
    }

    public abstract void startGame() throws IOException;

    public abstract void resetGame() ;
    public abstract void handleGame(KeyEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException ;

    public abstract void playTimer(KeyEvent eventkey) throws IOException, UnsupportedAudioFileException, LineUnavailableException;

}
