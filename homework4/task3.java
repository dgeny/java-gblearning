package homework4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/* Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. 
    Используйте итератор */
public class task3 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = generateRandomList(10, 0, 10);
        System.out.print("Исходный список:\t");
        System.out.println(Arrays.toString(ll.toArray()));
        int sum = 0;
        Iterator<Integer> iter = ll.iterator();
        while (iter.hasNext()) {
            sum += iter.next();
        }
        System.out.println("Итого:" + sum);
        System.out.print("Cписок после суммирования:\t");
        System.out.println(Arrays.toString(ll.toArray()));
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
