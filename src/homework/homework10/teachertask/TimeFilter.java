package homework.homework10.teachertask;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class TimeFilter implements Filter {
    public boolean isLoggable(LogRecord record){
        LocalTime currentTime = LocalTime.now();
        LocalTime startTime = LocalTime.of(9,0);
        LocalTime endTime = LocalTime.of(18,0);
        return !currentTime.isBefore(startTime) && !currentTime.isAfter(endTime);
    }
}
