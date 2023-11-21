//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.Game.VocabGame;
import englishlearningapp.englearning.questionGame.Question_answer_vocab;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class VocabViewController {

    @FXML
    private MediaView leftMedia, rightMedia;
    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private TextArea timerbox;
    @FXML
    private TextArea questionVocab;
    @FXML
    private Button answerA;
    @FXML
    private Button answerB;

    @FXML
    private TextArea Scoregame = new TextArea();
    private VocabGame vocabGame = new VocabGame();
    Question_answer_vocab questionAnswer = new Question_answer_vocab();

    public VocabViewController() throws UnsupportedAudioFileException, LineUnavailableException, IOException, SQLException {
    }

    @FXML
    public void handleAnswerA(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, SQLException {
        System.out.println("answerA");
        if(  vocabGame.checkCorrect(questionVocab, answerA)) {
            int scoretmp = vocabGame.getScore();
            vocabGame.setScore(scoretmp + 1);
            Scoregame.setText(String.valueOf(vocabGame.getScore()));
        }
        handleInformation(event);

    }
    @FXML
    public void handleAnswerB(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, SQLException {
        System.out.println("answerB");
        if(  vocabGame.checkCorrect(questionVocab, answerB)) {
            int scoretmp = vocabGame.getScore();
            vocabGame.setScore(scoretmp + 1);
            Scoregame.setText(String.valueOf(vocabGame.getScore()));
        }

        handleInformation(event);
    }

    public void initialize() throws SQLException {
        Thread th = new Thread(new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                vocabGame.loadRandomQuestion(questionVocab, answerA, answerB,Scoregame);
                return null;
            }
        });
        th.setDaemon(true);
        th.start();
    }
    public void handleInformation(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, SQLException {
        vocabGame.playTimer(event,timerbox,Scoregame);
        Scoregame.setText(String.valueOf(vocabGame.getScore()));
        int questionnumber = vocabGame.getQuesNumber();
        if (questionnumber <= 15) {

            vocabGame.setRandom(950);
            int index = vocabGame.getRandom();
            String question = questionAnswer.getQuestion(index);
            questionVocab.setText(question);
            String correctAnswer = questionAnswer.getAnswer(index);

            vocabGame.setRandom(950);
            int countAnswer = vocabGame.getRandom();
            String answerRandom = questionAnswer.getrandomAnswer(index);

            if (countAnswer % 2 == 1) {
                answerA.setText(correctAnswer);
                answerB.setText(answerRandom);
            } else {
                answerA.setText(answerRandom);
                answerB.setText(correctAnswer);
            }

            questionnumber++;
            vocabGame.setQuesNumber(questionnumber);

        } else {
            vocabGame.endGame(event, Scoregame);
            Scoregame.setText(String.valueOf(0));
        }

    }

    public void onExit(ActionEvent event) throws IOException {
        String s = "vocab";
        vocabGame.resetGame(event, answerA, answerB,questionVocab );
        Scoregame.setText(String.valueOf(0));
        vocabGame.setScore(0);
        answerA.setText("");
        answerB.setText("");
        questionVocab.clear();
        timerbox.clear();
    }
}
