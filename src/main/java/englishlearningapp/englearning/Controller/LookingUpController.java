package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.DictionaryPackage.Dictionary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class LookingUpController {
    @FXML
    private TextField textInput;
    private Dictionary dictionary = new Dictionary();
    public LookingUpController() throws IOException {
    }

    public void clickGame (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickTranslate (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.translateRoot);
    }

    public void inputWordHanddle () throws SQLException {
        dictionary.getWords();
        ObservableList<String> wordNames = FXCollections.observableArrayList();
        for (int i = 0; i < dictionary.size(); i++){
            wordNames.add(dictionary.get(i).getName());
        }
        ListView<String> resultListView = new ListView<>();
        textInput.setOnKeyReleased((KeyEvent event) -> {
            String queryString = textInput.getText().toLowerCase();
            ObservableList<String> filteredList = FXCollections.observableArrayList();

            for(String wordName : wordNames) {
                if(wordName.toLowerCase().startsWith(queryString)){
                    filteredList.add(wordName);
                }
            }
            resultListView.getStyleClass().add("wordListView");
            resultListView.setItems(filteredList);
            SceneController.updateScene(event,"add",resultListView);
        });
    }
}
