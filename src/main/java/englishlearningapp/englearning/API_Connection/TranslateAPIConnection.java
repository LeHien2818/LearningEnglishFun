package englishlearningapp.englearning.API_Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TranslateAPIConnection {
    private static HttpURLConnection connection ;
    public static String translateText(String langFrom, String langTo, String text) throws Exception {
        TranslateInitTask task = new TranslateInitTask(langFrom, langTo, text);
        Thread th = new Thread(task);
        th.setDaemon(true);
        connection = task.call();
        th.start();
        BufferedReader input =new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder reponse =new StringBuilder();
        String line;
        while ((line = input.readLine()) != null){
            reponse.append(line);
        }
        input.close();
        return reponse.toString();
    }
    public static void main(String[] args) throws Exception {
        System.out.println(translateText("en", "vi", "This is a piece of text, can you translate it?"));

    }
}
