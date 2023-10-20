package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.App;
import englishlearningapp.englearning.DictionaryPackage.Dictionary;
import englishlearningapp.englearning.TextToSpeech.TexttoSpeechTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.sql.SQLException;

public class LookingUpController {
    @FXML
    private TextField textInput;
    @FXML
    private TextArea definitionArea;

    private final Dictionary dictionary = App.getDictionary();
    public LookingUpController() throws IOException, SQLException {
    }

    public void clickGame (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.gameRoot);
    }
    public void clickTranslate (ActionEvent event) throws IOException {
        SceneController.switchScene(event, SceneController.translateRoot);
    }

    public void inputWordHanddle (KeyEvent e) throws SQLException {
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
            String wordSelected;
            Image img = null;
            try {
                img = new Image((App.class.getResource("src/image/speaker.png")).openStream());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ImageView speakerIcon = new ImageView();
            speakerIcon.setImage(img);
            speakerIcon.getStyleClass().add("speaker");
            speakerIcon.setFitHeight(26);
            speakerIcon.setFitWidth(29);
            Pane speakerContainer = new Pane();
            speakerContainer.setPrefWidth(26);
            speakerContainer.setPrefHeight(29);
            speakerContainer.setLayoutX(773);
            speakerContainer.setLayoutY(534);
            speakerContainer.getStyleClass().add("speaker-container");
            if(event.getClickCount() == 1) {
                SceneController.updateScene(e, "add", speakerIcon);
                SceneController.updateScene(e, "add", speakerContainer);
                wordSelected = resultListView.getSelectionModel().getSelectedItem();
                //set Definition area.
                for(int i = 0; i < dictionary.size(); i++){
                    if(dictionary.get(i).getName().equals(wordSelected)) {
                        definitionArea.setText(dictionary.get(i).getPronunciation() + "\n" + dictionary.get(i).getDefinition() + "\n");
                        break;
                    }
                }
                //set speaker.
            } else {
                wordSelected = "";
            }
            try {
                speakerContainer.setOnMouseClicked((MouseEvent mevent) -> {
                    if (mevent.getClickCount() == 1) {
                        TexttoSpeechTask task = new TexttoSpeechTask(wordSelected);
                        Thread th = new Thread(task);
                        th.setDaemon(true);
                        speakerIcon.setDisable(true);
                        /*task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                            @Override
                            public void handle(WorkerStateEvent workerStateEvent) {
                                speakerIcon.setDisable(false);
                            }
                        });*/
                        th.start();

                    }
                });
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

    }

}
