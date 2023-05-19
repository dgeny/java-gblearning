package homework5.task1;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private String lastName;
    private String firstName;
    private String surName;
    private Map<String, String> numbers = new HashMap<>();

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void addNumber(String name, String number) {
        this.numbers.put(name, number);
    }

    public void delNumber(String num) {
        for (Map.Entry<String, String> el : this.numbers.entrySet()) {
            if (el.getValue() == num) {
                this.numbers.remove(el.getKey());
            }
        }
    }

    public void editNumber(String name, String number) {
        this.numbers.put(name, number);
    }

    public boolean containsNumber(String num) {
        for (Map.Entry<String,String> el : this.numbers.entrySet()) {
            if (el.getValue() == num) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(String par) {
        return (this.lastName == par || this.firstName == par || this.surName == par) 
            ? true :false;
    }

    @Override
    public String toString() {
        return "Name: " + lastName + " "
                + (firstName != null ? (firstName.toCharArray()[0] + ".") : "")
                + (surName != null ? (surName.toCharArray()[0] + ".") : "" )
                + "\nnumbers=" + numbers +"\n";
    }

}
