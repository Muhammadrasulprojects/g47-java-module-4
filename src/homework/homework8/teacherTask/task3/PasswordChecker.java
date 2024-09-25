package homework.homework8.teacherTask.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PasswordChecker implements Callable<List<String>> {
    private final List<String> passwords;

    public PasswordChecker(List<String> passwords){
        this.passwords = passwords;
    }

    @Override
    public List<String> call() throws Exception {
        List<String> weakPasswords = new ArrayList<>();
        for (String password : passwords) {
            if (isWeakPassword(password)){
                weakPasswords.add(password);
            }
        }

        return weakPasswords;
    }


    private boolean isWeakPassword(String password){
        if (password.length() < 8) return true;
        if (!password.matches(".*[a-z].*")) return true;
        if (!password.matches(".*[A-Z].*")) return true;
        if (!password.matches(".*\\d.*")) return true;
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) return true;
        return false;
    }
}
