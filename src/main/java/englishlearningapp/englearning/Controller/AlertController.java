package englishlearningapp.englearning.Controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Optional;

public class AlertController {
    public static void alertSubmit(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Bạn có muốn hoàn thành bài thi");
        ButtonType buttonTypeYes = new ButtonType("YES", ButtonBar.ButtonData.YES);

        // Tạo nút NO
        ButtonType buttonTypeNo = new ButtonType("NO", ButtonBar.ButtonData.NO);


        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeYes) {
            Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
            newAlert.setTitle("Thông báo");
            newAlert.setHeaderText(null);
            newAlert.setContentText("Điểm của bạn là");
            ButtonType buttonTypeExit = new ButtonType("EXIT");
            newAlert.getButtonTypes().setAll(buttonTypeExit);

            Optional<ButtonType> newResult = newAlert.showAndWait();

            if (newResult.isPresent() && newResult.get() == buttonTypeExit) {
                SceneController.switchScene(event, SceneController.gameRoot);
            }
        } else {
            alert.close();
        }

    }

    public static void CustomAlert (ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Từ bạn thêm vào đã tồn tại");
        ButtonType buttonTypeYes = new ButtonType("Thử lại", ButtonBar.ButtonData.YES);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeYes) {
            alert.close();
        }
    }

}
