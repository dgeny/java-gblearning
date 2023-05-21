package webinar4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class program {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    private static void task5() {
        /* Реализовать стэк с помощью массива. 
        Нужно реализовать методы:
        size(), empty(), push(), peek(), pop(). */
        MyStack s = new MyStack();
        s.push(0);
        s.push(1);
        s.push(2);
        System.out.println(s.empty());
        System.out.println(s.peak());
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.toString1());
    }

    private static void task4() {
        /* 1) Написать метод, который принимает массив элементов, 
        помещает их в стэк и выводит на консоль содержимое стэка.
        2) Написать метод, который принимает массив элементов, 
        помещает их в очередь и выводит на консоль содержимое очереди. */
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());    
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());    
        }
        
    }

    private static void task3() {
        /*
         * Реализовать консольное приложение, которое:
         * Принимает от пользователя и “запоминает” строки.
         * Если введено print, выводит строки так,
         * чтобы последняя введенная была первой в списке, а первая - последней.
         * Если введено revert, удаляет предыдущую введенную строку из памяти.
         */

        LinkedList<String> list = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        boolean work = true;
        while (work) {
            String newLine = scan.nextLine();

            switch (newLine) {
                case "print":
                    ListIterator<String> iter = list.listIterator(list.size());
                    while (iter.hasPrevious()) {
                        System.out.println(iter.previous());
                    }
                    break;
                case "revert":
                    System.out.println(list.removeLast());
                    break;
                case "exit":
                    work = false;
                    scan.close();
                    break;
                default:
                    list.add(newLine);
                    break;
            }
            System.out.println(list);
        }

    }

    private static void task1() {
        /**
         * 1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
         * 2) Замерьте время, за которое в LinkedList добавятся 10000 элементов.
         * Сравните с предыдущим.
         */
        List<Integer> list1 = new ArrayList<>();
        
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            list1.add(i);
        }

        long timeFinish1 = System.currentTimeMillis();
        System.out.println(timeFinish1 - timeStart);

        // Вывод: пофиг, но для добавления в позицию LL выигрывает
    }

    private static void task2() {

        /*
         * Реализовать консольное приложение, которое:
         * Принимает от пользователя строку вида
         * text~num
         * Нужно рассплитить строку по ~, сохранить text в связный список на позицию
         * num.
         * Если введено print~num, выводит строку из позиции num в связном списке и
         * удаляет её из списка.
         */
        LinkedList<String> list = new LinkedList<>();
        try (Scanner scan = new Scanner(System.in)) {
            boolean work = true;
            while (work) {
                String newLine = scan.nextLine();
                String[] arr = newLine.split("~");
                int num = Integer.parseInt(arr[1]);
                String text = arr[0];
                switch (text) {
                    case "print":
                        System.out.println(list.remove(num));
                        break;
                    case "exit":
                        work = false;
                        break;
                    default:
                        list.add(num, text);
                        break;
                }
                System.out.println(list);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

}