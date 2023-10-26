package englishlearningapp.englearning.Controller;

import animatefx.animation.FadeIn;
import animatefx.animation.SlideInRight;
import animatefx.animation.SlideInUp;
import englishlearningapp.englearning.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SceneController {
    protected static Stage stage;
    protected static Scene scene ;

    protected static AnchorPane searchRoot;

    static {
        try {
            searchRoot = FXMLLoader.load(App.class.getResource("Views/LookingUpView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static AnchorPane gameRoot;

    static {
        try {
            gameRoot = FXMLLoader.load(App.class.getResource("Views/GameView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static AnchorPane translateRoot;

    static {
        try {
            translateRoot = FXMLLoader.load(App.class.getResource("Views/TranslateView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected static AnchorPane vocabRoot;

    static {
        try {
            vocabRoot = FXMLLoader.load(App.class.getResource("Views/VocabView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected static AnchorPane grammarRoot;

    static {
        try {
            grammarRoot = FXMLLoader.load(App.class.getResource("Views/GrammarView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected static AnchorPane connectRoot;

    static {
        try {
            connectRoot = FXMLLoader.load(App.class.getResource("Views/VocabView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static AnchorPane exitRoot;

    static {
        try {
            exitRoot = FXMLLoader.load(App.class.getResource("Views/GameView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static AnchorPane addViewRoot;
    static {
        try {
            addViewRoot = FXMLLoader.load(App.class.getResource("Views/AddwordView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static AnchorPane modifyViewRoot;
    static {
        try {
            modifyViewRoot = FXMLLoader.load(App.class.getResource("Views/ModifyWordView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public SceneController() throws IOException {
    }

    public static void switchScene (ActionEvent event, Parent sceneSwitch) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = ((Node)event.getSource()).getScene();
        new FadeIn(sceneSwitch).play();
        scene.setRoot(sceneSwitch);
        scene.getStylesheets().add(App.class.getResource("src/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public static Scene getCurrentScene (ActionEvent event) {
        return ((Node)event.getSource()).getScene();
    }
    public static Scene getCurrentScene (KeyEvent event) {
        return ((Node)event.getSource()).getScene();
    }
    public static Stage getCurrentStage (ActionEvent event) {
        return (Stage)((Node)event.getSource()).getScene().getWindow();
    }
    public static Stage getCurrentStage (KeyEvent event) {
        return (Stage)((Node)event.getSource()).getScene().getWindow();
    }
    public static AnchorPane getCurrentPane(ActionEvent event) {
        Scene tmpScene = ((Node)event.getSource()).getScene();
        return  (AnchorPane)tmpScene.getRoot();
    }
    public static AnchorPane getCurrentPane(KeyEvent event) {
        Scene tmpScene = ((Node)event.getSource()).getScene();
        return  (AnchorPane)tmpScene.getRoot();
    }
    public static void updateScene(KeyEvent event,String operation, Node item){
        if(Objects.equals(operation, "add")) {
            getCurrentPane(event).getChildren().add(item);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = ((Node)event.getSource()).getScene();
            scene.setRoot(getCurrentPane(event));
            stage.setScene(scene);
            stage.show();
        }else {
            Node deleteItem = getCurrentPane(event).lookup(item.toString());
            getCurrentPane(event).getChildren().removeAll(deleteItem);
        }
    }
}
