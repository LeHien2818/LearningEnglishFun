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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimerTask;

public class ConnectController extends GameViewController {
    @FXML
    private Button play;
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

    private boolean checkEnterWord(String word) {
        for (int i = 0; i < EnteredWord.size() - 1; i++) {
            if (EnteredWord.get(i).equals(word)) return false;
        }
        return true;
    }

    public void initialize() {
        playerAnswerTextField.setText("");
        this.setRandom(100);
        int index = this.getRandom();
        String starWord = BotAnswerGenerator.generateRandomBotAnswers(index);
        answerTextArea.setText(starWord + "\n");
        EnteredWord.add(starWord);
        playerAnswerTextField.setOnKeyPressed(event -> {
            try {
                handleTextFieldEnter(event);
                if(event.getCode() == KeyCode.ENTER) {
                    playTimer();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void handleTextFieldEnter(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            String playerAnswer = playerAnswerTextField.getText();
            if (checkEnterWord(playerAnswer)) {
                EnteredWord.add(playerAnswer);
                System.out.println(EnteredWord);
                answerTextArea.appendText("Người chơi: " + playerAnswer + "\n");
                char keyword = playerAnswer.charAt(playerAnswer.length() - 1);

                String botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);

                while (!checkEnterWord(botAnswer)) {
                    botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);

                    if (botAnswer == null || botAnswer.isEmpty()) {
                        break;
                    }
                }

                if (botAnswer != null && !botAnswer.isEmpty()) {
                    answerTextArea.appendText("Bot: " + botAnswer + "\n");
                    EnteredWord.add(botAnswer);
                } else if(botAnswer == null){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText(null);
                    alert.setContentText("You Win");
                    ButtonType buttonTypeExit = new ButtonType("EXIT");
                    alert.getButtonTypes().setAll(buttonTypeExit);
                    Optional<ButtonType> newResult = alert.showAndWait();
                }
                playerAnswerTextField.clear();
            } else {
                ActionEvent eventAlert = new ActionEvent();
                AlertController.alertWrong(eventAlert,"The word was entered previously");
                playerAnswerTextField.clear();
            }
        }
    }

    public TextArea getTimerNumber() {
        return timerNumber;
    }

    public void setTimerNumber(String timerNumber) {
        this.timerNumber.setText(timerNumber);
    }

    public void playTimer() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        final int[] counter = {5};
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(counter[0] >= 0) {
                    timerNumber.setText(String.valueOf(counter[0]));
                    counter[0]--;
                    try {
                        gmt.playAudio();
                    } catch (UnsupportedAudioFileException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (LineUnavailableException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    gmt.getTimer().cancel();
                }
            }
        };
        if(currentTask != null) {
            currentTask.cancel();
            gmt.stopAudio();
        }
        currentTask = timerTask;
        gmt.excuteTask(currentTask);
        setRotate(c1, false, 360, 5);
        /*while (counter[0] >= 0) {

        }
        AlertController.CustomAlert();*/
    }
    public void setRotate(Circle c, boolean reverse, int angle, int duration) {
        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.millis(0));
        rt.setRate(5);
        rt.setCycleCount(duration + 1);
        rt.play();
    }

}

