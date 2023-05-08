package homework4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/* 1. Пусть дан LinkedList с несколькими элементами. 
    Реализуйте метод, который вернет “перевернутый” список.
    Постараться не обращаться к листу по индексам. */

public class task1 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = generateRandomList(10, 0, 10);
        System.out.print("Исходный список:\t");
        System.out.println(Arrays.toString(ll.toArray()));
        System.out.print("Перевернутый список:\t");
        System.out.println(Arrays.toString(ReverseList(ll).toArray()));
        
    }

    private static LinkedList<Integer> ReverseList(LinkedList<Integer> sourcedList) {
        LinkedList<Integer> list = new LinkedList<>();
        Iterator<Integer> iter = sourcedList.descendingIterator();
        while (iter.hasNext()) {
           list.add(iter.next());
        }
        return list;
    }

    private static LinkedList<Integer> generateRandomList(int size, int startRange, int endRange) {
        LinkedList<Integer> list = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(startRange, endRange));
        }
        return list;
    }
}
