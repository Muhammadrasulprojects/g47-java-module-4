package homework.homework7.teacherTask;

import java.io.File;

public class FolderSizeCalculator {
    public static void main(String[] args) {
        File folder = new File("files/file/File.txt");
        if (folder.exists() && folder.isDirectory()){
            long sizeInBytes = getFolderSize(folder);
            double sizeInMb = sizeInBytes / (1024.0 * 1024.0);
            double sizeInGb = sizeInBytes / (1024.0 * 1024.0 * 1024.0);

            System.out.printf("Folder size: %.2f MB (%.2f GB)%n", sizeInMb, sizeInGb);
        } else {
            System.out.println("The provided path is not a valid directory");
        }
    }

    public static long getFolderSize(File folder){
        long totalSize = 0;
        File[] files = folder.listFiles();

        if (files != null){
            for (File file : files) {
                if (file.isFile()){
                    totalSize += file.length(); // Fayl hajmini qo'shadi
                } else if(file.isDirectory()){
                    totalSize += getFolderSize(file); // Rekursiv tarzda direktoriyaning hajmini hisoblaydi
                }
            }
        }

        return totalSize;  // Umumiy hajmni qaytaradi
    }
}
