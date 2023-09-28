package englishlearningapp.englearning.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class DefaultViewController {
    public DefaultViewController() throws IOException {
    }

    @FXML
    public void clickSearch (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.searchRoot);
    }
    public void clickGame (ActionEvent event) throws IOException{
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickTranslate (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.translateRoot);
    }


}
