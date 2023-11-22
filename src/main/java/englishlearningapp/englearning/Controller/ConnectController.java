package englishlearningapp.englearning.Controller;


import englishlearningapp.englearning.App;
import englishlearningapp.englearning.Game.ConnectGame;
import englishlearningapp.englearning.questionGame.BotAnswerGenerator;
import englishlearningapp.englearning.questionGame.GameTimer;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.shape.Circle;
import javafx.util.Duration;

import javax.sound.sampled.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class ConnectController   {

    private final ConnectGame connectGame = new ConnectGame();
    @FXML
    private TextField playerAnswerTextField;

    @FXML
    private Button answerTextArea;
    @FXML
    private ImageView imageScore;
    @FXML
    protected Circle c1;
    @FXML
    TextArea timerNumber;

    @FXML
    private TextField score;
    @FXML
    private ImageView imageWay;
    private int Score = 0;
    public  void startGame()  {
        score.setText(String.valueOf(Score));
        answerTextArea.setText("Word Spawn");
        playerAnswerTextField.setOnKeyPressed(event -> {
            try {

                handlePlayer(event);

            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {

                throw new RuntimeException(e);
            }
        });
    }

    public void handlePlayer(KeyEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (event.getCode() == KeyCode.ENTER) {
            String playerAnswer = playerAnswerTextField.getText();
            if (connectGame.checkEnterWord(playerAnswer) && BotAnswerGenerator.checkPlayerWord(playerAnswer)) {
                connectGame.EnteredWord.add(playerAnswer);
                String botAnswer = connectGame.checkBotAnswer(playerAnswer);
                if (botAnswer != null && !botAnswer.isEmpty()) {
                    answerTextArea.setText(botAnswer);
                    Score ++;
                    score.setText(String.valueOf(Score));
                    connectGame.EnteredWord.add(botAnswer);
                    connectGame.playTimer(event, timerNumber,c1, score, answerTextArea,playerAnswerTextField);
                    String s = "Back.png";
                    Image image = new Image(App.class.getResource("src/image/" + s).toString());
                    imageWay.setImage(image);
                } else if (botAnswer == null) {
                    connectGame.resetGame(playerAnswerTextField, answerTextArea, timerNumber, score);
                    connectGame.stopTimer();
                    String point = score.getText();
                    connectGame.gmt.stopAudio();
                    score.setText(String.valueOf(0));
                    answerTextArea.setText("Word Spawn");
                    playerAnswerTextField.setText("");
                    AlertController.alertEndGame(event, "You Win", point);
                }
                playerAnswerTextField.clear();
            } else {
                ActionEvent eventAlert = new ActionEvent();
                AlertController.alertWrong(eventAlert, "The word was entered previously");
                playerAnswerTextField.clear();
            }
        }
    }

    public void clickExitConnect(ActionEvent event) throws IOException {
        AlertController.alertExit(event);

        connectGame.resetGame();
        connectGame.gmt.stopAudio();
        score.setText(String.valueOf(0));
        answerTextArea.setText("Word Spawn");
        playerAnswerTextField.setText("");
    }

    public void initialize() throws SQLException {
        Thread th = new Thread(new Task<Void>() {
            @Override
            protected Void call() throws Exception {
               startGame();
                return null;
            }
        });
        th.setDaemon(true);
        th.start();
    }
}