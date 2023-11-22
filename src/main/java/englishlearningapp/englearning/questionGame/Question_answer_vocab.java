package englishlearningapp.englearning.questionGame;

import englishlearningapp.englearning.JDBCConnection.JDBC_Connect;
import englishlearningapp.englearning.JDBCConnection.JDBC_RetrieveData;
import javafx.concurrent.Task;

import java.sql.SQLException;
import java.util.List;
import java.util.Queue;
import java.util.Random;

    public class Question_answer_vocab  {

        private Random random = new Random();
        private int randomIndex;
        /*private String[] question = {
                "Apple",
                "Banana",
                "Orange",
                "Grapes",
                "Mango",
                "Strawberry",
                "Pineapple",
                "Cucumber",
                "Peach",
                "Blueberry"
        };*/
        private List<String> question;
        private List<String> answer;
        private List<String> ipa ;
        public Question_answer_vocab() throws SQLException {
            /*Thread th = new Thread(new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                    return null;
                }
            });
            th.setDaemon(true);
            th.start();*/
            JDBC_RetrieveData.retrieveQuestionWords();
            JDBC_RetrieveData.retrieveQuestionIPA();
            JDBC_RetrieveData.retrieveQuestionMeaning();
            question = JDBC_RetrieveData.getQuestionWords();
            answer = JDBC_RetrieveData.getQuestionMeaning();
            ipa = JDBC_RetrieveData.getQuestionIPA();
        }
        public String getQuestion(int index) {

            return question.get(index);
        }

        public String getAnswer(int index) {
            return answer.get(index);
        }
        public int getRandom() {
            return this.randomIndex;
        }

        public void setRandom(int size) {
            this.randomIndex = this.random.nextInt(size - 1) + 1;
        }

        public String getrandomAnswer() {
            setRandom(10);
            int index = getRandom();
            return answer.get(index);
        }
    }
