/* Дан массив nums = [3,2,5,3] и число val = 3. 
Если в массиве есть числа, равные заданному, нужно 
перенести эти элементы в конец массива. 
Таким образом, первые несколько (или все) 
элементов массива должны быть отличны от заданного, а остальные - равны ему.
 */

package webinar1;

import java.util.Arrays;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        int[] randomArray = generateArray(10, 1, 5);
        int val = 3;
        System.out.println(Arrays.toString(getResultArray(randomArray, val)));
    }

    static int[] generateArray(int size, int min_seed, int max_seed){
        int[] resultArray = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            resultArray[i] = rnd.nextInt(min_seed, max_seed+1);
        }
        return resultArray;
    }

    static int[] getResultArray(int[] temp, int condition) {
        int size = temp.length;
        int[] result = new int[size];

        Arrays.fill(result, condition);

        for (int i = 0, j =0; i < size; i++) {
            if (temp[i] != condition) {
                result[j++] = temp[i];
            }
        }

        return result;
    }
}

