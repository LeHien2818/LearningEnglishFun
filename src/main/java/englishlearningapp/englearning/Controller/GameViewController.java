
package englishlearningapp.englearning.Controller;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import animatefx.animation.BounceIn;
import englishlearningapp.englearning.CustomAnimation.FlipPageAnimation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.*;
import javafx.scene.layout.Region;


public class GameViewController {
    public Button searchBtn;
    public Button gameBtn;
    public Button translateBtn;
    public ImageView vocabPic;
    public ImageView grammarPic;
    public ImageView linkingPic;
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
    public static boolean showConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setHeaderText(null);
        alert.setContentText("Bạn đã sẵn sàng?");

        ButtonType buttonTypeYes = new ButtonType("YES");
        ButtonType buttonTypeNo = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                AlertController.class.getResource("/css/styles.css").toExternalForm()
        );
        dialogPane.getStyleClass().add("myDialog");

        // Hiển thị hộp thoại và xử lý phản hồi
        alert.initOwner(null);
        alert.setResizable(true);

        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);

        alert.getDialogPane().setPrefWidth(320.0);
        alert.getDialogPane().setPrefHeight(Region.USE_PREF_SIZE);

        alert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeYes) {
                System.out.println("Bạn đã sẵn sàng.");
            } else {
                System.out.println("Bạn chưa sẵn sàng.");
            }
        });
        return false;
    }

    public void endGame(ActionEvent event, String s) throws IOException {
        if (s.equals("vocab") || s.equals("grammar") || s.equals("connect")) {
            SceneController.switchScene(event, SceneController.gameRoot);
            this.setScore(0);
            this.setQuesNumber(0);
            this.setTextScore(this.toString(this.getScore()));
        }

    }

    public void clickSearch(ActionEvent event) throws IOException, InterruptedException {
        new BounceIn(searchBtn).play();
        SceneController.switchScene(event, SceneController.searchRoot);

    }

    public void clickTranslate(ActionEvent event) throws IOException, InterruptedException {
        new BounceIn(translateBtn).play();
        SceneController.switchScene(event, SceneController.translateRoot);
    }

    public void clickGame(ActionEvent event) throws IOException {

    }

    public void clickVocab(ActionEvent event) throws IOException, InterruptedException {
        FlipPageAnimation flp = new FlipPageAnimation(vocabPic);
        flp.play();
        flp.setOnFinished(() -> {
            try {
                SceneController.switchScene(event, SceneController.vocabRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        flp.play();
    }

    public void clickConnect(ActionEvent event) throws IOException, InterruptedException {
        FlipPageAnimation flp = new FlipPageAnimation(linkingPic);
        flp.play();
        flp.setOnFinished(() -> {
            try {
                SceneController.switchScene(event, SceneController.connectRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        flp.play();

    }

    public void clickGrammar(ActionEvent event) throws IOException, InterruptedException {
        FlipPageAnimation flp = new FlipPageAnimation(grammarPic);
        flp.play();
        flp.setOnFinished(() -> {
            try {
                SceneController.switchScene(event, SceneController.grammarRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        flp.play();
    }

    public void clickExit(ActionEvent event) throws IOException {
        this.setScore(0);
        this.setQuesNumber(0);
        this.setTextScore(this.toString(this.getScore()));
        AlertController.alertSubmit(event);
    }

    public void onIconClicked(MouseEvent mouseEvent) throws IOException {
        SceneController.switchScene(mouseEvent, SceneController.defaultRoot);
    }
}
