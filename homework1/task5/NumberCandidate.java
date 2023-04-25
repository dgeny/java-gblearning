package homework1.task5;

import java.util.ArrayList;


public class NumberCandidate {
    private static ArrayList<Double> candidates = new ArrayList<Double>();

    public NumberCandidate (String numString) {
        if(numString.contains("?")){
            maker(numString);
        }
        else{
            candidates.add(Double.parseDouble(numString));
        }
    }

    private static String maker(String in){
        if(!in.contains("?")){
            return in;
        }
        else{
            for (Integer i = 0; i < 10; i++) {
                String a = maker(in.replaceFirst("\\?", i.toString()));
                if(!a.contains("?"))
                    candidates.add(Double.parseDouble(a));    
            }         
        }
        return in;
    }

    public Double[] getCandidats(){
        return (Double[])candidates.toArray(new Double[0]);
    }
    
    public static Double[] getCandidats(String numString){
        candidates.clear();
        if(numString.contains("?")){
            maker(numString);
        }
        else{
            candidates.add(Double.parseDouble(numString));
        }
        return candidates.toArray(new Double[0]);
    }
}
