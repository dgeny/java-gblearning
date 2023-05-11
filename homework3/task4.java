package homework3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task4 {
    private static Logger logger = Logger.getAnonymousLogger();
    public static void main(String[] args) {
        /*
         * 1. Реализуйте алгоритм сортировки пузырьком числового массива [отдаем долги с прошлой домашки]
         *              заодно сравним результаты и количество шагов
         * 2. Реализовать алгоритм сортировки слиянием 
         * 
         * результат после каждой итерации запишите в лог-файл.
         */
        InitLog("sorting.log");
        int[] array = GenerateArray(25, 0, 10);
        logger.info("Исходный массив");
        logger.info(Arrays.toString(array));
        int[] unsorted = Arrays.copyOf(array, array.length);
        logger.info("Сортировка пузырьком:");
        BubbleSort(array, false);
        logger.info(Arrays.toString(array));
        logger.info("Сортировка слиянием:");
        MergeSort(unsorted, false);
        logger.info(Arrays.toString(unsorted));
        CloseLog();
    }

    private static void BubbleSort(int[] array, boolean asc) {
        for (int i = 0; i < array.length - 2; i++) {
            int tmp = 0;
            for (int j = 0; j < array.length - 1; j++) {
                if (asc ? array[j] > array[j + 1] : array[j] < array[j + 1]) {
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    logger.finest(Arrays.toString(array));
                }
                
            }
        }
    }

    private static void MergeSort(int[] array, boolean asc) {
        if (array.length<2) {return;}
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        logger.finest(Arrays.toString(left) + "<==>" + Arrays.toString(right));
        MergeSort(left, asc);
        MergeSort(right, asc);
        int filler = 0, cleft=0, cright=0;
        while(filler < array.length){
            
            if(cleft == left.length){
                array[filler] = right[cright];
                filler++;
                cright++;
            }
            else if(cright == right.length){
                array[filler] = left[cleft];
                filler++;
                cleft++;
            }
            else if( asc ? left[cleft]< right[cright] : left[cleft] > right[cright]){
                array[filler] = left[cleft];
                filler++;
                cleft++;
            }
            else if(left[cleft] == right[cright]){
                array[filler] = left[cleft];
                cleft++;
                filler++;
                array[filler] = right[cright];
                cright++;
                filler++;
            }
            else{
                array[filler] = right[cright];
                filler++;
                cright++;
            }

        }        
        logger.finest(Arrays.toString(array));
    }
    
    static int[] GenerateArray(int size, int min_seed, int max_seed) {
        int[] resultArray = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            resultArray[i] = rnd.nextInt(min_seed, max_seed + 1);
        }
        return resultArray;
    }

    private static void InitLog(String path){

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
        logger.setLevel(Level.FINEST);
        logger.info("Programm started");
    }
    
    private static void CloseLog() {
        logger.info("Exit from programm.");
        logger.getHandlers()[0].flush();
        logger.getHandlers()[0].close();
    }

}
