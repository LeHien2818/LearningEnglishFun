package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.questionGame.BotAnswerGenerator;
import englishlearningapp.englearning.questionGame.GameTimer;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.util.Duration;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimerTask;

import static englishlearningapp.englearning.Controller.ConnectController.c1;

public class ConnectGame   {
    private TimerTask currentTask;

    final GameTimer gmt;
    {
        try {
            gmt = new GameTimer(8);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    static final List<String> EnteredWord = new ArrayList<>();

    static boolean checkEnterWord(String word) {
        for (int i = 0; i < EnteredWord.size() - 1; i++) {
            if (EnteredWord.get(i).equals(word)) return false;
        }
        return true;
    }

//    @Override
//    public void startGame() throws IOException {
//
//    }
//
//    @Override
//    public void resetGame() {
//
//    }
//
//    @Override
//    public void handleGame(KeyEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
//
//    }
//
//    @Override
//    public void playTimer(KeyEvent eventkey) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
//        gmt.stopAudio();
//        final int[] counter = {8};
//        gmt.playAudio();
//
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                if (counter[0] >= 0) {
//                    counter[0]--;
//
//                } else {
//                    Platform.runLater(() -> {
//                        try {
//
//                            resetGame();
//
//
//                            AlertController.alertEndGame(eventkey,"YOU LOSE");
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//                    gmt.getTimer().cancel();
//                }
//
//            }
//
//        };
//
//        if (currentTask != null) {
//            currentTask.cancel();
//        }
//        currentTask = timerTask;
//        gmt.excuteTask(currentTask);
//        setRotate(ConnectController.c1, false, 360, 8);
//
//    }
//    public static void setRotate(Circle c, boolean reverse, int angle, int duration) {
//        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);
//        rt.setAutoReverse(reverse);
//        rt.setByAngle(angle);
//        rt.setDelay(Duration.millis(0));
//        rt.setRate(duration);
//        rt.setCycleCount(duration + 1);
//        rt.play();
//    }

}
