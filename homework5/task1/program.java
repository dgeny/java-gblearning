package homework5.task1;

import java.util.Map;

/* Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
    что 1 человек может иметь несколько телефонов. */
public class program {
    public static void main(String[] args) {
        /* Реализации полного функционала работы с книгой нет в условии 
         * По сути CRUD - это про контроллер, а не модель
        */
        PhoneBook book = new PhoneBook();
        book.createRecord("Иванов", null, "1234567");
        book.createRecord("Петров", null, "1234568");
        book.createRecord("Сидоров", null, "1234569");
        book.createRecord("Иванов", null, "1234560");
        System.out.println("Телефонная книга:");
        System.out.println(book.toString());
        System.out.println("Ищем Ивановых");
        Map<String,Person> results = book.findByName("Иванов");
        if(results.size()>0){
            System.out.println("Ивановы найдены:\n");
            for (Map.Entry<String, Person> res: results.entrySet()) {
                System.out.println(res.getValue().toString());    
            }
        }
        System.out.println("Ищем номер 1234560");
        results = book.findByNum("1234560");
        if(results.size()>0){
            System.out.println("Номер найден:");
            for (Map.Entry<String, Person> res: results.entrySet()) {
                System.out.println(res.getValue().toString());    
            }
        }
    }
}
