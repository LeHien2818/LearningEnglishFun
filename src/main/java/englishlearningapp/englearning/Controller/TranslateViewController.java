package englishlearningapp.englearning.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class TranslateViewController{
    public TranslateViewController() throws IOException {
    }
    @FXML
    public void clickGame (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickSearch (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.searchRoot);
    }
}
