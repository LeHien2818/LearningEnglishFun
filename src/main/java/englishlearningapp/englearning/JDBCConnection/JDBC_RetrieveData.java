package englishlearningapp.englearning.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

public class JDBC_RetrieveData extends JDBC_Connect{
    private static TreeMap<Integer, String> dataWords = new TreeMap<>();
    public static void retrieveData() throws SQLException {
        Connection connection =  getJDBCConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT word FROM dicttable";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int rowNum = resultSet.getRow();
            String wordName = resultSet.getString("word");
            dataWords.put(rowNum, wordName);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static TreeMap<Integer, String> getDataWords() {
        return dataWords;
    }

    public void setDataWords(TreeMap<Integer, String> dataWords) {
        this.dataWords = dataWords;
    }
    public static void main (String[] args) throws SQLException {
        int i = 0;
        retrieveData();
        for(Map.Entry<Integer, String> entry : dataWords.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            i++;
            if(i >= 5) break;
        }
    }
}
