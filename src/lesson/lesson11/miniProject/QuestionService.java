package lesson.lesson11.miniProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {

    public List<Question> loadQuestionsFromFile(String filePath){
        List<Question> questions = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null){
                if (line.startsWith("Question")){
                    String questionText = line.split(":")[1].trim();
                    String level = br.readLine().split(":")[1].trim();

                    List<Option> options = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        String optionText = br.readLine().split("\\)")[1].trim();
                        boolean isCorrect = optionText.contains("*");
                        options.add(new Option(optionText.replace("*", ""), isCorrect));
                    }
                    questions.add(new Question(questionText, QuestionLevelEnum.valueOf(level.toUpperCase()), options));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return questions;
    }

    public int calculateScore(List<Question> questions, List<Character> userAnswers){
        int totalScore = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            char userAnswer = userAnswers.get(i);

            List<Option> options = question.getOptions();
            int chooseIndex = userAnswer - 'A';
//            for (Option option : question.getOptions()) {
//                if (option.isCorrect() && option.getText().equalsIgnoreCase(userAnswer)){
//                    totalScore += question.getLevel().getBall();
//                }{
//            }

            if (chooseIndex > 0 && chooseIndex < options.size()) {
                Option selectOption = options.get(chooseIndex);
                if (selectOption.isCorrect()){
                    totalScore += question.getLevel().getBall();
            }
        }
    }

        return totalScore;
    }

}
