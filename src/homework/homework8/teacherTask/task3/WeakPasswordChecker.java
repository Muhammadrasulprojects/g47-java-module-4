package homework.homework8.teacherTask.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WeakPasswordChecker {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        String fileName = "files/regexLesson/file3.txt";
        List<String> passwords = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String password;
            while ((password = br.readLine()) != null){
                passwords.add(password);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        int numThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<List<String>>> futures = new ArrayList<>();

        int chunkSize = passwords.size() / numThreads; // har bir thread uchun bo'lak o'lchami
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? passwords.size() : start + chunkSize;
            futures.add(executor.submit(new PasswordChecker(passwords.subList(start,end))));
        }

        List<String> weakPasswords = new ArrayList<>();
        for (Future<List<String>> future : futures) {
            weakPasswords.addAll(future.get());
        }

        executor.shutdown();

        System.out.println("Kuchsiz parollar:");
        weakPasswords.forEach(System.out::println);
    }
}
