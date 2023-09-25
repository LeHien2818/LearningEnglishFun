module englishlearningapp.englearning {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens englishlearningapp.englearning to javafx.fxml;
    exports englishlearningapp.englearning;
    exports englishlearningapp.englearning.Controller;
    opens englishlearningapp.englearning.Controller to javafx.fxml;
}