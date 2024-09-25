package homework.homework8.teacherTask.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class WordCounter implements Callable<Map<String,Integer>> {
    private final String[] words;

    public WordCounter(String[] words){
        this.words = words;
    }

    public Map<String, Integer> call(){
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-z]", ""); // so'zlarni kichik harfga va maxsus belgilarni olib tashlash
            if (!word.isEmpty()){
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
        }
        return countMap;
    }
}
