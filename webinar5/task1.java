package webinar5;

/**
 * Создать структуру для хранения паспортов и фамилий сотрудников организации
 * 123456 Иванов
 * 321456 Васильев
 * 234561 Петрова
 * 234432 Иванов
 * 654321 Петрова
 * 345678 Иванов
 * Вывести данные по сотрудникам с фамилией Иванов
 */
public class task1 {

    public static void main(String[] args) {
        Passports db = new Passports();
        db.add("321456", "Васильев");
        db.add("234561", "Петрова");
        db.add("234432", "Иванов");
        db.add("654321", "Петрова");
        db.add("345678", "Иванов");
        db.add("123456", "Иванов" );

        System.out.println(db.getAll());
        System.out.println(db.getByLastName("Иванов"));
        
    }    
}