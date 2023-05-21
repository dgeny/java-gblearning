package homework3;

import java.util.ArrayList;
import java.util.Random;


/**
 * Пусть дан произвольный список целых чисел, удалить из него четные числа
 */
public class task1 {
    public static void main(String[] args) {
        int size = 10, endRange = Integer.MAX_VALUE, startRange = Integer.MIN_VALUE;

        ArrayList<Integer> list = generateRandomList(size, startRange, endRange);
        System.out.println(list);
        removeEvens2(list);
        removeEvens(list);
        System.out.println(list);
    }

    private static void removeEvens2(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)%2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }

    private static void removeEvens(ArrayList<Integer> list) {
        list.removeIf(o -> o%2 == 0);
    }

    private static ArrayList<Integer> generateRandomList(int size, int startRange, int endRange) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(startRange, endRange));
        }
        return list;
    }
    
}