package englishlearningapp.englearning.questionGame;

import englishlearningapp.englearning.Controller.GameViewController;

public class Question_answer_gramma {

    public String[] questions = {
            "The capital of France is _________.",
            "A cat is a _________ animal.",
            "I like to eat pizza with _________.",
            "The sun rises in the _________.",
            "What is the largest planet in our solar system?",
            "Who wrote 'Romeo and Juliet'?",
            "Which gas do plants absorb from the atmosphere?",
            "In which year did Christopher Columbus discover America?",
            "What is the chemical symbol for gold?",
            "What is the smallest prime number?",
            "What is the freezing point of water in Fahrenheit?",
            "How many continents are there on Earth?",
            "Which gas is responsible for the green color of leaves?",
            "Who painted the Mona Lisa?",
            "What is the largest mammal on Earth?"
    };

    private String[] correctAnswers = {
            "Paris",
            "feline",
            "cheese",
            "east",
            "Jupiter",
            "William Shakespeare",
            "Carbon dioxide (CO2)",
            "1492",
            "Au",
            "2",
            "32 degrees",
            "7",
            "Chlorophyll",
            "Leonardo da Vinci",
            "Blue whale"
    };

    private String[][] options = {
            {"Paris", "London", "Berlin", "Rome"},
            {"canine", "feline", "reptilian", "aquatic"},
            {"pepperoni", "cheese", "mushrooms", "pineapple"},
            {"north", "south", "west", "east"},
            {"Mars", "Saturn", "Jupiter", "Venus"},
            {"Charles Dickens", "Jane Austen", "William Shakespeare", "F. Scott Fitzgerald"},
            {"Oxygen (O2)", "Carbon dioxide (CO2)", "Nitrogen (N2)", "Hydrogen (H2)"},
            {"1492", "1620", "1776", "1812"},
            {"Ag", "Au", "Pb", "Hg"},
            {"0", "1", "2", "3"},
            {"0 degrees", "32 degrees", "100 degrees", "212 degrees"},
            {"6", "7", "8", "9"},
            {"Oxygen (O2)", "Carbon dioxide (CO2)", "Nitrogen (N2)", "Chlorine (Cl2)"},
            {"Pablo Picasso", "Vincent van Gogh", "Leonardo da Vinci", "Michelangelo"},
            {"African elephant", "Giraffe", "Polar bear", "Blue whale"}
    };

    public String getQuestion(int index) {
        return questions[index];
    }

    public String getCorrectAnswer(int index) {
        return correctAnswers[index];
    }

    public String[] getOptions(int index) {
        return options[index];
    }
}
