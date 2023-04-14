/* Реализовать функцию возведения числа а в степень b. a, b из Z. Сводя количество выполняемых действий к минимуму.
Пример 1: а = 3, b = 2, ответ: 9
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1 */
package webinar1;

public class task5 {
    public static void main(String[] args) {
        System.out.println(crunchPow(2, -2));
    }

    static double crunchPow(int a, int b) {
        /*
        Реализовать функцию возведения числа а в степень b. a, b из Z. Сводя количество выполняемых действий к минимуму.
        Пример 1: а = 3, b = 2, ответ: 9
        Пример 2: а = 2, b = -2, ответ: 0.25
        Пример 3: а = 3, b = 0, ответ: 1
         */
        if (b == 0 || a == 1) {
            return 1;
        }
        if (a == 0){
            return 0;
        }
        double res = 1;
        for (int i = 0; i < Math.abs(b); i++) {
            res *= a;
        }
        return b>0 ? res : 1.0/res;
    }
}
