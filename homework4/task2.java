package homework4;

import java.util.Arrays;
import java.util.Random;

/* Реализуйте очередь с помощью LinkedList со следующими методами: 
    a. enqueue() - помещает элемент в конец очереди, 
    b. dequeue() - возвращает первый элемент из очереди и удаляет его, 
    c. first() - возвращает первый элемент из очереди, не удаляя. */

public class task2 {
    public static void main(String[] args) {
        QueueLinked<Integer> queue = generateRandomQueue(10, 0, 10);
        System.out.print("Исходная очередь: \t");
        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println("Первый элемент(вызов метода first):\t" + queue.first());
        System.out.println("Первый элемент(вызов метода dequeue):\t" + queue.dequeue());
        System.out.print("Текущее состояние очереди: \t");
        System.out.println(Arrays.toString(queue.toArray()));

    }

    private static QueueLinked<Integer> generateRandomQueue(int size, int startRange, int endRange) {
        QueueLinked<Integer> list = new QueueLinked<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.enqueue(rnd.nextInt(startRange, endRange));
        }
        return list;
    }
}