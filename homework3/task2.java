package homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        /*
         * Задан целочисленный список ArrayList. Найти минимальное, максимальное
         * и среднее арифметическое из этого списка. Collections.max()
         */
        int size = 10, endRange = 100, startRange = 0;

        ArrayList<Integer> list = generateRandomList(size, startRange, endRange);
        System.out.println(list);
        int min = endRange, max = startRange, sum = 0;
        
        for (Integer integer : list) {
            if (integer > max) {
                max = integer;
            }
            if (integer < min) {
                min = integer;
            }
            sum += integer;
        }
        double average = sum / list.size();
        System.out.println(Collections.min(list) == min);
        System.out.println(Collections.max(list) == max);
        System.out.println(
            String.format("Минимальный элемент: %d, максимальный элемент: %d, среднее: %f",
            min, max, average));
    }

    private static ArrayList<Integer> generateRandomList(int size, int startRange, int endRange) {

        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(startRange, endRange));
        }
        return list;
    }

}
