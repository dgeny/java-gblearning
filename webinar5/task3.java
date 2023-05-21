package webinar5;

import java.util.HashMap;
import java.util.Map;
//import java.util.Stack;

/*
    Написать программу, определяющую правильность расстановки скобок в выражении.
    Пример 1: a+(d*3) - истина
    Пример 2: [a+(1]*3) - ложь
    Пример 3: [6+(3*3)] - истина
    Пример 4: {a}[+]{(d*3)} - истина
    Пример 5: <{a}+{(d*3)}> - истина
    Пример 6: {a+]}{(d*3)} - ложь
*/
public class task3 {
    public static void main(String[] args) {
        assert checkSigns("a+(d*3)") : "что-то не так!";
        assert !checkSigns("[a+(1]*3)") : "что-то не так!";
        assert checkSigns("[6+(3*3)]")  : "что-то не так!";
        assert checkSigns("{a}[+]{(d*3)}")  : "что-то не так!";
        assert checkSigns("<{a}+{(d*3)}>")  : "что-то не так!";
        assert checkSigns("{a+]}{(d*3)}")  : "что-то не так!";
    }

    private static boolean checkSigns(String str) {
        //Stack<Character> stack= new Stack<>();
        //char[] c1 = str.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        map.put('<','>');
        
        return true;
    }
}
