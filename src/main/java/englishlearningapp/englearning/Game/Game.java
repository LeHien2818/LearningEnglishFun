package englishlearningapp.englearning.Game;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public abstract class Game   {

    public Game() {
    }

    public abstract void startGame() throws IOException;
    public abstract void resetGame();
    public abstract void resetGame(Event event) throws IOException;

    public abstract void resetGame(Event event, Button answerA, Button answerB, TextArea questionvocab) throws IOException;

    public abstract void resetGame(TextField playerAnswerTextField, Button answerTextArea, TextArea timerNumber);

    public abstract void resetGame(TextField playerAnswerTextField, Button answerTextArea, TextArea timerNumber, TextField score);

    public abstract void handleGame() ;
    public abstract void handleGame(KeyEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException ;

    public abstract void playTimer(KeyEvent eventkey) throws IOException, UnsupportedAudioFileException, LineUnavailableException;
    public abstract void playTimer(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException;

    public abstract void playTimer(KeyEvent event, TextArea textArea, TextArea score) throws IOException, UnsupportedAudioFileException, LineUnavailableException;

    public abstract void playTimer(ActionEvent event, TextArea textArea, TextArea score) throws IOException, UnsupportedAudioFileException, LineUnavailableException;

    public abstract void playTimer(ActionEvent event, TextArea textArea) throws IOException, UnsupportedAudioFileException, LineUnavailableException;
    public abstract void playTimer(KeyEvent event, TextArea textArea) throws IOException, UnsupportedAudioFileException, LineUnavailableException;

    public abstract void playTimer(KeyEvent eventkey, TextArea timerNumber, Circle c1) throws IOException, UnsupportedAudioFileException, LineUnavailableException;

    public abstract void playTimer(KeyEvent eventkey, TextArea timerNumber, Circle c1, TextField score) throws IOException, UnsupportedAudioFileException, LineUnavailableException;

    public abstract void playTimer(java.awt.event.KeyEvent event, TextArea timerbox, TextArea scoregame);
}
