package homework.homework6.teacherTask;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class MeetingCalculator {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        LocalDate endDate = today.plusMonths(3).with(TemporalAdjusters.lastDayOfMonth());

        int meetingCount = 0;
        LocalDate currentMonday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));

        while (!currentMonday.isAfter(endDate)){
            meetingCount++;
            currentMonday = currentMonday.plusWeeks(1);
        }

        System.out.println("Kelasi 3oy davomida necha majlis bo'lishi:");
        System.out.println("Majlislar soni: " + meetingCount);
    }
}
