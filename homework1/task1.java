/* Вычислить n-ое треугольного число (сумма чисел от 1 до n) */
package homework1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * task1
 */
public class task1 {

    public static void main(String[] args) {
        int n = inputNumber("Введите n");
        
        System.out.println(String.format(
            "%d-е треугольное число = %d", n, triangle_number_calc(n) 
        ));
    }

    static int inputNumber(String msg)  {
        String str="";
        int res = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean flag = false;
            do {
                try {
                    System.out.println(msg + ": ");  
                    str = br.readLine();   
                    res = Integer.parseInt(str);
                    flag = true;
                } catch (NumberFormatException e) {
                    System.err.println("Введены ошибочные данные");
                }
            } while (!flag);
            br.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
                
        return res;       
    }

    static int triangle_number_calc(int val) {
        return (int)(0.5*val*(val + 1));
    }

    static int factorial(int val) {
        int result = 1;
        for (int i = 1; i <= val; i++) {
            result *= i;
        }
        return result;
    }
}