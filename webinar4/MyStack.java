package webinar4;

public class MyStack {
    private Integer[] a = new Integer[10];
    private int size = 0;
    
    int size(){
        return size;
    }
    
    boolean empty(){
        return size == 0;
    }
    
    void push(int el){
        if(size == a.length){
            Integer[] arr = new Integer[a.length+10];
            System.arraycopy(a, 0, arr, 0, a.length);
            a = arr;
        }
        a[size++] = el;
    }
    
    int peak(){
        return a[size-1];
    }
    
    int pop(){
        size--;
        return a[size];
    }

    String toString1() { 
        StringBuilder retStr = new StringBuilder();
        for (Integer integer : a) {
            retStr.append(integer.toString());
            retStr.append(", ");
        }    
        return retStr.toString();
    }
}
