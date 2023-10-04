package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.DictionaryPackage.Dictionary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class LookingUpController {
    @FXML
    private TextField textInput;
    @FXML
    private TextArea definitionArea;

    private Dictionary dictionary = new Dictionary();
    public LookingUpController() throws IOException {
    }

    public void clickGame (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickTranslate (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.translateRoot);
    }

    public void inputWordHanddle (KeyEvent e) throws SQLException {
        dictionary.getWords();
        ListView<String> resultListView = new ListView<>();
        String initializtion = textInput.getText().toLowerCase().trim();
        // Render prefixes.
        ObservableList<String> wordNames = FXCollections.observableArrayList();
        ObservableList<String> initialList = FXCollections.observableArrayList();
        for (int i = 0; i < dictionary.size(); i++){
            wordNames.add(dictionary.get(i).getName());
        }
        for(String wordName : wordNames) {
            if(wordName.toLowerCase().startsWith(initializtion)){
                initialList.add(wordName);
            }
        }
        resultListView.setItems(initialList);
        textInput.setOnKeyReleased((KeyEvent event) -> {
            String queryString = textInput.getText().toLowerCase().trim();
            ObservableList<String> filteredList = FXCollections.observableArrayList();

            for(String wordName : wordNames) {
                if(wordName.toLowerCase().startsWith(queryString)){
                    filteredList.add(wordName);
                }
            }
            resultListView.setItems(filteredList);
        });
        resultListView.getStyleClass().add("wordListView");
        SceneController.updateScene(e,"add",resultListView);
        // Render definition and pronunciation of items.
        resultListView.setOnMouseClicked((MouseEvent event) -> {
            if(event.getClickCount() == 1) {
                String wordSelected = resultListView.getSelectionModel().getSelectedItem();
                for(int i = 0; i < dictionary.size(); i++){
                    if(dictionary.get(i).getName().equals(wordSelected)) {
                        definitionArea.setText(dictionary.get(i).getPronunciation() + "\n" + dictionary.get(i).getDefinition() + "\n");
                        break;
                    }
                }

            }
        });
    }

}
