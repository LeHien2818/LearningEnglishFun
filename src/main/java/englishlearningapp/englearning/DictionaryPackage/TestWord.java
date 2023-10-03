package englishlearningapp.englearning.DictionaryPackage;

import java.sql.SQLException;

public class TestWord {
    public static void main(String[] args) throws SQLException {
        Dictionary dict = new Dictionary();
        dict.getWords();
        for(int i = 0; i < 5; i++) {
            System.out.println(dict.get(i).getName() + " " + dict.get(i).getPronunciation());
        }
    }
}
