package englishlearningapp.englearning.TextToSpeech;

import com.voicerss.tts.*;
import com.voicerss.tts.AudioFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class TTS {
    final private static VoiceProvider tts = new VoiceProvider("6f6bfb4a94174cd5b18f29d6febe6d6b");

    public static void initApiVoice(String text) throws Exception {
        VoiceParameters params = new VoiceParameters(text, Languages.English_UnitedStates);
        params.setCodec(AudioCodec.WAV);
        params.setFormat(AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
        params.setBase64(false);
        params.setSSML(false);
        params.setRate(0);

        byte[] voice = tts.speech(params);
        FileOutputStream fos = new FileOutputStream("voice.wav");
        fos.write(voice, 0, voice.length);
        fos.flush();
        fos.close();
    }

    public static void playSpeaker() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File music = new File("voice.wav");
        Scanner sc = new Scanner(System.in);
        AudioInputStream ad = AudioSystem.getAudioInputStream(music);
        Clip clip = AudioSystem.getClip();
        clip.open(ad);
        clip.start();
    }
    public static void main (String args[]) throws Exception {


    }
}
