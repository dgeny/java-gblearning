package webinar3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class program {
    public static void main(String[] args) {
        List<ArrayList<String>> shop = fillShop();
        System.out.println(shop);
    }

    

    private static List<ArrayList<String>> fillShop() {
        /* Каталог товаров книжного магазина сохранен в виде двумерного списка 
        List<ArrayList<String>> так, что на 0й позиции каждого внутреннего списка 
        содержится название жанра, а на остальных позициях - названия книг. 
        Напишите метод для заполнения данной структуры. */

        List<ArrayList<String>> shop = new ArrayList<>();
        addBook(shop, "фантастика", "гарри поттер");
        addBook(shop, "роман", "война и мир");
        addBook(shop, "фантастика", "гарри поттер");
        addBook(shop, "сказка", "репка");
        addBook(shop, "сказка", "колобок");
        return shop;
    }

    private static void addBook(List<ArrayList<String>> shop, String genre, String bookname) {
        for (int i = 0; i < shop.size(); i++) {
            if(shop.get(i).get(0).equalsIgnoreCase(genre)){
                shop.get(i).add(bookname);
                return;
            }
        }
        shop.add(new ArrayList<>());
        shop.get(shop.size()-1).add(0, genre);
        shop.get(shop.size()-1).add(bookname);
    }

    public static void task3() {
        /* Создать список типа ArrayList
        Поместить в него как строки, так и целые числа. 
        Пройти по списку, найти и удалить целые числа. */

        List<Object> list = new ArrayList<>();
        list.add(4);
        list.add("5");
        list.add(10);
        list.add("!!!!!");
        list.add("qwe");
        list.add("rty");
        list.add(-104);
        list.add(4.5);
        list.add("asd");

        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Integer){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);

        //list.removeIf(Predicate.not(instanceof Integer));
    }

    public static void task2() {
        /* Заполнить список десятью случайными числами. 
        Отсортировать список методом sort() и вывести его на экран. */
        List<Integer> list = createList(10, 0, 1000);
        printList(list);
        sortList(list);
        printList(list);
    }

    static void sortList(List<Integer> list) {
        Collections.sort(list, Comparator.reverseOrder());
    }

    static void printList(List<Integer> list) {
        System.out.println(list);
    }

    static List<Integer> createList(int size, int min, int max) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            
            list.add(((int)Math.round(Math.random()*(max-min+1)+min)));        
        }
        return list;
    }
}
