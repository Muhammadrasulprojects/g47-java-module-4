package lesson.lesson11.miniProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        QuestionService questionService = new QuestionService();
        List<Question> questions = questionService.loadQuestionsFromFile("dtm/question.txt");

        Scanner scanner = new Scanner(System.in);
        List<Character> userAnswers = new ArrayList<>();

        for (Question question : questions) {
            System.out.println(question.getText()+ " (" + question.getLevel() + ")");
            question.shuffleOptions();

            List<Option> options = question.getOptions();
            char optionChar = 'A';
            for (Option option : options) {
                System.out.println(optionChar + ")" + option.getText());
                optionChar++;
            }

//            System.out.println(userAnswers);
//            userAnswers.add(scanner.nextLine().trim());

            char userChoice;
            while (true){
                System.out.println("Your answer is: ");
                String input = scanner.nextLine().trim().toUpperCase();
                if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'D'){
                    userChoice = input.charAt(0);
                    break;
                } else {
                    System.out.println("Pls enter a correct answer (A,B,C,D)");
                }
            }
            userAnswers.add(userChoice);
        }

        int totalScore = questionService.calculateScore(questions, userAnswers);
        System.out.println("Your total score is: " + totalScore);

    }
}
