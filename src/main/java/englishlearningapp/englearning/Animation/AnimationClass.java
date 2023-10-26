package englishlearningapp.englearning.Animation;

import englishlearningapp.englearning.Controller.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimationClass implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static void SceneSlideYTransition(ActionEvent event, Parent scenetoSlide) {
        Scene curScene = SceneController.getCurrentScene(event);
        scenetoSlide.translateYProperty().set(curScene.getHeight());
    }
}
