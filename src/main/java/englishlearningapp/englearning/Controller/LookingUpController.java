package englishlearningapp.englearning.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class LookingUpController {
    @FXML
    private TextField textInput;
    public LookingUpController() throws IOException {
    }

    public void clickGame (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickTranslate (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.translateRoot);
    }

    public void inputWordHanddle () {
        textInput.setOnKeyReleased((KeyEvent event) -> {

        });
    }
}
