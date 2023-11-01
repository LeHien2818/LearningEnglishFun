
package englishlearningapp.englearning.Controller;

import java.io.IOException;
import java.util.Random;

import animatefx.animation.BounceIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class GameViewController {
    public Button searchBtn;
    public Button gameBtn;
    public Button translateBtn;
    @FXML
    private TextArea Scoregame = new TextArea();
    private int score = 0;
    private int quesnumber = 0;
    Random random = new Random();
    private int randomIndex;

    public GameViewController() {

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

    public String toString(int score) {
        return "[" + score + "]";
    }

    public void setTextScore(String s) {
        this.Scoregame.setText(s);
    }

    public int getRandom() {
        return this.randomIndex;
    }

    public void setRandom(int size) {
        this.randomIndex = this.random.nextInt(size - 1) + 1;
    }

    public void startGame() {
    }

    public void endGame(ActionEvent event, String s) throws IOException {
        if (s.equals("vocab") || s.equals("grammar") || s.equals("connect")) {
            SceneController.switchScene(event, SceneController.gameRoot);
            this.setScore(0);
            this.setQuesNumber(0);
            this.setTextScore(this.toString(this.getScore()));
        }

    }

    public void clickSearch(ActionEvent event) throws IOException {
        new BounceIn(searchBtn).play();
        SceneController.switchScene(event, SceneController.searchRoot);
    }

    public void clickTranslate(ActionEvent event) throws IOException {
        new BounceIn(translateBtn).play();
        SceneController.switchScene(event, SceneController.translateRoot);
    }

    public void clickGame(ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }

    public void clickVocab(ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.vocabRoot);
    }

    public void clickConnect(ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.connectRoot);
    }

    public void clickGrammar(ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.grammarRoot);
    }

    public void clickExit(ActionEvent event) throws IOException {
        this.setScore(0);
        this.setQuesNumber(0);
        this.setTextScore(this.toString(this.getScore()));
        SceneController.switchScene(event, SceneController.gameRoot);
    }

    public void onIconClicked(MouseEvent mouseEvent) throws IOException {
        SceneController.switchScene(mouseEvent, SceneController.defaultRoot);
    }
}
