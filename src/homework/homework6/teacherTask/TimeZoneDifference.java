package homework.homework6.teacherTask;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimeZoneDifference {
    public static void main(String[] args) {
        /* ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        Duration duration = Duration.between(newYorkTime, tokyoTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        System.out.println("Tokyo va New York orasidagi vaqt farqi:");
        System.out.println("Soatlar: " + hours);
        System.out.println("Daqiqalar: " + minutes); */

        ZonedDateTime tokyoTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Tokyo"));
        ZonedDateTime newYorkTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York"));

        long hoursDifference = ChronoUnit.HOURS.between(newYorkTime, tokyoTime);
        long minutesDifference = ChronoUnit.MINUTES.between(newYorkTime, tokyoTime) % 60;

        System.out.println("Tokyo va New York orasidagi vaqt farqi:");
        System.out.println("Soatlar: " + Math.abs(hoursDifference));
        System.out.println("Daqiqalar: " + Math.abs(minutesDifference));
    }
}
