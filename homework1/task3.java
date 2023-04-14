/* Вывести все **простые** числа от 1 до 1000 */
package homework1;

import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        int maxSimple = 1000;
        int[] simples = new int[1];
        simples[0] = 1;
        for (int i = 2; i < maxSimple; i++) {
            if(isSimple(simples, i)){
                simples = extendArray(simples, i);
            }
        }
        System.out.println(Arrays.toString(simples));
    }

    /* можно было и list, но мы же не проходили, поэтому оверхед */
    static int[] extendArray(int[] array, int number){
        int[] returnArray = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            returnArray[i] = array[i];
        }
        returnArray[array.length] = number;
        return returnArray;
    }

    static boolean isSimple(int[] simples, int number) {
        for (int i = 0; i < simples.length; i++) {
            if(number%simples[i] == 0 && simples[i] != 1)
            {
                return false;
            }
        }
        return true;
    }
}
