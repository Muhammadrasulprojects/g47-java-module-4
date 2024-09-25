package homework.homework8.teacherTask.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WordFrequency {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        String fileName = "files/regexLesson/file2.txt"; // file uchun
        StringBuilder text = new StringBuilder(); // file uchun

        // Faylni o'qish va matnni to'plash
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String text = "omg omg omg omg 6 wow wow 9 hello hello hello 1 u u u u 4 bye bye bye bye bye bye"; // text uchun

        int numThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Map<String, Integer>>> futures = new ArrayList<>();
        String[] sentences = text.toString().split("\\s+"); // file uchun
//        String[] sentences = text.split("\\s+"); // so'zlarni ajratib beradi // text uchun

        int chunkSize = sentences.length / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? sentences.length : start + chunkSize;
            futures.add(executor.submit(new WordCounter(Arrays.copyOfRange(sentences, start, end))));
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (Future<Map<String, Integer>> future : futures){
            Map<String, Integer> partCount = future.get();
            for (Map.Entry<String, Integer> entry : partCount.entrySet()) {
                wordCount.put(entry.getKey(), wordCount.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }

        executor.shutdown();

        wordCount.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
