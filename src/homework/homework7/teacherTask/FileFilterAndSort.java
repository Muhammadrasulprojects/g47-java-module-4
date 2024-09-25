package homework.homework7.teacherTask;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileFilterAndSort {
    public static void main(String[] args) {
        String folderPath = "/C:/Users/user/Downloads/4. Concurrency.zip";
        String extension = ".mp3";
        long minSize = 13 * 1024 * 1024;

        List<File> filteredFiles = filterFilesByExtensionAndSize(folderPath, extension, minSize);

        // from big to small - sort
        filteredFiles.sort(Comparator.comparing(File::length).reversed());

        for (File file : filteredFiles) {
            System.out.println("Nomi: " + file.getName());
            System.out.println("O'lchami: " + (file.length() / (1024 * 1024)) + "MB");
            System.out.println("Yo'li: " + file.getAbsolutePath());
            System.out.println("------------------------");
        }
        
    }

    public static List<File> filterFilesByExtensionAndSize(String folderPath, String extension, long minSize){
        List<File> result = new ArrayList<>();
        File folder = new File(folderPath);

        if (folder.isDirectory()){
            File[] files = folder.listFiles();
            if (files != null){
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(extension) && file.length() >= minSize){
                        result.add(file);
                    }
                }
            }
        }

        return result;
    }
}
