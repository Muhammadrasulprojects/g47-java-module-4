package homework.homework6.teacherTask;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class IndependenceDayCountdown {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextIndependenceDay = LocalDateTime.of(now.getYear(), Month.SEPTEMBER, 1, 0,0,0);

        if (now.isAfter(nextIndependenceDay)){
            nextIndependenceDay = nextIndependenceDay.plusYears(1);
        }

        Duration duration = Duration.between(now, nextIndependenceDay);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.toSeconds() % 60;

        System.out.println("Keyingi mustaqillik bayramigacha qolgan vaqt:");
        System.out.println("Kunlar: " + days);
        System.out.println("Soatlar: " + hours);
        System.out.println("Daqiqalar: " + minutes);
        System.out.println("Soniya: " + seconds);
    }
}
