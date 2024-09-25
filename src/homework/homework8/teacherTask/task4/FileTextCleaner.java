package homework.homework8.teacherTask.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileTextCleaner {
    public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {
        String filePath = "files/regexLesson/file4.txt";
        String text = readFile(filePath);

        int numThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<String>> futures = new ArrayList<>();

        int chunkSize = 100;
        int totalChunks = (int) Math.ceil((double) text.length() / chunkSize);

        for (int i = 0; i < totalChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, text.length());
            String chunk = text.substring(start, end);
            futures.add(executor.submit(new TextCleanerTask(chunk)));
        }

        StringBuilder cleanedText = new StringBuilder();
        for (Future<String> future : futures) {
            cleanedText.append(future.get());
        }

        executor.shutdown();

        writeFile("files/regexLesson/cleanedfile.txt", cleanedText.toString());

        System.out.println("Tozalangan text faylga yozildi.");
    }

    private static String readFile(String filePath) throws IOException{
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null){
                content.append(line).append("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return content.toString();
    }

    private static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        }
    }

}
