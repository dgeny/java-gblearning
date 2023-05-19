package homework5.task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class main {
    private static Logger logger = Logger.getAnonymousLogger();
    public static void main(String[] args) {
        initLog("heapsorting.log");
        int[] array = generateArray(11, 0, 10);
        logger.info("Исходный массив");
        logger.info(Arrays.toString(array));
        heapSort(array, false);
        logger.info("Отсортированный массив");
        logger.info(Arrays.toString(array));
        closeLog();
    }

    private static void swap(int[] array, int idx1, int idx2){
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    private static void refineSearchTree(int[] array, int iLast, boolean asc) {
        int mid = iLast/2 - 1;
        while(mid > -1){
            if(asc ? array[mid] < array[2*mid+1]:array[mid] > array[2*mid+1]){
                swap(array, mid, 2*mid+1);
            }
            if( (2*mid+2 != iLast) && (asc ? array[mid] < array[2*mid+2] :array[mid] > array[2*mid+2])){
                swap(array, mid, 2*mid+2);
            }
            mid--;
        }
        logger.finest(Arrays.toString(array));
    }

    private static void heapSort(int[] array, boolean asc) {
        int iLast = array.length;
        while (iLast > 0) {
            refineSearchTree(array, iLast, asc);
            swap(array, 0, iLast-1);
            iLast--;
        }
    }

    static int[] generateArray(int size, int min_seed, int max_seed) {
        int[] resultArray = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            resultArray[i] = rnd.nextInt(min_seed, max_seed + 1);
        }
        return resultArray;
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
