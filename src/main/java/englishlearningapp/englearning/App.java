package englishlearningapp.englearning;

import englishlearningapp.englearning.DictionaryPackage.Dictionary;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kotlin.jvm.internal.PropertyReference0Impl;

import java.sql.SQLException;

public class App extends Application {
    private static Dictionary dictionary;
    public static Dictionary getDictionary(){return dictionary;}
    @Override
    public void init() throws SQLException {
        dictionary = new Dictionary();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/DefaultView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("src/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public static void main (String[] args) {
        launch(args);
    }
}
