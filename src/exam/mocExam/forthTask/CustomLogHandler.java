package exam.mocExam.forthTask;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class CustomLogHandler extends StreamHandler {
    public CustomLogHandler(){
        setLevel(Level.SEVERE);
    }

    public void publish(LogRecord record){
        if (record.getLevel().intValue() >= Level.SEVERE.intValue()){
            super.publish(record);
            flush();
        }
    }
}
