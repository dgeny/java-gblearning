package homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import webinar3.main;

/**
 * task3
 */
public class task3 {

    public static void main(String[] args) {
        /* Заполнить список названиями планет Солнечной системы в произвольном порядке
         с повторениями. Вывести название каждой планеты 
         и количество его повторений в списке. */
         int countItems = 50;
         String[] listItems = new String[]{"Меркурий", "Венера", "Земля", "Марс", "Юпитер", 
            "Сатурн", "Уран", "Нептун", "Плутон"};
         ArrayList<String> list = generateRandomPlanetList(countItems, listItems);
         System.out.println(list);
         agg(list);
    }

    private static void agg(ArrayList<String> list) {
        Set<String> uniqueItems = new HashSet<String>(list);
        Map<String, Integer> aggs = new HashMap<String, Integer>();
        for (String string : uniqueItems) {
            aggs.put(string, Collections.frequency(list, string));
        }
        System.out.println(aggs);
    }

    private static ArrayList<String> generateRandomPlanetList(int countItems, String[] listItems) {
        ArrayList<String> resultList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < countItems; i++) {
            resultList.add(
                listItems[rnd.nextInt(0, listItems.length)]);
        }        
        return resultList;
    }
}