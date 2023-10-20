package englishlearningapp.englearning.API_Connection;

import javafx.concurrent.Task;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TranslateInitTask extends Task<HttpURLConnection> {
    private String langfrom;
    private String langto;
    private String text;
    private HttpURLConnection connection;

    public TranslateInitTask(String langfrom, String langto, String text) {
        this.langfrom = langfrom;
        this.langto = langto;
        this.text = text;
    }
    @Override
    protected HttpURLConnection call() throws Exception {
        String urlString = "https://script.google.com/macros/s/AKfycbxC0KJMUCQPJr05hz-oBxixClQJ59vL0BYPvih3-ed8fTRfU2pxuUIu6K4slOtSYf68/exec"
                + "?q="
                + URLEncoder.encode(text, "UTF-8")
                + "&target=" + langto
                + "&source=" + langfrom;

        URL url =new URL(urlString);
        connection =(HttpURLConnection)url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        return connection;
    }
}
