package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.Controller.GameViewController;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

public class AlertController {
    public static void alertSubmit(javafx.event.ActionEvent event, String text, double Point) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(text);
        ButtonType buttonTypeYes = new ButtonType("YES", ButtonBar.ButtonData.YES);

        // Tạo nút NO
        ButtonType buttonTypeNo = new ButtonType("NO", ButtonBar.ButtonData.NO);


        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeYes) {
            AlertPoint(event, Point);
        } else {
            alert.close();
        }

    }

    public static void AlertPoint(ActionEvent event, double Point) throws IOException {
        Alert newAlert = new Alert(AlertType.INFORMATION);
        newAlert.setTitle("Thông báo");
        newAlert.setHeaderText(null);
        newAlert.setContentText("Your Score: " + Point);
        Optional<ButtonType> newResult = newAlert.showAndWait();
        SceneController.switchScene(event, SceneController.gameRoot);
    }

    public static void alertExit(javafx.event.ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Do you want exit");
        ButtonType buttonTypeYes = new ButtonType("YES", ButtonBar.ButtonData.YES);

        // Tạo nút NO
        ButtonType buttonTypeNo = new ButtonType("NO", ButtonBar.ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeYes) {
            SceneController.switchScene(event, SceneController.gameRoot);
        } else {
            alert.close();
        }

    }
    public static void alertWrong(javafx.event.ActionEvent event, String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(text);
        ButtonType buttonTypeYes = new ButtonType("OKE", ButtonBar.ButtonData.YES);

        alert.getButtonTypes().setAll(buttonTypeYes);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeYes) {
            alert.close();
        }
    }

}
