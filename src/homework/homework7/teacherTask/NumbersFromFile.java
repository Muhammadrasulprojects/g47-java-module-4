package homework.homework7.teacherTask;

import java.io.*;

public class NumbersFromFile {
    public static void main(String[] args) {
        String fileName = "files/file/File.txt";

        createFileWithData(fileName);

        readFileAndPrint(fileName);
    }

    public static void createFileWithData(String fileName){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write("1,2,3,4,5,6");
            writer.newLine(); // Yangi qator
            writer.write("15,26,76,90");
            writer.newLine(); // Yangi qator

            System.out.println("Fayl yaratildi va ma'lumot yozildi.");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readFileAndPrint(String fileName){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null){
                String[] numbers = line.split(",");

                int[] numberArray = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    numberArray[i] = Integer.parseInt(numbers[i].trim());
                }

                System.out.println("Qator " + lineNumber + ": " );
                for (int number : numberArray) {
                    System.out.println(number + " ");
                }

                System.out.println();

                lineNumber++;
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
