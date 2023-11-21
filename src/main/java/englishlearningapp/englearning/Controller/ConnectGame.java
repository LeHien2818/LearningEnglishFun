package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.questionGame.GameTimer;
import javafx.scene.input.KeyEvent;
import englishlearningapp.englearning.Game.Game;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.TextArea;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimerTask;



public class ConnectGame extends Game  {
    private TimerTask currentTask;

    final GameTimer gmt;
    {
        try {
            gmt = new GameTimer(8);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    static final List<String> EnteredWord = new ArrayList<>();

    static boolean checkEnterWord(String word) {
        for (int i = 0; i < EnteredWord.size() - 1; i++) {
            if (EnteredWord.get(i).equals(word)) return false;
        }
        return true;
    }


    @Override
    public void startGame() throws IOException {

    }

    @Override
    public void resetGame() {

    }

    @Override
    public void resetGame(Event event) throws IOException {

    }

    @Override
    public void handleGame() {

    }

    @Override
    public void handleGame(KeyEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

    }

    @Override
    public void playTimer(KeyEvent eventkey) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

    }

    @Override
    public void playTimer(ActionEvent eventkey) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

    }

    @Override
    public void playTimer(ActionEvent event, TextArea textArea) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

    }


    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
