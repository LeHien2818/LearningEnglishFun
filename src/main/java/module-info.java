module englishlearningapp.englearning {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.java;
    requires voicerss.tts;
    requires java.desktop;

    opens englishlearningapp.englearning to javafx.fxml;
    exports englishlearningapp.englearning;
    exports englishlearningapp.englearning.Controller;
    opens englishlearningapp.englearning.Controller to javafx.fxml;
    exports englishlearningapp.englearning.Animation;
    opens englishlearningapp.englearning.Animation to javafx.fxml;
}