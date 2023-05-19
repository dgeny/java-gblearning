package homework5.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class PhoneBook {
    private Map<String, Person> records = new HashMap<>(); 
    
    public void createRecord(String lastname, String numberName, String num) {
        Person entry = new Person();
        entry.setLastName(lastname);
        entry.addNumber(numberName != null ? numberName : "Mobile", num);
        records.put(UUID.randomUUID().toString(), entry);
    }

    public void updateRecord(String uuid, Person item){
        records.put(uuid, item);
    }

    public boolean deleteRecord(String uuid){
        Person marked = this.records.remove(uuid);
        return (marked != null) ? true:false;
    }

    public Person readRecord(String uuid){
        return records.get(uuid);
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        this.records.forEach((String UUID, Person rec) -> sb.append(rec.toString()));
        return sb.toString();
    }

    public Map<String, Person> findByName(String criteria) {
        Map<String, Person> results = new HashMap<>();
        for (Map.Entry<String, Person> rec: records.entrySet()) {
            if(rec.getValue().contains(criteria)){
                results.put(rec.getKey(), rec.getValue());
            }
        }
        return results.size() > 0 ? results : null;
    }

    public Map<String, Person> findByNum(String criteria) {
        Map<String, Person> results = new HashMap<>();
        for (Map.Entry<String, Person> rec: records.entrySet()) {
            if(rec.getValue().containsNumber(criteria)){
                results.put(rec.getKey(), rec.getValue());
            }
        }
        return results.size() > 0 ? results : null;
    }
}
