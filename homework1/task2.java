/* Вычислить n! */
package homework1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * task1
 */
public class task2 {

    public static void main(String[] args) {
        int n = inputNumber("Введите n");
        
        System.out.println(String.format(
            "%d!  = %d", n, factorial(n) 
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

    static int factorial(int val) {
        int result = 1;
        for (int i = 1; i <= val; i++) {
            result *= i;
        }
        return result;
    }
}