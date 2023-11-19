package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.questionGame.GameTimer;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.TimerTask;

public class Game {
    @FXML
    private Circle c1;
    private GameTimer gameTimer;

    public void startGame(int time, TextArea timerNumber, Runnable onTimerEnd) throws IOException {
        gameTimer = new GameTimer(time);
        play(time, timerNumber, onTimerEnd);
    }

    private void play(int time, TextArea timerNumber, Runnable onTimerEnd) throws IOException {
        TimerTask timerTask = new TimerTask() {
            int counter = time;
            @Override
            public void run() {
                if (counter >= 0) {
                    timerNumber.setText(String.valueOf(counter));
                    counter--;
                } else {
                    onTimerEnd.run();
                    gameTimer.getTimer().cancel();
                }
            }
        };
        gameTimer.excuteTask(timerTask);
        setRotate(c1, false, 360, time);
    }
    public void onTimerEnd() {
        Platform.runLater(() -> {
            try {
                AlertController.alertSubmit(new ActionEvent(), "End Game", 5);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setRotate(Circle c, boolean reverse, int angle, int duration) {
        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.millis(0));
        rt.setRate(duration);
        rt.setCycleCount(duration + 1);
        rt.play();
    }

}
