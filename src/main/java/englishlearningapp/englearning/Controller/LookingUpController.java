package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LookingUpController extends SceneController{
    private Parent game = FXMLLoader.load(App.class.getResource("Views/GameView.fxml"));
    private Parent translate = FXMLLoader.load(App.class.getResource("Views/TranslateView.fxml"));
    public LookingUpController() throws IOException {
    }

    @FXML
    public void clickGame (ActionEvent event) throws IOException {
        switchScene(event, game);
    }
    public void clickTranslate (ActionEvent event) throws IOException {
        switchScene(event, translate);
    }
}
