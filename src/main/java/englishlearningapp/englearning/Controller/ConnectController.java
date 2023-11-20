package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.App;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ConnectController extends GameViewController {
    @FXML
    private Circle c1;
    @FXML
    private TextArea timerNumber;
    @FXML
    private TextArea answerTextArea;


    @FXML
    private TextField playerAnswerTextField;
    private List<String> EnteredWord = new ArrayList<>();

    private GameTimer gmt = new GameTimer(5);
    private TimerTask currentTask;

    public ConnectController() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
    }


    private boolean checkEnterWord(String word) {
        for (int i = 0; i < EnteredWord.size() - 1; i++) {
            if (EnteredWord.get(i).equals(word)) return false;
        }
        return true;
    }

    public void initialize() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        answerTextArea.clear();
        playerAnswerTextField.setText("");
        String starWord = BotAnswerGenerator.generateRandomBotAnswers();
        answerTextArea.setText(starWord + "\n");
        EnteredWord.add(starWord);

        playerAnswerTextField.setOnKeyPressed(event -> {
            try {
                handleTextFieldEnter(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void handleTextFieldEnter(KeyEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (event.getCode() == KeyCode.ENTER) {
            String playerAnswer = playerAnswerTextField.getText();
            if (checkEnterWord(playerAnswer) && BotAnswerGenerator.checkPlayerWord(playerAnswer)) {
                EnteredWord.add(playerAnswer);
                System.out.println(EnteredWord);
                char keyword = playerAnswer.charAt(playerAnswer.length() - 1);
                String botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);
                while (!checkEnterWord(botAnswer)) {
                    botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);

                    if (botAnswer == null || botAnswer.isEmpty()) {
                        break;
                    }
                }
                if (botAnswer != null && !botAnswer.isEmpty()) {
                    answerTextArea.setText(botAnswer);
                    playerAnswerTextField.setText(botAnswer.charAt(0) + "");
                    EnteredWord.add(botAnswer);
                   // gmt.stopAudio();
                    playTimer(event);

                } else if (botAnswer == null) {
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


    public void playTimer(KeyEvent eventKey) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        gmt.stopAudio();
        final int[] counter = {5};
        gmt.playAudio();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (counter[0] >= 0) {
                    timerNumber.setText(String.valueOf(counter[0]));
                    counter[0]--;

                } else {
                    Platform.runLater(() -> {
                        try {
                            AlertController.alertEndGame(eventKey,"YOU LOSE");
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
        setRotate(c1, false, 360, 5);

    }

    public void setRotate(Circle c, boolean reverse, int angle, int duration) {
        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.millis(0));
        rt.setRate(duration);
        rt.setCycleCount(duration + 1);
        rt.play();
    }

}