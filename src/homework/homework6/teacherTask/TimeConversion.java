package homework.homework6.teacherTask;

import java.time.*;

public class TimeConversion {
    public static void main(String[] args) {
        Instant instant = Instant.now();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        System.out.println("Instant: " + instant);
        System.out.println("LocalDateTime: " + localDateTime);
    }
}

class DateTimeExtraction {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();

        System.out.println("localDateTime = " + localDateTime);
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
    }
}
