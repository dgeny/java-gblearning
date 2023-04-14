/* 
 *  1. Задана натуральная степень k. Сформировать случайным
    образом список коэффициентов (значения от 0 до 100)
    многочлена многочлен степени k.
 * Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0
 */
package lection1;

import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        String[] polynom = new String[input_number("Введите степень многочлена") + 1];
        Random rnd = new Random();
        int min_seed = 0;
        int max_seed = 100;

        int cnt = 0;
        do {
            int idx = polynom.length - 1 - cnt;
            int coef = rnd.nextInt(min_seed, max_seed + 1);
            switch (cnt) {
                case 0:
                    polynom[idx] = String.format("%s = 0\n", coef != 0 ? Integer.toString(coef) : "");
                    break;
                case 1:
                    polynom[idx] = String.format("%s*x", coef != 0 ? Integer.toString(coef) : "");
                    break;
                default:
                    polynom[idx] = String.format("%d*x^%d ", coef, cnt);
                    break;
            }
            cnt++;
        } while (cnt < polynom.length);

        var result = String.join(" + ", polynom);
        System.out.println(result);
    }

    static int input_number(String msg) {
        int n = -1;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        while (!flag) {
            System.out.print(msg + ": ");
            flag = input.hasNextInt();
            if (flag) {
                n = input.nextInt();
            } else {
                input.next();
            }
        }
        input.close();
        return n;
    }
}
