package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.API_Connection.TranslateAPIConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class TranslateViewController{
    private String inputStatus = "vi";
    private String outputStatus = "en";
    @FXML
    private TextArea inputText;
    @FXML
    private TextArea outputText;
    @FXML
    private TextArea inputLang;
    @FXML
    private TextArea outputLang;
    public TranslateViewController() throws IOException {
    }
    public void clickGame (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickSearch (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.searchRoot);
    }

    public void onTranslate() throws IOException {
        String translation = inputText.getText();
        String res = "";
        if(inputLang.getText().equals("")) {
            inputLang.setText(inputStatus);
            outputLang.setText(outputStatus);
             res = TranslateAPIConnection.translateText("vi", "en", translation);
        }else if (inputLang.getText().equals("vi")) {
             res = TranslateAPIConnection.translateText("vi", "en", translation);
        }else {
             res = TranslateAPIConnection.translateText("en", "vi", translation);
        }
        outputText.setText(res);
    }

    public void switchLanguage() {
        if(inputLang.getText().equals("vi")) {
            inputLang.setText("en");
            outputLang.setText("vi");
        }else {
            inputLang.setText("vi");
            outputLang.setText("en");
        }
    }
}
