/* Реализовать простой калькулятор
 */
package homework1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;

public class task4 {

    public static void main(String[] args) {
        calcViaRegex();
    }

    static void calcViaRegex(){
        String str="";
        try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("введите выражение для вычисления или 'q' для выхода: ");  
                str = br.readLine();   
                String[] parsed = parseOperands(str);
                if(parsed.length == 3){
                    printResult(
                        Double.parseDouble(parsed[0]), Double.parseDouble(parsed[2]), parsed[1]);
                }
                else if (str.charAt(0) == 'q')
                {
                    
                }
                else{
                    System.out.println("Введено некорректное выражение");
                }
            } while (str.charAt(0) != 'q');
            br.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static String[] parseOperands(String input){
        Pattern ptrn = Pattern.compile(
                "(?<f>-?\\d*\\.{0,1}\\d+)(?<op>[+-/*])(?<s>-?\\d*\\.{0,1}\\d+)");
        Matcher mtch = ptrn.matcher(input);
        if(mtch.matches()){
            return new String[] {
                mtch.group("f"),
                mtch.group("op"),
                mtch.group("s")
            };
        }
        else{
            return new String[0];
        }
    } 

    static void printResult(double first, double second, String oper) {
        Double res = 0D;
        switch (oper) {
            case "+":
                res = first+second;
                break;
            case "-":
                res = first-second;
                break;
            case "*":
                res = first*second;
                break;
            case "/":
                res = first/second;
                break;
            default:
                break;
        }    
        if(res.toString().matches(".*\\.0")){
            System.out.println(res.intValue());
        }
        else{
            System.out.println(res);
        }
    }
}