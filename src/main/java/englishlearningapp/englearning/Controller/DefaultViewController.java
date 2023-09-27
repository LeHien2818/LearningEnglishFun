package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class DefaultViewController extends SceneController {
    private Parent searchRoot = FXMLLoader.load(App.class.getResource("Views/LookingUpView.fxml"));
    private Parent gameRoot = FXMLLoader.load(App.class.getResource("Views/GameView.fxml"));
    private Parent translateRoot = FXMLLoader.load(App.class.getResource("Views/TranslateView.fxml"));
    public DefaultViewController() throws IOException {
    }

    @FXML
    public void clickSearch (ActionEvent event) throws IOException {
        switchScene(event, searchRoot);
    }
    public void clickGame (ActionEvent event) throws IOException{
        switchScene(event, gameRoot);
    }
    public void clickTranslate (ActionEvent event) throws IOException {
        switchScene(event, translateRoot);
    }


}
