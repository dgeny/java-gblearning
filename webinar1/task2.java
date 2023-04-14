/*
 * Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
 */
package webinar1;

import java.util.Arrays;
import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        
        int[] randomArray = generateArray(20, 0, 1);
        System.out.println(Arrays.toString(randomArray));
        System.out.println(count_ones(randomArray));
    }

    static int[] generateArray(int size, int min_seed, int max_seed){
        int[] resultArray = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            resultArray[i] = rnd.nextInt(min_seed, max_seed+1);
        }
        return resultArray;
    }

    static int count_ones(int[] arr){
        int maxOnes = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                temp++;
            }
            else{
                if (temp > maxOnes){
                    maxOnes = temp;
                }
                temp = 0;
            }
        }
        if (temp > maxOnes){
            maxOnes = temp;
        }
        return maxOnes;
    }

}
