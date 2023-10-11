package englishlearningapp.englearning.DictionaryPackage;

import englishlearningapp.englearning.JDBCConnection.JDBC_RetrieveData;

import java.sql.SQLException;
import java.util.*;

public class Dictionary extends ArrayList<Word> {
    public Dictionary() throws SQLException {
        JDBC_RetrieveData.retrieveWordData();
        JDBC_RetrieveData.retrievePronunciation();
        JDBC_RetrieveData.retrieveDefinition();
        TreeMap<String,Integer> inputWords = JDBC_RetrieveData.getDataWords();
        HashMap<Integer, String> inputPronuns = JDBC_RetrieveData.getPronuntiations();
        HashMap<Integer,String> inputDefs = JDBC_RetrieveData.getDefinitons();

        for (Map.Entry<String,Integer> entry : inputWords.entrySet()) {
            Word word = new Word();
            word.setId(entry.getValue());
            word.setName(entry.getKey());
            word.setPronunciation(inputPronuns.get(entry.getValue()));
            word.setDefinition(inputDefs.get(entry.getValue()));
            this.add(word);
        }
    }

}
