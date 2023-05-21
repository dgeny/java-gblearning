package webinar6;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    /* 1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое является
    а) информационной системой ветеринарной клиники
    б) архивом выставки котов
    в) информационной системой Театра кошек Ю. Д. Куклачёва
        Можно записать в текстовом виде, не обязательно реализовывать в java.
 */
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String breed; //порода
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }

    private Integer age;
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    private Owner owner;
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    private List<String> healthHistory;
    public void addHeathHistory(String historyRecord){
        healthHistory.add(historyRecord);
    }
    
    public Cat(String name, String breed, Integer age, Owner owner) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
        healthHistory = new ArrayList<String>();
    }
    public Cat(String catName){
        this.setName(catName);
    }

    @Override
    public String toString() {
        return "Кот " + name + "("+breed + ", " + age+" лет)";
    }

    @Override
    public boolean equals(Object obj) {
        Cat ct =obj instanceof Cat ? (Cat) obj : null;
        return this == obj 
            && ct != null 
            && this.name.equals(ct.name) 
            && this.breed.equals(ct.breed) 
            && this.age.equals(ct.age);

    }

    @Override
    public int hashCode() {
        return name.hashCode() + 3*age.hashCode() + 5*breed.hashCode(); 
    }
}
