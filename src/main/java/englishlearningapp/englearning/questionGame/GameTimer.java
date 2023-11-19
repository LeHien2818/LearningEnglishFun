package englishlearningapp.englearning.questionGame;

import englishlearningapp.englearning.App;
import englishlearningapp.englearning.Controller.ConnectController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    private Timer timer = new Timer();
    private int counter;
    private Clip clip;
    public GameTimer () {

    }
    public GameTimer (int countdown) {
        counter = countdown;
    }

    public int getCounter() {
        return counter;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void excuteTask(TimerTask timerTask) throws IOException {
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
    public void playAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //File music = new File();
        AudioInputStream ad = AudioSystem.getAudioInputStream(App.class.getResource("src/sounds/mixkit-alarm-clock-beep-988.wav"));
        clip = AudioSystem.getClip();
        clip.open(ad);
        clip.start();
    }
    public void stopAudio() {
        clip.close();
    }
    public static void main(String[] args) {
        /*System.out.println("Starting up...");

        //one-time use timer: prints stuff after 10s
        final int[] counter = {10};
        Timer myTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(counter[0] > 0) {
                    System.out.println(counter[0]);
                    counter[0] --;
                }else {
                    myTimer.cancel();
                }
            }
        };
        //myTimer.schedule(task, 0);
        //repeating timer: prints stuff every 10s
        Timer myRepeatingTimer = new Timer();
        myRepeatingTimer.scheduleAtFixedRate(task, 0, 1000);*/
    }

}
