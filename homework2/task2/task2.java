package task2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Дана json строка 
[{ "фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.

Используйте StringBuilder для подготовки ответа

Исходная json строка это просто String !!! Для работы используйте методы String, 
такие как replace, split, substring и т.д. по необходимости

Создать метод, который запишет результат работы в файл. 
Обработайте исключения и запишите ошибки в лог файл. */

public class task2 {
    private static Logger logger = Logger.getAnonymousLogger();
    private static Pattern journalPattern = Pattern.compile(
        "\\{\\s*?(?<item>\\\"фамилия\\\":\\s*?\\\"(?<lastname>.+?)\\\",\\s*?\\\"оценка\\\":\\s*?\\\"(?<rating>\\d)\\\"\\s*?,\\s*?\\\"предмет\\\":\\s*?\\\"(?<discipline>\\p{L}+)\\\")\\}");
    public static void main(String[] args) {
        //System.out.println(Paths.get("task2/dict.json"));
        System.out.println(task2.class.getResource("dict.json"));
        String pathToDict = "dict.json";
        String jsonString = readDictFromFile(task2.class.getResource(pathToDict).getPath());
        InitLog("task2.log");
        var a = parseJournal(jsonString);
        System.out.println(a);
        CloseLog();
    }

    private static String readDictFromFile(String path) {
        StringBuilder outStr = new StringBuilder();
        try(Scanner scanner = new Scanner(new File(path))){

            //Read line
            while (scanner.hasNextLine()) {
              outStr.append(scanner.nextLine());
              outStr.append('\n');
            }
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        return outStr.toString();        
    }

    private static String parseJournal(String jsonString) {
        Matcher jMatcher = journalPattern.matcher(jsonString);
        
        StringBuilder resBuilder = new StringBuilder();
        while (jMatcher.find()) {
            logger.warning("Full match: " + jMatcher.group(0));
            
            //System.out.println(jMatcher.group("lastname"));
            resBuilder.append("Студент ");
            resBuilder.append(jMatcher.group("lastname"));
            resBuilder.append(" получил ");
            resBuilder.append(jMatcher.group("rating"));
            resBuilder.append(" по предмету ");
            resBuilder.append(jMatcher.group("discipline"));
            resBuilder.append("\n");
            for (int i = 1; i <= jMatcher.groupCount(); i++) {
                StringBuilder logBuilder = new StringBuilder();
                logBuilder.append("Group ");
                logBuilder.append(i);
                logBuilder.append(": ");
                logBuilder.append(jMatcher.group(i));
                logger.finer(logBuilder.toString());
            }
        }
        return resBuilder.toString();
    }

    private static void InitLog(String path){

        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        logger.info("Programm started");
    }
    
    private static void CloseLog() {
        logger.info("Exit from programm.");
        logger.getHandlers()[0].flush();
        logger.getHandlers()[0].close();
    }

}
