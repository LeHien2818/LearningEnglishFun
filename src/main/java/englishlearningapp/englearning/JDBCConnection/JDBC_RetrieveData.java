package englishlearningapp.englearning.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JDBC_RetrieveData extends JDBC_Connect{
    private static TreeMap<Integer, String> dataWords = new TreeMap<>();
    private static HashMap<Integer, String> pronuntiations = new HashMap<>();
    private static HashMap<Integer, String> definitons = new HashMap<>();
    public static void retrieveWordData() throws SQLException {
        Connection connection = getJDBCConnection();
        Statement statement = connection.createStatement();
        String queryName = "SELECT word FROM dicttable";
        ResultSet resultSetName = statement.executeQuery(queryName);
        while (resultSetName.next()) {
            int rowNum = resultSetName.getRow();
            String wordName = resultSetName.getString("word");
            dataWords.put(rowNum, wordName);
        }
        resultSetName.close();
        statement.close();
        connection.close();
    }
    public static void retrievePronunciation () throws SQLException {
        Connection connection = getJDBCConnection();
        Statement statement = connection.createStatement();
        String queryPronunciation = "SELECT pronunciation FROM dicttable";
        ResultSet resultSetPronounce = statement.executeQuery(queryPronunciation);
        while (resultSetPronounce.next()) {
            int rowNum = resultSetPronounce.getRow();
            String wordPronounce = resultSetPronounce.getString("pronunciation");
            pronuntiations.put(rowNum, wordPronounce);
        }
        resultSetPronounce.close();
        statement.close();
        connection.close();
    }
    public static void retrieveDefinition () throws SQLException {
        Connection connection = getJDBCConnection();
        Statement statement = connection.createStatement();
        String queryDefinition = "SELECT definition FROM dicttable";
        ResultSet resultSetDefinition = statement.executeQuery(queryDefinition);
        while (resultSetDefinition.next()) {
            int rowNum = resultSetDefinition.getRow();
            String wordPronounce = resultSetDefinition.getString("definition");
            definitons.put(rowNum, wordPronounce);
        }
        resultSetDefinition.close();
        statement.close();
        connection.close();
    }
    public static TreeMap<Integer, String> getDataWords() {
        return dataWords;
    }

    public void setDataWords(TreeMap<Integer, String> dataWords) {
        this.dataWords = dataWords;
    }

    public static HashMap<Integer, String> getPronuntiations() {
        return pronuntiations;
    }

    public static void setPronuntiations(HashMap<Integer, String> pronuntiations) {
        JDBC_RetrieveData.pronuntiations = pronuntiations;
    }

    public static HashMap<Integer, String> getDefinitons() {
        return definitons;
    }

    public static void setDefinitons(HashMap<Integer, String> definitons) {
        JDBC_RetrieveData.definitons = definitons;
    }

    public static void main (String[] args) throws SQLException {
        int i = 0;
        retrieveWordData();
        retrievePronunciation();
        retrieveDefinition();
        for(Map.Entry<Integer , String> entry : dataWords.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            i++;
            if(i >= 5) break;
        }
    }
}
