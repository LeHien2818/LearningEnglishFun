package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.App;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    public void switchScene (ActionEvent event, Parent sceneSwitch) throws IOException {
        root = sceneSwitch;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(App.class.getResource("src/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
