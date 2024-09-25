package homework.homework8.teacherTask.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidatorTask implements Callable<List<String>> {
    private final List<String> emails;

    public EmailValidatorTask(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public List<String> call(){
        List<String> invalidEmails = new ArrayList<>();
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

        for (String email : emails) {
            Matcher matcher = emailPattern.matcher(email);
            if (!matcher.matches()) {
                invalidEmails.add(email); // Agar email yaroqsiz bo'lsa, uni ro'yxatga qo'shish
            }
        }

        return invalidEmails;
    }
}
