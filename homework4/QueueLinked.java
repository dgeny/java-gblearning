package homework4;

import java.util.LinkedList;

public class QueueLinked<T> {
    private LinkedList<Object> list = new LinkedList<Object>();
    
    public int size(){
        return list.size();
    } 

    public void enqueue(Object item){
        list.addLast(item);
    }

    public Object dequeue() {
        if (list.isEmpty()) {
            System.out.println("Очередь пуста");
            return null;
        }
        return list.pop();
    }

    public Object first() {
        if (list.isEmpty()) {
            System.out.println("Очередь пуста");
            return null;
        }
        return list.element();
    }

    public Object[] toArray() {
        if (list.isEmpty()) {
            return new Object[]{};
        }
        return list.toArray();
    }
}
