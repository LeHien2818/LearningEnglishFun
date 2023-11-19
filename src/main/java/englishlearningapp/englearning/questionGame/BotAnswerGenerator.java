package englishlearningapp.englearning.questionGame;

import englishlearningapp.englearning.Controller.GameViewController;

import java.util.ArrayList;
import java.util.Random;

public class BotAnswerGenerator {
    private static final ArrayList<String> chosse = new ArrayList<String>();
    private static final String[] vocabulary = {
            "hello", "world", "java", "programming", "chatbot",
            "random", "example", "language", "application", "message",
            "learn", "code", "developer", "project", "create",
            "help", "computer", "internet", "android", "javascript",
            "repository", "software", "application", "user", "interface",
            "database", "algorithm", "machine", "learning", "artificial",
            "intelligence", "framework", "library", "website", "game",
            "design", "control", "statement", "variable", "object",
            "oriented", "class", "method", "parameter", "argument",
            "loop", "condition", "array", "list", "map",
            "set", "collection", "data", "structure", "node",
            "tree", "graph", "queue", "stack", "sorting",
            "searching", "recursion", "testing", "debugging", "exception",
            "try", "catch", "throw", "programming", "paradigm", "functional",
            "imperative", "object-oriented", "markup", "query", "performance",
            "optimization", "security", "authentication", "authorization", "session",
            "token", "encryption", "decryption", "serialization", "deserialization", "serialization",
            "asynchronous", "synchronous", "thread", "concurrency", "parallelism", "race",
            "condition", "deadlock", "critical", "section", "binary", "semaphore",
            "mutex", "programming", "language", "variable", "function", "parameter",
            "argument", "return", "value", "pointer", "reference", "type",
            "integer", "float", "double", "char", "string", "boolean",
            "void", "public", "private", "protected", "static", "final"
    };

    private static final int vocabularySize = vocabulary.length;
    private static final Random random = new Random();

    public static String generateRandomBotAnswers(int count) {
        String botAnswers = vocabulary[count];
        return botAnswers;
    }
    public static boolean checkWord(ArrayList<String> array , String word) {
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i).equals(word)) return true;
        }
        return false;
    }
    public static String getWordStartingWith(char startChar) {
        String result = null;

        for (int i = 0; i < vocabulary.length; i++) {
            String word = vocabulary[i];
            if (word.toLowerCase().charAt(0) == Character.toLowerCase(startChar)) {
               if(!checkWord(chosse,word)) {
                   result = word;
                   chosse.add(word);
                   break;
               }
            }
        }
        if (result == null) {
            System.out.println("null");
        }
        return result;
    }
}

