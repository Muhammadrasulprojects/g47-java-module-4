package homework.homework7.teacherTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FolderCopy {
    public static void main(String[] args) {
        String sourceFolder = "files/file/Folder1";
        String destinationFolder = "files/file/Folder2";

        copyFolder(Paths.get(sourceFolder), Paths.get(destinationFolder));
    }

    private static void copyFolder(Path source, Path destination){
        try{
            // agar 2-folder yo'q bo'lsa
            if (!Files.exists(destination)){
                Files.createDirectories(destination);
            }

            // 1-folderdagi barcha fayllarni o'qiymiz
            Files.walk(source).forEach(path -> {
                Path targetPath = destination.resolve(source.relativize(path));

                try{
                    if (Files.isDirectory(path)){
                        // agar bu papka bo'lsa yangi yaratamiz
                        Files.createDirectories(targetPath);
                    } else {
                        // agar fayl bo'lsa, nusxa ko'chiramiz
                        Files.copy(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            });

            System.out.println("Barcha fayllar nusxalandi!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
