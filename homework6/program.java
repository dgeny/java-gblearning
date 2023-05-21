package homework6;


import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/* Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации 
и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. 
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев 
- сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.

Работу сдать как обычно ссылкой на гит репозиторий

P.S. Частые ошибки смотри в конце семинара
 */
public class program {
    private static Logger logger = Logger.getAnonymousLogger();
    public static void main(String[] args) {
        initLog("laptops.log");
        logger.info("load laptop dataset");
        Set<Laptop> notebooks = loadShopList("homework6/laptops.csv");
        logger.info("Загружено " + notebooks.size() + " записей");
        for (Laptop notebook : notebooks) {
            System.out.println(notebook);
        }
        closeLog();
    }

    private static Set<Laptop> loadShopList(String path) {
        Set<Laptop> notebooks = new HashSet<>();
        try {
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            logger.severe(e.getMessage());
        }
        //notebooks.add(new Notebook("SKU-1", "Lenovo", "Thinkpad x220")
        return notebooks;
    }

    private static void initLog(String path){
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.FINEST);

        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleFormatter formatter = new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
              );
            }
        };
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(formatter);
        logger.addHandler(consoleHandler);
        logger.info("Programm started");
    }
    
    private static void closeLog() {
        logger.info("Exit from programm.");
        logger.getHandlers()[0].flush();
        logger.getHandlers()[0].close();
    }

}
