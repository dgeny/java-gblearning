package homework4;

import java.util.Arrays;
import java.util.Random;

public class task4 {
    public static void main(String[] args) {
        QueueViaArray queue = generateRandomQueue(10,0,10);
        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println("Первый элемент(вызов метода first):\t" + queue.first());
        System.out.println("Первый элемент(вызов метода dequeue):\t" + queue.dequeue());
        System.out.print("Текущее состояние очереди: \t");
        System.out.println(Arrays.toString(queue.toArray()));
    }
    
    private static QueueViaArray generateRandomQueue(int size, int startRange, int endRange) {
        QueueViaArray list = new QueueViaArray();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.enqueue(rnd.nextInt(startRange, endRange));
        }
        return list;
    }
}
