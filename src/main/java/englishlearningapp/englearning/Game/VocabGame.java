package englishlearningapp.englearning.Game;

import englishlearningapp.englearning.Controller.AlertController;
import englishlearningapp.englearning.Controller.SceneController;
import englishlearningapp.englearning.questionGame.GameTimer;
import englishlearningapp.englearning.questionGame.Question_answer_vocab;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TimerTask;

public class VocabGame extends Game {
    private GameTimer gameTimer = new GameTimer(10);
    private int score = 0;
    private int quesnumber = 0;
    private Random random = new Random();
    private int randomIndex;
    private TimerTask currentTask;

    public GameTimer getGameTimer() {
        return gameTimer;
    }

    public void setGameTimer(GameTimer gameTimer) {
        this.gameTimer = gameTimer;
    }

    public VocabGame() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
    }

    public int getRandom() {
        return this.randomIndex;
    }

    public void setRandom(int size) {
        this.randomIndex = this.random.nextInt(size - 1) + 1;
    }


    public int getQuesNumber() {
        return this.quesnumber;
    }

    public void setQuesNumber(int quesnumber) {
        this.quesnumber = quesnumber;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void loadRandomQuestion(TextArea questionVocab, Button answerA, Button answerB) {
        Question_answer_vocab questionAnswer = new Question_answer_vocab();
        this.setRandom(10);
        int index = this.getRandom();
        questionVocab.setText(questionAnswer.getQuestion(index));

        this.setRandom(100);
        int countAnswer = this.getRandom();
        String correctAnswer = questionAnswer.getAnswer(index);

        if (countAnswer % 2 == 1) {
            answerA.setText(correctAnswer);
            answerB.setText(questionAnswer.getrandomAnswer());
        } else {
            answerA.setText(questionAnswer.getrandomAnswer());
            answerB.setText(correctAnswer);
        }
    }

    public void endGame(ActionEvent event, String s, TextArea scoreGame) throws IOException {
        if (s.equals("vocab") || s.equals("grammar") || s.equals("connect")) {
            SceneController.switchScene(event, SceneController.gameRoot);
            this.setScore(0);
            this.setQuesNumber(0);
        }
    }
    @Override
    public void startGame() throws IOException {
    }

    @Override
    public void resetGame() {
    }

    @Override
    public void resetGame(Event event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
        this.setScore(0);
        this.setQuesNumber(0);
        currentTask.cancel();
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
    public void playTimer(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
    }

    @Override
    public void playTimer(ActionEvent event, TextArea textArea) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        final int[] counter = {gameTimer.getCounter()};
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(counter[0] >= 0) {
                    textArea.setText(String.valueOf(counter[0]));
                    counter[0]--;
                } else {
                    Platform.runLater(() -> {
                        try {
                            AlertController.alertEndGame(event,"YOU LOSE");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        resetGame();
                    });
                    gameTimer.getTimer().cancel();
                }
            }
        };
        if(currentTask != null) {
            currentTask.cancel();
        }
        currentTask = timerTask;
        gameTimer.excuteTask(currentTask);
    }


    public void stop() {

    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
