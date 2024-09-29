package exam.mocExam.forthTask;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        if (record.getThrown() != null){
            StringWriter sw = new StringWriter();
            record.getThrown().printStackTrace(new PrintWriter(sw));
            return sw.toString();
        }
        return record.getMessage() + "\n";
    }
}
