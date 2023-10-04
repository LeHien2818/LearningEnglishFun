package englishlearningapp.englearning.API_Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class APIConnection {
    public static HttpURLConnection getTranslateApiCon (String langFrom, String langTo, String text) throws IOException {
        String urlString = "https://script.google.com/macros/s/AKfycbxC0KJMUCQPJr05hz-oBxixClQJ59vL0BYPvih3-ed8fTRfU2pxuUIu6K4slOtSYf68/exec"
                + "?q="
                + URLEncoder.encode(text, "UTF-8")
                + "&target=" + langTo
                + "&source=" + langFrom;

        URL url =new URL(urlString);
        HttpURLConnection connection =(HttpURLConnection)url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        return connection;
    }
    public static String translateText(String langFrom, String langTo, String text) throws IOException {
        HttpURLConnection connection = getTranslateApiCon(langFrom, langTo, text);
        //connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader input =new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder reponse =new StringBuilder();
        String line;
        while ((line = input.readLine()) != null){
            reponse.append(line);
        }
        input.close();
        return reponse.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.println(getTranslateApiCon("en", "vi", "This is a piece of text, can you translate it?"));
        System.out.println(translateText("en", "vi", "This is a piece of text, can you translate it?"));

    }
}
