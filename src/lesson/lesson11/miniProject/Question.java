package lesson.lesson11.miniProject;

import java.util.Collections;
import java.util.List;

public class Question {
    private String text;
    private QuestionLevelEnum level;
    private List<Option> options;

    public Question(String text, QuestionLevelEnum level, List<Option> options) {
        this.text = text;
        this.level = level;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public QuestionLevelEnum getLevel() {
        return level;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void shuffleOptions(){
        Collections.shuffle(options);
    }
}
