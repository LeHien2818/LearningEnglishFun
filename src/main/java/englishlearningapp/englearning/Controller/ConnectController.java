package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.questionGame.BotAnswerGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ConnectController extends GameViewController {
    @FXML
    private  TextArea answerTextArea;

    @FXML
    private  TextField playerAnswerTextField;
    private  List<String> EnteredWord = new ArrayList<>();

    private boolean checkEnterWord(String word) {
        for (int i = 0; i < EnteredWord.size() - 1; i++) {
            if (EnteredWord.get(i).equals(word)) return false;
        }
        return true;
    }

    public void initialize() {
        playerAnswerTextField.setText("");
        this.setRandom(197000);
        int index = this.getRandom();
        String starWord = BotAnswerGenerator.generateRandomBotAnswers();
        answerTextArea.setText(starWord + "\n");
        EnteredWord.add(starWord);
        playerAnswerTextField.setOnKeyPressed(event -> {
            try {
                handleTextFieldEnter(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void handleTextFieldEnter(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            String playerAnswer = playerAnswerTextField.getText();
            if (checkEnterWord(playerAnswer)) {
                EnteredWord.add(playerAnswer);
                System.out.println(EnteredWord);
                char keyword = playerAnswer.charAt(playerAnswer.length() - 1);
                String botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);
                while (!checkEnterWord(botAnswer)) {
                    botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);

                    if (botAnswer == null || botAnswer.isEmpty()) {
                        break;
                    }
                }
                if (botAnswer != null && !botAnswer.isEmpty()) {
                    answerTextArea.setText(botAnswer);
                    playerAnswerTextField.setText(botAnswer.charAt(0) + "");
                    EnteredWord.add(botAnswer);

                } else if(botAnswer == null){
                    ActionEvent eventAlert = new ActionEvent();
                  //  answerTextArea.clear();
                    AlertController.alertEndGame(eventAlert, "You Win");
                }
                playerAnswerTextField.clear();
            } else {
                ActionEvent eventAlert = new ActionEvent();
                AlertController.alertWrong(eventAlert,"The word was entered previously");
                playerAnswerTextField.clear();
            }
        }
    }
}
