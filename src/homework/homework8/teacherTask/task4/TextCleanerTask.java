package homework.homework8.teacherTask.task4;

import java.util.concurrent.Callable;

public class TextCleanerTask implements Callable<String> {
    private final String text;

    public TextCleanerTask(String text) {
        this.text = text;
    }

    @Override
    public String call() throws Exception {
        return cleanText(text);
    }

    private String cleanText(String text){
        text = text.replaceAll("\\s+", " ");
        text = text.replaceAll("[$&#*]", "");
        return text;
    }
}
