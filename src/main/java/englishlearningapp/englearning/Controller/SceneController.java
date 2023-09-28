package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    protected static Stage stage;
    protected static Scene scene ;
    protected static Parent searchRoot;

    static {
        try {
            searchRoot = FXMLLoader.load(App.class.getResource("Views/LookingUpView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static Parent gameRoot;

    static {
        try {
            gameRoot = FXMLLoader.load(App.class.getResource("Views/GameView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static Parent translateRoot;

    static {
        try {
            translateRoot = FXMLLoader.load(App.class.getResource("Views/TranslateView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SceneController() throws IOException {
    }

    public static void switchScene (ActionEvent event, Parent sceneSwitch) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = ((Node)event.getSource()).getScene();
        scene.setRoot(sceneSwitch);
        scene.getStylesheets().add(App.class.getResource("src/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
