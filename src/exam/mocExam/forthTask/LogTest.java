package exam.mocExam.forthTask;

import homework.homework10.teachertask.CustomFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("CustomLogger");
        logger.setLevel(Level.ALL);
        CustomLogHandler handler = new CustomLogHandler();
        handler.setFormatter(new CustomFormatter());
        logger.addHandler(handler);

        logger.severe("This's a severe message");
        logger.warning("This's a warning message");
        logger.info("This's a info message");
    }
}
