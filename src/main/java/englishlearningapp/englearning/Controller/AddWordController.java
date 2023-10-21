package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.App;
import englishlearningapp.englearning.DictionaryPackage.Dictionary;
import englishlearningapp.englearning.DictionaryPackage.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;

import java.io.IOException;

public class AddWordController {
    @FXML
    private TextArea nameArea;
    @FXML
    private TextArea pronunciationArea;
    @FXML
    private TextArea definitionArea;

    public void addWord(Dictionary dictionary, Word word) {
        dictionary.add(word);
        dictionary.sort();
    }

    public void onAddWord(ActionEvent event) {
        if(nameArea.getText().trim().equals("")) return;
        Word word = new Word();
        word.setName(nameArea.getText().trim().toLowerCase());
        word.setPronunciation(pronunciationArea.getText().trim());
        word.setDefinition(definitionArea.getText().trim());
        addWord(App.getDictionary(), word);
        nameArea.setText("");
        pronunciationArea.setText("");
    }
    public void onExit(ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.searchRoot);
    }
    public static void main(String[] args) {

    }

}
