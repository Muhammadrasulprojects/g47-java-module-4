package homework.homework7.teacherTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersFromFIle {
    public static void main(String[] args) {
        String filename = "homework/homework7";
        List<Integer> numbers = new ArrayList<>();

        // fayldan raqamlarni o'qish
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = reader.readLine();

            // raqamlani o'qib arrayga o'girish
            if (line != null){
                line = line.replaceAll("[\\[\\]\\s]", "");
                String[] parts = line.split(",");
                for (String part : parts){
                    numbers.add(Integer.parseInt(part));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        for (int number : numbers) {
            if (isPrime(number)) {
                System.out.println(number);
            }
        }
    }

    // Tub sonni tekshirish method
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
