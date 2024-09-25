package homework.homework6.teacherTask;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkdayCalculator {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusMonths(6);
        int workdayCount = 0;
        LocalDate currentDate = today;
        while (!currentDate.isAfter(endDate)){
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY){
                workdayCount++;
            }

            currentDate = currentDate.plusDays(1);
        }

        System.out.println("Kelasi 6 oy davomida ish kunlar soni: " + workdayCount);
    }
}
