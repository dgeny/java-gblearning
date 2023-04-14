/* Во фразе "Добро пожаловать на курс по Java" 
переставить слова в обратном порядке. */
package webinar1;

public class task4 {
    public static void main(String[] args) {
        String phrase = "Добро пожаловать на курс по Java";
        System.out.println(reverseByWord(phrase) );
    }

    static String reverseByWord(String phr){
       
        String res = "";
        String[] temp = phr.split(" ");
        for (int i = temp.length-1; i >= 0; i--) {
            res += temp[i] + " ";
        }
        return res;
    }
}
