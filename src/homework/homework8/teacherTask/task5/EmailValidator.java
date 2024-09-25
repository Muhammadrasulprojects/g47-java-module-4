package homework.homework8.teacherTask.task5;

import homework.homework8.teacherTask.task5.EmailValidatorTask;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EmailValidator {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        String filePath = "files/regexLesson/file5.txt";
        List<String> emails = readEmailsFromFile(filePath);

        int numThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<List<String>>> futures = new ArrayList<>();

        int chunkSize = 100;
        int totalChunks = (int) Math.ceil((double) emails.size() / chunkSize);

        for (int i = 0; i < totalChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, emails.size());
            List<String> chunk = emails.subList(start, end);
            futures.add(executor.submit(new EmailValidatorTask(chunk)));
        }

        for (Future<List<String>> future : futures) {
            List<String> invalidEmails = future.get();
            if (!invalidEmails.isEmpty()) {
                System.out.println("Sifatsiz email adreslari:");
                for (String invalidEmail : invalidEmails) {
                    System.out.println(invalidEmail);
                }
            }
        }

        executor.shutdown();
    }

    private static List<String> readEmailsFromFile(String filePath) throws IOException{
        List<String> emails = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null){
                emails.add(line.trim());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return emails;
    }
}
