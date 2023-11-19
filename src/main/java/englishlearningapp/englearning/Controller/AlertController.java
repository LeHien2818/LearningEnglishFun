package englishlearningapp.englearning.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.image.Kernel;
import java.io.IOException;
import java.util.Optional;

public class AlertController {

    public static void alertSubmit(ActionEvent event, String text, double Point) throws IOException {
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

    public static void AlertPoint(ActionEvent event, double point) throws IOException {
        Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
        newAlert.setTitle("Thông báo");
        newAlert.setHeaderText(null);
        newAlert.setContentText("Your Score: " + point);
        ButtonType buttonTypeYes = new ButtonType("OKE", ButtonBar.ButtonData.YES);

        newAlert.getButtonTypes().setAll(buttonTypeYes);
        Optional<ButtonType> result = newAlert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeYes) {
            SceneController.switchScene(event, SceneController.gameRoot);
        }
    }

    public static void CustomAlert(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Từ bạn thêm vào đã tồn tại");
        ButtonType buttonTypeYes = new ButtonType("Thử lại", ButtonBar.ButtonData.YES);

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

    public static void alertWrong(ActionEvent event, String text) throws IOException {
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

    public static void alertEndGame(ActionEvent event, String text) throws IOException {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(text);
        ButtonType buttonTypeYes = new ButtonType("OKE", ButtonBar.ButtonData.YES);

        alert.getButtonTypes().setAll(buttonTypeYes);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeYes) {
            SceneController.switchScene(event, SceneController.gameRoot);
        }
    }

    public static void alertEndGame(KeyEvent event, String text) throws IOException {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(text);
        ButtonType buttonTypeYes = new ButtonType("OKE", ButtonBar.ButtonData.YES);

        alert.getButtonTypes().setAll(buttonTypeYes);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeYes) {
            SceneController.switchScene(event, SceneController.gameRoot);
        }
    }
//    public static void alertEndGame(ActionEvent event, String text) throws IOException {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Thông báo");
//        alert.setHeaderText(null);
//        alert.setContentText(text);
//        Optional<ButtonType> result = alert.showAndWait();
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> {
//            alert.close(); // Đóng cửa sổ Alert sau 10 giây
//            // Thêm hành động khác sau khi đóng Alert (nếu cần)
//        }));
//        timeline.setCycleCount(1); // Chỉ chạy một lần
//        timeline.play();
//    }
}
