package lesson.lesson8.mine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RegexTest {
    public static void main(String[] args) {
        String file = "files/regexLesson/file.txt";
        List<String> words = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split("\\s+");
                for (String part : parts) {
                    words.add(part);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // 1xonali sonlari nechta va hammasi print
        List<String> oneDigitNumber = new ArrayList<>();
        for (String word : words) {
            if (word.matches("\\d{1}")){
                oneDigitNumber.add(word);
            }
        }
        System.out.println("1xonali sonlar: " + oneDigitNumber.size() + "ta");
        System.out.println(oneDigitNumber);

        // 2xonali sonlari nechta va hammasi print
        List<String> twoDigitNumbers = new ArrayList<>();
        for (String word : words) {
            if (word.matches("\\d{2}")){
                twoDigitNumbers.add(word);
            }
        }
        System.out.println("2xonali sonlar: " + twoDigitNumbers.size() + "ta");
        System.out.println(twoDigitNumbers);

        // 3xonali sonlari 3-8raqamlar qatnashgan nechta va hammasi print
        List<String> threeDigitNumbers = new ArrayList<>();
        for (String word : words) {
            if (word.matches("\\d{3}")  && word.matches(".*[3-8].*")){
                threeDigitNumbers.add(word);
            }
        }
        System.out.println("3xonali sonlar (3;8): " + threeDigitNumbers.size() + "ta");
        System.out.println(threeDigitNumbers);

        // kichkina harfda yozilingan  uzunligi 3-7 nechta va hammasi print
        List<String> smallLetterWords = new ArrayList<>();
        for (String word : words) {
            if (word.matches("[a-z]{3,7}")){
                smallLetterWords.add(word);
            }
        }
        System.out.println("Kichkina harf bilan yozilingan so'zlar (uzunligi 3-7): " + smallLetterWords.size() + "ta");
        System.out.println(smallLetterWords);

        // faqat katta harfda yozilingan uzunligi 4-7 va hammasi print
        List<String> capitalLetterWords = new ArrayList<>();
        for (String word : words) {
            if (word.matches("[A-Z]{4,7}")){
                capitalLetterWords.add(word);
            }
        }
        System.out.println("Katta harflar bilan yozilingan so'zlar (uzunligi 4-7): " + capitalLetterWords.size() + "ta");
        System.out.println(capitalLetterWords);

        // “free” dan boshlanadigan so’zlarni ekranga chiqarish
        List<String> freeWords = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith("free")){
                freeWords.add(word);
            }
        }
        System.out.println("free bilan boshlangan so'zlar: " + freeWords.size() + "ta");
        System.out.println(freeWords);

        // “stu” bilan tugagan so’zlarni ekranga chiqarish
        List<String> stuWords = new ArrayList<>();
        for (String word : words) {
            if (word.endsWith("stu")){
                stuWords.add(word);
            }
        }
        System.out.println("stu bilan tugigan so'zlar soni: " + stuWords.size() + "ta");
        System.out.println(stuWords);




















        // replace
        /*String replace = text.replace("w", "v");
        System.out.println("replace = " + replace);*/

        // replaceAll
        /*String replaceAll = text.replaceAll("\\d{2}", "(digit)");
        System.out.println("replaceAll = " + replaceAll);*/

        // split
        /*String[] split = text.split("\\.");
        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));*/

        // regex example for digits
        /*Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("match->" + matcher.group() + " start: " + start + " end: " + end);
        }*/


    }
}
