package homework.homework6.teacherTask;

import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Birinchi yilni kiriting (yyyy): ");
        int startYear = scanner.nextInt();
        System.out.print("Ikkinchi yilni kiriting (yyyy): ");
        int endYear = scanner.nextInt();

        System.out.println("Kabisa yillari: ");

        for (int year = startYear; year <= endYear; year++) {
            if (isLeapYear(year)){
                System.out.println(year);
            }
        }

        scanner.close();
    }

    public static boolean isLeapYear (int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
