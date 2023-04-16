package homework1.task5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;



public class program {
    public static void main(String[] args) {
        String str="";
        try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("введите выражение для вычисления или 'q' для выхода: ");  
                str = br.readLine();   
                String[] parsed = parseInput(str);
                if(parsed.length == 4){
                    // printResult(Double.parseDouble(parsed[0]), Double.parseDouble(parsed[2]), parsed[1]);
                    Double[] fOp = NumberCandidate.getCandidats(parsed[0]);
                    Double[] sOp = NumberCandidate.getCandidats(parsed[2]);
                    Double[] resOp = NumberCandidate.getCandidats(parsed[3]);
                    String[] variants = getVariants(fOp, sOp, resOp, parsed[1]);
                    if (variants.length == 0){
                        System.out.println("Возможных решений не найдено.");
                    }
                    else{
                        System.out.println(String.join("\n",variants));
                    }
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

    static String[] parseInput(String input) {
        String pattern = "(?<f>-?[\\d\\?]*\\.{0,1}[\\d\\?]+)(?<op>[+-/*])(?<s>-?[\\d\\?]*\\.{0,1}[\\d\\?]+)=(?<th>-?[\\d\\?]*\\.{0,1}[\\d\\?]+)";
        Pattern ptrn = Pattern.compile(pattern);
        Matcher mtch = ptrn.matcher(input);
        if(mtch.matches()){
            return new String[] {
                mtch.group("f"),
                mtch.group("op"),
                mtch.group("s"),
                mtch.group("th")
            };
        }
        else return new String[0];        
    }
    
    static String[] getVariants(Double[] fOp,Double[] sOp, Double[] resOp, String op){
        ArrayList<String> result = new ArrayList<String>();
        Double res = 0D;
        for (int i = 0; i < fOp.length; i++) {
            for (int j = 0; j < sOp.length; j++) {
                for (int k = 0; k < resOp.length; k++) {
                    switch (op) {
                        case "+":
                            res = fOp[i] + sOp[j];
                            break;
                        case "-":
                            res = fOp[i] - sOp[j];
                            break;
                        case "*":
                            res = fOp[i] * sOp[j];
                            break;
                        case "/":
                            if (sOp[j] != 0) {
                                res = fOp[i] / sOp[j];
                            }
                            else {
                                continue;
                            }
                            break;
                        default:
                            break;
                    }
                    if(res == resOp[k].doubleValue()){
                        result.add(
                            fOp[i].toString() + op + sOp[j] + "=" + resOp[k]);
                    }    
                }
            }
        }
        return result.toArray(new String[0]);
    }

}
