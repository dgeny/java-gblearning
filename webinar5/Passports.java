package webinar5;

import java.util.HashMap;
import java.util.Map;

public class Passports {
    private Map<String, String> map = new HashMap<>(); 

    public void add(String numPassport, String lastName){
        map.put(numPassport, lastName);
    }

    public String getByNumPassport(String numPassport){
        return numPassport+": "+map.get(numPassport);
    }

    public String getByLastName(String lastName){
        StringBuilder bldr = new StringBuilder();
        for (Map.Entry<String,String> item: map.entrySet()) {
            if(item.getValue().equalsIgnoreCase(lastName)){
                bldr.append(item.getKey());
                bldr.append(": ");
                bldr.append(item.getValue());
                bldr.append("\n");
            }
        }
        return bldr.toString();
    }

    public String getAll(){
        StringBuilder bldr = new StringBuilder();
        for (Map.Entry<String,String> item: map.entrySet()) {
            
                bldr.append(item.getKey());
                bldr.append(": ");
                bldr.append(item.getValue());
                bldr.append("\n");
            
        }
        return bldr.toString();
    }


}
