package englishlearningapp.englearning.DictionaryPackage;

import englishlearningapp.englearning.JDBCConnection.JDBC_RetrieveData;

import java.sql.SQLException;
import java.util.*;

public class Dictionary extends ArrayList<Word> {
    public Dictionary() throws SQLException {
        JDBC_RetrieveData.retrieveWordData();
        JDBC_RetrieveData.retrievePronunciation();
        JDBC_RetrieveData.retrieveDefinition();
        TreeMap<Integer,String> inputWords = JDBC_RetrieveData.getDataWords();
        HashMap<Integer, String> inputPronuns = JDBC_RetrieveData.getPronuntiations();
        HashMap<Integer,String> inputDefs = JDBC_RetrieveData.getDefinitons();

        for (Map.Entry<Integer,String> entry : inputWords.entrySet()) {
            Word word = new Word();
            word.setId(entry.getKey());
            word.setName(entry.getValue());
            word.setPronunciation(inputPronuns.get(entry.getKey()));
            word.setDefinition(inputDefs.get(entry.getKey()));
            this.add(word);
        }
    }

}
