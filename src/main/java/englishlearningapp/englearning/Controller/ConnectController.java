package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.questionGame.BotAnswerGenerator;
import englishlearningapp.englearning.questionGame.GameTimer;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.shape.Circle;
import javafx.util.Duration;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class ConnectController   {

    private TimerTask currentTask;

    final GameTimer gmt;
    {
        try {
            gmt = new GameTimer(8);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    static Circle c1;
    @FXML
    static TextArea timerNumber;
    @FXML
      static TextArea answerTextArea;
    ConnectGame connectGame  = new ConnectGame();




    @FXML
    static TextField playerAnswerTextField;


    public  void startGame()  {

        playerAnswerTextField.setText("");
        String starWord = BotAnswerGenerator.generateRandomBotAnswers();
        answerTextArea.setText(starWord + "\n");
        ConnectGame.EnteredWord.add(starWord);
        playerAnswerTextField.setOnKeyPressed(event -> {
            try {

                handleGame(event);
                if (event.getCode() == KeyCode.ENTER) {
                    playTimer(event);
                }
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                throw new RuntimeException(e);
            }
        });
    }


    public void handleGame(KeyEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (event.getCode() == KeyCode.ENTER) {
            String playerAnswer = playerAnswerTextField.getText();
            if (ConnectGame.checkEnterWord(playerAnswer) && BotAnswerGenerator.checkPlayerWord(playerAnswer)) {
                ConnectGame.EnteredWord.add(playerAnswer);
                System.out.println(ConnectGame.EnteredWord);
                char keyword = playerAnswer.charAt(playerAnswer.length() - 1);
                String botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);
                while (!ConnectGame.checkEnterWord(botAnswer)) {
                    botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);

                    if (botAnswer == null || botAnswer.isEmpty()) {
                        break;
                    }
                }
                if (botAnswer != null && !botAnswer.isEmpty()) {
                    answerTextArea.setText(botAnswer);
                    ConnectGame.EnteredWord.add(botAnswer);
                    playTimer(event);

                } else if (botAnswer == null) {
                    resetGame();
                    AlertController.alertEndGame(event, "You Win");
                }
                playerAnswerTextField.clear();
            } else {
                ActionEvent eventAlert = new ActionEvent();
                AlertController.alertWrong(eventAlert, "The word was entered previously");
                playerAnswerTextField.clear();
            }
        }
    }


    public void setTimerNumber(String timerNumber) {
        this.timerNumber.setText(timerNumber);
    }


    public void clickExitConnect(ActionEvent event) throws IOException {
        resetGame();
        AlertController.alertExit(event);
    }
    public static void setRotate(Circle c, boolean reverse, int angle, int duration) {
        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.millis(0));
        rt.setRate(duration);
        rt.setCycleCount(duration + 1);
        rt.play();
    }
        public void playTimer(KeyEvent eventkey) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        gmt.stopAudio();
        final int[] counter = {8};
        gmt.playAudio();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (counter[0] >= 0) {
                    counter[0]--;

                } else {
                    Platform.runLater(() -> {
                        try {

                            resetGame();


                            AlertController.alertEndGame(eventkey,"YOU LOSE");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    gmt.getTimer().cancel();
                }

            }

        };

        if (currentTask != null) {
            currentTask.cancel();
        }
        currentTask = timerTask;
        gmt.excuteTask(currentTask);
        setRotate(ConnectController.c1, false, 360, 8);

    }
    public void resetGame() {

    }
    public void initialize( )   {
        startGame();
    }
}