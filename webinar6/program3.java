package webinar6;

import java.util.HashSet;
import java.util.Set;

/* 1. Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>. 
    Поместите в него некоторое количество объектов.
    2. Создайте 2 или более котов с одинаковыми параметрами в полях. 
    Поместите их во множество. Убедитесь, что все они сохранились во множество. 
    3. Создайте метод public boolean equals(Object o)
    Пропишите в нём логику сравнения котов по параметрам, хранимым в полях.
     То есть, метод должен возвращать true, только если значения во всех полях сравниваемых объектов равны.
    4. Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились */

public class program3 {
    public static void main(String[] args) {
        Owner own1 = new Owner();
        own1.name = "Иван Иваныч";
        Owner own2 = new Owner();
        own2.name = "Петр Иваныч";
        Cat cat1 = new Cat("Cat1","breed1", 5, own1);
        Cat cat2 = new Cat("Cat2", "breed2", 5, own2);
        Cat cat3 = new Cat("Cat1", "breed1", 5, own1);

        Set<Cat> setCats = new HashSet<>();
        setCats.add(cat1);
        setCats.add(cat2);
        setCats.add(cat3);
        for (Cat cat : setCats) {
            System.out.println(cat);
        }
        
        //setCats.forEach(Cat ct -> if(ct.getAge() == 8) System.out.println(ct));
    }
}
