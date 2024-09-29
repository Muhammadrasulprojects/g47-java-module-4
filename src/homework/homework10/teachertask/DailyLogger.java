package homework.homework10.teachertask;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DailyLogger {
    private static Logger logger = Logger.getLogger("Mylog");
    private static FileHandler dailyFileHandler;
    private static FileHandler exceptionFileHandler;

    static {
        try {
            // har bir kun uchun log fayl
            String dailyFileName = "log_" + getCurrentDate() + ".log";
            dailyFileHandler = new FileHandler(dailyFileName, true);
            dailyFileHandler.setFormatter(new CustomFormatter());
            logger.addHandler(dailyFileHandler);

            // severe level log fayl
            String exceptionFileName = getCurrentDate() + ".exception.log";
            exceptionFileHandler = new FileHandler(exceptionFileName, true);
            exceptionFileHandler.setFormatter(new CustomFormatter());
            logger.addHandler(exceptionFileHandler);

            // log filter
            logger.setFilter(new TimeFilter());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static String getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        return String.format("%tY-%<tm-%<td", calendar);
    }

    private static void log(String message){
        logger.info(message);
    }

    private static void logSevere(String message, Exception e){
        logger.log(Level.SEVERE, message, e);
    }

    public static void main(String[] args) {
        // log
        log("Dastur ishga tushdi!");
        log("BU 1-log xabar.");

        try{
            throw new RuntimeException("Test exception");
        } catch (Exception e){
            logSevere("Sever log xabari", e);
        }

        log("Bu boshqa log xabari");
    }
}
