//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.DictionaryPackage.Question_answer;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class VocabViewController extends GameViewController {
    @FXML
    private TextArea questionVocab;
    @FXML
    private Button answerA;
    @FXML
    private Button answerB;

    public VocabViewController() throws IOException {
    }

    public void clickAnswer(ActionEvent event) throws IOException {
        this.setTextScore(this.toString(this.getScore()));
        int questionnumber = this.getQuesNumber();
        int scoretmp = this.getScore();
        if (questionnumber <= 10) {
            Question_answer questionAnswer = new Question_answer();
            this.setRandom(10);
            int index = this.getRandom();
            this.questionVocab.setText(questionAnswer.getQuestion(index));
            this.setRandom(100);
            int countAnswer = this.getRandom();
            String correctAnswer = questionAnswer.getAnswer(index);
            String selectedAnswer = "";
            if (countAnswer %2 == 1) {
                this.answerA.setText(correctAnswer);
                this.answerB.setText(questionAnswer.getrandomAnswer());
            } else {
                this.answerA.setText(questionAnswer.getrandomAnswer());
                this.answerB.setText(correctAnswer);
            }

            if (event.getSource() == this.answerA) {
                selectedAnswer = this.answerA.getText();
            } else if (event.getSource() == this.answerB) {
                selectedAnswer = this.answerB.getText();
            }

            if (selectedAnswer.equals(correctAnswer)) {
                ++scoretmp;
                this.setScore(scoretmp);
            }

            SceneController.switchScene(event, SceneController.vocabRoot);
            this.setTextScore(this.toString(scoretmp));
            ++questionnumber;
            this.setQuesNumber(questionnumber);
        } else {
            String s = "vocab";
            this.endGame(event, s);
        }

    }


}
