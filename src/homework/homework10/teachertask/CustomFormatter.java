package homework.homework10.teachertask;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public String format(LogRecord record){
        String time = timeFormatter.format(LocalTime.now());
        String className = record.getSourceClassName();
        String methodName = record.getSourceMethodName();
        String level = record.getLevel().toString();
        String message = record.getMessage();
        String exception = (record.getThrown() != null) ? record.getThrown().toString() : "";

        return String.format("Time: %s, ClassName: %s, Method: %s, Level: %s, Message: %s, Exception: %s%n",
                time, className, methodName, level, message, exception);
    }
}
