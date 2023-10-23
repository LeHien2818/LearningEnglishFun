package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.App;
import englishlearningapp.englearning.DictionaryPackage.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ModifyController {
    @FXML
    private TextArea nameArea;
    @FXML
    private TextArea pronunciationArea;
    @FXML
    private TextArea definitionArea;
    public TextArea getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea.setText(nameArea);
    }

    public TextArea getPronunciationArea() {
        return pronunciationArea;
    }

    public void setPronunciationArea(String pronunciationArea) {
        this.pronunciationArea.setText(pronunciationArea);
    }

    public TextArea getDefinitionArea() {
        return definitionArea;
    }

    public void setDefinitionArea(String definitionArea) {
        this.definitionArea.setText(definitionArea);
    }

    public void modify(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("Views/LookingUpView.fxml"));
        AnchorPane searchRoot = loader.load();
        LookingUpController controller = loader.getController();
        String wordSelected = nameArea.getText();
        Word find = new Word();
        find.setName(wordSelected);
        int idSelected = App.getDictionary().findWord(find);
        App.getDictionary().get(idSelected).setPronunciation(pronunciationArea.getText());
        App.getDictionary().get(idSelected).setDefinition(definitionArea.getText());
        controller.setTextInput(wordSelected);
        controller.setDefinitionArea(pronunciationArea.getText()
                + "\n" + definitionArea.getText());
        SceneController.switchScene(event, searchRoot);
    }

    public void exit(ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.searchRoot);
    }
}
