package exam.mocExam.thirdTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileNumberReader {
    public static void main(String[] args) {
        String folderPath = "path/files/mocExam";
        String fileName = "files/mocExam/file";

        try{
            Path path = Paths.get(folderPath, fileName);
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String[] numbers = line.split("\\s+");
                for (String number : numbers) {
                    if (isNumberGreaterThanOne(number)){
                        System.out.println(number);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static boolean isNumberGreaterThanOne(String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            return number > 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
