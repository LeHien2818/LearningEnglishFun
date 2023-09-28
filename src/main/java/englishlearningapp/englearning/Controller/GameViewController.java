package englishlearningapp.englearning.Controller;

import javafx.event.ActionEvent;
import java.io.IOException;

public class GameViewController {
    public GameViewController() throws IOException {
    }

  //  @FXML
    public void clickSearch (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.searchRoot);
    }
    public void clickTranslate (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.translateRoot);
    }
}
