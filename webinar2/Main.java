import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
//        char c1 = 'a';
//        char c2 = 'b';
//        int n = 10;
//        System.out.println(ex0(c1, c2, n));
//        System.out.println(ex2_1("А роза упала на лапу Азора"));
        ex3("Test", 20);
    }

    static void ex3(String s, int n){
        /*
        Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
        который запишет эту строку в простой текстовый файл, обработайте исключения.
         */
        String s1 = repeatString(s, n);
        saveToFile(s1);

    }

    static void saveToFile(String s) {
        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        String path = "g/g/g/g/gtest.txt";
        try (FileWriter fileWriter = new FileWriter(path, false)) {
            fileWriter.append(s);
            fileWriter.flush();
        } catch (Exception e) {
            //e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }
        System.out.println("Тест");
        fileHandler.close();
    }

    static String repeatString(String s, int n){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s);
//            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    static boolean ex2_1(String s){
        s = s.replace(" ", "");
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length-1; i < arr.length / 2; i++, j--) {
            if (arr[i] != arr[j]){
                return false;
            }
        }
        return true;
    }
    static boolean ex2(String s){
        /*
        Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом
         (возвращает boolean значение).

        Полиндром - Слово или фраза, которые одинаково читаются слева направо и справа налево.
         */
        s = s.replace(" ", "");
        StringBuilder stringBuilder1 = new StringBuilder(s);
        stringBuilder1.reverse();
        return stringBuilder1.toString().equalsIgnoreCase(s);
    }
    static String ex1(String s){
        /*
        Напишите метод, который сжимает строку.
        Пример: вход aaaabbbcddaa.
        Результат: a4b3cd2a2
         */
        StringBuilder stringBuilder = new StringBuilder();
        char[] arr = s.toCharArray();
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]){
                count++;
            } else {
                stringBuilder.append(arr[i-1]);
                if (count > 1){
                    stringBuilder.append(count);
                    count = 1;
                }
            }
        }
        stringBuilder.append(arr[arr.length-1]);
        if (count > 1){
            stringBuilder.append(count);
        }
        return stringBuilder.toString();
    }
    static String ex0(char c1, char c2, int n){
        /*
        Дано четное число N (>0) и символы c1 и c2.
        Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.
        Ответ: c1c2c1…c2 (всего N символов)
         */
        if (n % 2 != 0){
            return "Вы ввели нечетное число";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            stringBuilder.append(c1);
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }
}

