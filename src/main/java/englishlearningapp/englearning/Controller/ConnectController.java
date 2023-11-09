package englishlearningapp.englearning.Controller;

import englishlearningapp.englearning.questionGame.BotAnswerGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ConnectController extends GameViewController {
    @FXML
    private TextArea answerTextArea;

    @FXML
    private TextField playerAnswerTextField;

    private List<String> EnteredWord = new ArrayList<>();

    private boolean checkEnterWord(String word) {
        for (int i = 0; i < EnteredWord.size() - 1; i++) {
            if (EnteredWord.get(i).equals(word)) return false;
        }
        return true;
    }

    public void initialize() {
        playerAnswerTextField.setText("");
        this.setRandom(100);
        int index = this.getRandom();
        String starWord = BotAnswerGenerator.generateRandomBotAnswers(index);
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
                answerTextArea.appendText("Người chơi: " + playerAnswer + "\n");
                char keyword = playerAnswer.charAt(playerAnswer.length() - 1);

                String botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);

                while (!checkEnterWord(botAnswer)) {
                    botAnswer = BotAnswerGenerator.getWordStartingWith(keyword);

                    if (botAnswer == null || botAnswer.isEmpty()) {
                        break;
                    }
                }

                if (botAnswer != null && !botAnswer.isEmpty()) {
                    answerTextArea.appendText("Bot: " + botAnswer + "\n");
                    EnteredWord.add(botAnswer);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText(null);
                    alert.setContentText("You Win");
                    ButtonType buttonTypeExit = new ButtonType("EXIT");
                    alert.getButtonTypes().setAll(buttonTypeExit);
                    Optional<ButtonType> newResult = alert.showAndWait();
                    if (newResult.isPresent() && newResult.get() == buttonTypeExit) {
                        ActionEvent event1 = new ActionEvent();
                        SceneController.switchScene(event1, SceneController.gameRoot);
                    }
                }
                playerAnswerTextField.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("The word was entered previously");
                ButtonType buttonTypeYes = new ButtonType("OKE", ButtonBar.ButtonData.YES);

                alert.getButtonTypes().setAll(buttonTypeYes);

                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == buttonTypeYes) {
                    alert.close();
                }
                playerAnswerTextField.clear();
            }
        }
    }
}

