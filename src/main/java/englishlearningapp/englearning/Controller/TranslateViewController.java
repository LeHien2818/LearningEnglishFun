package englishlearningapp.englearning.Controller;

import javafx.event.ActionEvent;
import java.io.IOException;

public class TranslateViewController{
    public TranslateViewController() throws IOException {
    }
    public void clickGame (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickSearch (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.searchRoot);
    }
}
