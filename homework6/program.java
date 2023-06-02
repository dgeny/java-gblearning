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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        Set<Laptop> laptops = loadShopList();
        Laptop criteria = inputFilter();
        int count =0;
        System.out.println("Поиск строгих совпадений:");
        for (Laptop laptop : laptops) {
            if(criteria.partialEquals(laptop)){
                System.out.println(laptop);
                count++;
            }
        }
        if (count == 0){
            System.out.println("\t - не найдено");
        }
        count = 0;
        System.out.println("Список ноутбуков не хуже искомого:");
        for (Laptop laptop : laptops) {
            if(criteria.moreEquals(laptop)){
                System.out.println(laptop);
                count++;
            }
        }
        if (count == 0){
            System.out.println("\t - не найдено");

        }
        closeLog();
    }

    private static Laptop inputFilter(){
        var con = System.console();
        if(con == null){
            logger.info("Ошибка инициализации консоли");
            return null;
        }
        Laptop lp = new Laptop();
        con.writer().print("Поиск ноутбука\n");
        con.writer().print("Введите объем ОЗУ:");
        con.writer().flush();
        Scanner sc = new Scanner(con.reader());
        lp.ramMB = sc.nextInt();
        con.writer().print("Введите объем ЖД:");
        con.writer().flush();
        lp.volumeStorage = sc.nextInt();
        con.writer().print("Введите ОС:");
        con.writer().flush();
        lp.operationalSystem = sc.next();
        con.writer().print("Введите цвет:");
        con.writer().flush();
        lp.color = sc.next();
        return lp;
    }

    private static Set<Laptop> loadShopList() {
        Set<Laptop> laptops = new HashSet<>();
        
        laptops.add(new Laptop("SKU001", "Lenovo", "Model1", 2048, 512, "i3", "1368x768", "Windows", "black", 300.0));
        laptops.add(new Laptop("SKU002", "Lenovo", "Model2", 4096, 1024, "i3", "1368x768", "Linux", "black", 350.0));
        laptops.add(new Laptop("SKU003", "Lenovo", "Model3", 8192, 512, "i5", "1920x1080", "Windows", "black", 400.0));
        laptops.add(new Laptop("SKU004", "Lenovo", "Model4", 2048, 256, "i5", "1920x1080", "Windows", "black", 450.0));
        laptops.add(new Laptop("SKU005", "Lenovo", "Model5", 4096, 1024, "i5", "1920x1080", "Windows", "black", 500.0));
        laptops.add(new Laptop("SKU006", "Dell", "Model1", 2048, 512, "i3", "1368x768", "Windows", "black", 300.0));
        laptops.add(new Laptop("SKU007", "Dell", "Model2", 4096, 1024, "Ryzen3", "1368x768", "Linux", "black", 350.0));
        laptops.add(new Laptop("SKU008", "Dell", "Model3", 8192, 512, "i5", "1920x1080", "Windows", "black", 400.0));
        laptops.add(new Laptop("SKU009", "Dell", "Model4", 2048, 256, "i5", "1920x1080", "Windows", "black", 450.0));
        laptops.add(new Laptop("SKU010", "Dell", "Model5", 4096, 1024, "Ryzen5", "1920x1080", "Windows", "black", 500.0));
        //проверка заггрузки дубля
        laptops.add(new Laptop("SKU010", "Dell", "Model5", 4096, 1024, "Ryzen5", "1920x1080", "Windows", "black", 500.0));
        logger.info("Загружено " + laptops.size() + " записей");
        return laptops;
    }

    static Laptop parseLine(String line){
        
        Pattern ptrn =Pattern.compile("(?:^|,)(?=[^\"]|(\")?)\"?((?<f1>(1)(?:[^\"]|\"\")*|[^,\"]*))\"?(?=,|$)"); 
        Matcher mtch = ptrn.matcher(line);
        if(mtch.matches())
            {
                System.out.println(mtch.group(2));
            }
            String[] fields = line.split(ptrn.pattern());
       /*  Laptop retVal = new Laptop(fields[0].trim(), 
            fields[1].trim(),
            Integer.getInteger(fields[6].trim().replaceAll("GB", "")),
            Integer.getInteger(fields[7].trim().replaceAll("GB", "")), 
            fields[5].trim(), fields[4].trim(), 
            (fields[9].trim() + " " + fields[10].trim()).trim(), 
            //Цвет заполним значением по умолчанию
            "default", 
            Double.parseDouble(fields[13].trim().replaceAll("\"", "").replaceAll(",", ".")));
        //Генерируем артикул
        retVal.setSKU(UUID.randomUUID().toString()); 
        return retVal;*/
        return null;
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
        consoleHandler.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);
        logger.info("Programm started");
    }
    
    private static void closeLog() {
        logger.info("Exit from programm.");
        logger.getHandlers()[0].flush();
        logger.getHandlers()[0].close();
    }

}
