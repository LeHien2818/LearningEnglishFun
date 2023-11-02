package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.DictionaryPackage.Question_answer_gramma;
import englishlearningapp.englearning.DictionaryPackage.Question_answer_vocab;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class GrammarViewController extends GameViewController {

    private int currentQuestionIndex = -1;
    private String question;

    @FXML
    private TextArea question1;

    @FXML
    private TextArea question2;

    @FXML
    private TextArea question3;

    @FXML
    private TextArea question4;

    @FXML
    private TextArea question5;

    int countProgressIndicator = 0;

    @FXML
    private RadioButton submitRadioButton1;
    @FXML
    private RadioButton submitRadioButton2;
    @FXML
    private RadioButton submitRadioButton3;
    @FXML
    private RadioButton submitRadioButton4;
    @FXML

    private RadioButton submitRadioButton5;
    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private ToggleGroup $cau1;


    @FXML
    public void clickSubmit(ActionEvent event) throws IOException {
        AlertController.alertSubmit(event);
    }

    public void initialize() {
        loadquestion();
    }

    public void loadquestion() {
        Question_answer_gramma questionAnswerGramma = new Question_answer_gramma();
//        currentQuestionIndex++; // Tăng biến đếm câu hỏi
//        if (currentQuestionIndex < questionAnswerGramma.questions.length) {
//
//            String question = questionAnswerGramma.getQuestion(currentQuestionIndex);
        for (currentQuestionIndex = 0; currentQuestionIndex < 5; currentQuestionIndex++)
            // Đặt câu hỏi lên TextArea tương ứng
        {
            switch (currentQuestionIndex) {
                case 0: {
                     question = questionAnswerGramma.getQuestion(currentQuestionIndex);
                    question1.setText(question);
                    String correctAnswer = questionAnswerGramma.getCorrectAnswer(currentQuestionIndex);
                    Random rd = new Random(4);
                    break;
                }
                case 1:
                     question = questionAnswerGramma.getQuestion(currentQuestionIndex);
                    question2.setText(question);
                    break;
                case 2:
                     question = questionAnswerGramma.getQuestion(currentQuestionIndex);

                    question3.setText(question);
                    break;
                case 3:
                     question = questionAnswerGramma.getQuestion(currentQuestionIndex);

                    question4.setText(question);
                    break;
                case 4:
                     question = questionAnswerGramma.getQuestion(currentQuestionIndex);
                    question5.setText(question);
                    break;
            }
        }

    }

    @FXML
    public void clickRadio(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) event.getSource();

        if (selectedRadioButton != null) {
            String submitButtonId = selectedRadioButton.getId();
            String checkRadio = submitButtonId.substring(0, 4);
//            String checkLogic = submitButtonId.substring(4,5);
//            System.out.println(checkLogic);
//            System.out.println(checkRadio);

            switch (checkRadio) {
                case "cau1":
                    submitRadioButton1.setSelected(true);
                    submitRadioButton1.setMouseTransparent(false);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;
                case "cau2":
                    submitRadioButton2.setSelected(true);
                    submitRadioButton2.setMouseTransparent(false);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;
                case "cau3":
                    submitRadioButton3.setSelected(true);
                    submitRadioButton3.setMouseTransparent(false);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;
                case "cau4":
                    submitRadioButton4.setSelected(true);
                    submitRadioButton4.setMouseTransparent(false);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;
                case "cau5":
                    submitRadioButton5.setSelected(true);
                    submitRadioButton5.setMouseTransparent(false);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;
            }
        }
    }

    @FXML
    public void clicksubmitRadio(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) event.getSource();
        if (selectedRadioButton != null) {
            String submitButtonId = selectedRadioButton.getId();
            // System.out.println(selectedRadioButton.getId());

            switch (submitButtonId) {
                case "submitRadioButton1":

                    //them chuc nang neu nhan lai (bo danh dau) thi cac cau tra loi sẽ bi xoa
                    submitRadioButton1.setMouseTransparent(true);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;

                case "submitRadioButton2":
                    submitRadioButton2.setMouseTransparent(true);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;
                case "submitRadioButton3":

                    submitRadioButton3.setMouseTransparent(true);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;
                case "submitRadioButton4":

                    submitRadioButton4.setMouseTransparent(true);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;
                case "submitRadioButton5":

                    submitRadioButton5.setMouseTransparent(true);
                    countProgressIndicator = checkProgressIndicator();
                    progressIndicator.setProgress(countProgressIndicator * 0.2);
                    break;
            }
        }
    }

    public int checkProgressIndicator() {
        int count = 0;
        if (submitRadioButton1.isSelected()) count++;
        if (submitRadioButton2.isSelected()) count++;
        if (submitRadioButton3.isSelected()) count++;
        if (submitRadioButton4.isSelected()) count++;
        if (submitRadioButton5.isSelected()) count++;
        return count;
    }
}
