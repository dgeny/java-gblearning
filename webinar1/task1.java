package webinar1;

import java.time.LocalTime;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        ex0();   
    }

    static void ex0(){
        System.out.println("Как тебя зовут?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        LocalTime time = LocalTime.now();
        LocalTime time1 = LocalTime.of(11, 55);
        int hour = time.getHour();
        if (hour >= 5 && time.isBefore(time1)){
            System.out.println("Доброе утро, " + name + "!");
        } else if ( hour < 18){
            System.out.println("Добрый день, " + name + "!");
        } else if ( hour < 23){
            System.out.println("Добрый вечер, " + name + "!");
        } else {
            System.out.println("Доброй ночи, " + name + "!");
        }
        scanner.close();
    }
}
