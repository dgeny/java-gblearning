package homework5.task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*  Пусть дан список сотрудников: 
   Иван Иванов, Светлана Петрова, Кристина Белова, 
   Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, 
   Павел Чернов, Петр Чернышов, Мария Федорова, 
   Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, 
   Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. 
   Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
   Отсортировать по убыванию популярности. 
   Для сортировки использовать TreeMap. 
*/
public class main {
    public static void main(String[] args) {
        List<String> employes = initList();
        System.out.println("Исходный список:");
        System.out.println(Arrays.toString(employes.toArray()));

        Map<Integer,String> sortedList = new TreeMap<>(Comparator.reverseOrder());
        Map<String, Integer> presortedList = new TreeMap<>();
        for (String item: employes) {
            int cnt = 1;
            String name = item.split(" ")[0];
            if(presortedList.containsKey(name)){
                cnt = presortedList.get(name) +1; 
            
            }
            presortedList.put(name, cnt);
        }

        for (Map.Entry<String, Integer> entry: presortedList.entrySet()) {
            if(sortedList.containsKey(entry.getValue())){
                sortedList.put(entry.getValue(), sortedList.get(entry.getValue()) + ", " + entry.getKey());
            }
            else{
                sortedList.put(entry.getValue(), entry.getKey());
            }
        }

        for (Map.Entry<Integer, String> item: sortedList.entrySet()) {
            for(String name: item.getValue().split(", "))
            {
                System.out.println(name + " встречается " + item.getKey() + " раз");
            }
        }
        
    }

    private static List<String> initList() {
        String str = "Иван Иванов, Светлана Петрова, Кристина Белова, "
                + "Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, "
                + "Павел Чернов, Петр Чернышов, Мария Федорова, "
                + "Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, "
                + "Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        List<String> list = new LinkedList<>();
        for (String item: str.split(", ")) {
            list.add(item);    
        }
        return list;
    }
}
