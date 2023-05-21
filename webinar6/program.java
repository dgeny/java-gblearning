package webinar6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class program {
    public static void main(String[] args) {
        ex1();
    }

    static void ex1(){
        /* 1. Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24. 
        2. Создайте метод, в который передайте заполненный выше массив и 
        с помощью Set вычислите процент уникальных значений в данном массиве и 
        верните его в виде числа с плавающей запятой.
        Для вычисления процента используйте формулу:
        процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве. */
        System.out.println(uniqPercent(createArray(1000, 0, 24)));
    }

    static double uniqPercent(Integer[] array){
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        double uniqPercent = set.size() * 100.0 / array.length;
        return uniqPercent;
    }

    static Integer[] createArray(int capacity, int min, int max){
        Integer[] array = new Integer[capacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*(max-min+1)+min);
        }
        return array;
    }

    void ex0(){
        /* 1. Создайте HashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}. Распечатайте содержимое данного множества.
            2. Создайте LinkedHashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.  Распечатайте содержимое данного множества.
            3. Создайте TreeSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.  Распечатайте содержимое данного множества. */
            Integer[] arr = new Integer[]{3, 2, 6, 1, 2, 4, 5, 3};
            Set<Integer> set1 = new HashSet<>(Arrays.asList(arr));
            Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(arr));
            //Set<Integer> set3 = new TreeSet<>(Arrays.asList(arr));
            System.out.println(set1);
            System.out.println(set2);
            System.out.println(set2);

    }
}
