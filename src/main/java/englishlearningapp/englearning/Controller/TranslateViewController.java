package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.API_Connection.TranslateAPIConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class TranslateViewController{
    @FXML
    private TextArea inputText;
    @FXML
    private TextArea outputText;
    public TranslateViewController() throws IOException {
    }
    public void clickGame (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickSearch (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.searchRoot);
    }
    public void onTyping (KeyEvent event) {
        inputText.setOnKeyReleased((ke) -> {
            try {
               String res = TranslateAPIConnection.translateText("vi", "en", inputText.getText());
               outputText.setText(res);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
