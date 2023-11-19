package englishlearningapp.englearning.Game;

import englishlearningapp.englearning.questionGame.GameTimer;
import javafx.animation.RotateTransition;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.TimerTask;

public class Game {
    private GameTimer gameTimer;

    public void startGame(int time, TextArea timerNumber, Circle c1, Runnable onTimerEnd) {
        gameTimer = new GameTimer(time);
        handleTimerTask(time, timerNumber, c1, onTimerEnd);
    }

    public void handlePlayerAnswer(String playerAnswer, TextArea answerTextArea, TextField playerAnswerTextField) throws IOException {
        // Xử lý câu trả lời từ người chơi
        // Logic xử lý câu trả lời ở đây...
    }

    private void handleTimerTask(int time, TextArea timerNumber, Circle c1, Runnable onTimerEnd) {
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
        // Thực hiện các tác vụ cần thiết dựa trên TimerTask
    }
}
