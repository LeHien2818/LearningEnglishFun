
package englishlearningapp.englearning.DictionaryPackage;

        import englishlearningapp.englearning.Controller.GameViewController;
        import java.util.Random;
public class Question_answer extends GameViewController {

    private String[] question = {
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
    };

    private String[] answer = {
            "Táo",
            "Chuối",
            "Cam",
            "Nho",
            "Xoài",
            "Dâu tây",
            "Dứa",
            "Dưa leo",
            "Đào",
            "Việt quất"
    };

    public String getQuestion(int index) {

        return question[index];
    }

    public String getAnswer(int index) {
        return answer[index];
    }

    public String getrandomAnswer() {
        setRandom(10);
        int index = getRandom();
        return answer[index];
    }
}
