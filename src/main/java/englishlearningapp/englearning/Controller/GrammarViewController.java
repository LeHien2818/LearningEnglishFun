package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.questionGame.Question_answer_gramma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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
    private ToggleGroup cau1;
    @FXML
    private ToggleGroup cau2;
    @FXML
    private ToggleGroup cau3;
    @FXML
    private ToggleGroup cau4;
    @FXML
    private ToggleGroup cau5;

    @FXML
    private RadioButton Answer;

    @FXML
    private RadioButton cau1A;
    @FXML
    private RadioButton cau1B;
    @FXML
    private RadioButton cau1C;
    @FXML
    private RadioButton cau1D;

    private Map<Integer, ToggleGroup> TogglegroupS = new HashMap<>();

    @FXML
    public void clickSubmit(ActionEvent event) throws IOException {
        checkPointGrammar();
        double Point = this.getScore();
        AlertController.alertSubmit(event, null, Point);
    }
    public void initialize() {
        this.setScore(0);
        setTogglegroupS();
        loadquestion();
    }

    public void setTogglegroupS() {
        try {
            for (int i = 1; i <= 5; i++) {
                Field field = this.getClass().getDeclaredField("cau" + i);
                field.setAccessible(true);
                ToggleGroup toggleGroup = (ToggleGroup) field.get(this);
                TogglegroupS.put(i, toggleGroup);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    private ToggleGroup getToggleGroupForQuestion(int questionNumber) {

        switch (questionNumber) {
            case 1:
                return cau1;
            case 2:
                return cau2;
            case 3:
                return cau3;
            case 4:
                return cau4;
            case 5:
                return cau5;
            default:
                throw new IllegalArgumentException("Invalid question number: " + questionNumber);
        }
    }

    public void setAnswerGrammar(String[] options, String questionNumber) {
    }

    public void checkPointGrammar() {
        Question_answer_gramma correctAnswertmp = new Question_answer_gramma();
        ToggleGroup[] toggleGroups = new ToggleGroup[5];

        for (int i = 1; i <= 5; i++) {
            ToggleGroup toggleGroup = getToggleGroupForQuestion(i);
            toggleGroups[i - 1] = toggleGroup;
        }

        // Thêm sự kiện kiểm tra chỉ một lần
        for (ToggleGroup toggleGroup : toggleGroups) {
            toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    String RadioChoose = ((RadioButton) newValue).getId();
                  //  System.out.println(RadioChoose);
                    if (RadioChoose != null) {
                        this.setScore(this.getScore() + 1);
                    }
                } else {
                 //   System.out.println("No RadioButton selected");
                }
            });
        }
    }


    public void loadquestion() {

        Question_answer_gramma questionAnswerGramma = new Question_answer_gramma();

        for (currentQuestionIndex = 0; currentQuestionIndex < 5; currentQuestionIndex++)
        // Đặt câu hỏi lên TextArea tương ứng
        {
            switch (currentQuestionIndex) {
                case 0: {
                    question = questionAnswerGramma.getQuestion(currentQuestionIndex);
                    question1.setText(question);

                    String[] options = questionAnswerGramma.getOptions(currentQuestionIndex);
                    String correctAnswer = questionAnswerGramma.getCorrectAnswer(currentQuestionIndex);

                 //   System.out.println("Correct Answer: " + correctAnswer);
                    cau1A.getText();
                    break;
                }
                case 1:
                    question = questionAnswerGramma.getQuestion(currentQuestionIndex);
                    question2.setText(question);
                    String[] options = questionAnswerGramma.getOptions(currentQuestionIndex);

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
