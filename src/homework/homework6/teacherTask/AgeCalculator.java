package homework.homework6.teacherTask;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.print("Tug‘ilgan sanani kiriting (yyyy-MM-dd HH:mm:ss): ");
        String birthDateString = scanner.nextLine();

        LocalDateTime birthDate = LocalDateTime.parse(birthDateString, formatter);
        LocalDateTime currentDate = LocalDateTime.now();

        Duration duration = Duration.between(birthDate, currentDate);
        long totalSeconds = duration.getSeconds();

        long years = totalSeconds / (365 * 24 * 3600);
        totalSeconds %= (365 * 24 * 3600);
        long months = totalSeconds / (30 * 24 * 3600);
        totalSeconds %= (30 * 24 * 3600);
        long days = totalSeconds / (24 * 3600);
        totalSeconds %= (24 * 3600);
        long hours = totalSeconds / 3600;
        totalSeconds %= 3600;
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;

        System.out.println("Yashagan vaqt:");
        System.out.println("Yillar: " + years);
        System.out.println("Oylar: " + months);
        System.out.println("Kunlar: " + days);
        System.out.println("Soatlar: " + hours);
        System.out.println("Daqiqalar: " + minutes);
        System.out.println("Soniya: " + seconds);

        scanner.close();
    }
}
