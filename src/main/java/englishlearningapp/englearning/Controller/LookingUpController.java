package englishlearningapp.englearning.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class LookingUpController {
    public LookingUpController() throws IOException {
    }

    @FXML
    public void clickGame (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickTranslate (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.translateRoot);
    }
}
