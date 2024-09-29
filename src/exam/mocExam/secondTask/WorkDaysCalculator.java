package exam.mocExam.secondTask;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WorkDaysCalculator {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(1990,1,1);
        LocalDate endDate = LocalDate.of(2024,1,1);

        long totalDays = ChronoUnit.DAYS.between(startDate,endDate);
        long workDays = totalDays / 7 * 5 + Math.min(totalDays % 7, 5);
        long leapYears = 0;

        for (int year = 1990; year < 2024; year++) {
            if (isLeapYear(year))
                leapYears++;
        }

        System.out.println("Ish kuni: " + workDays);
        System.out.println("Kabisa yili: " + leapYears);
    }

    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
