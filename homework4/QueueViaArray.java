package homework4;

public class QueueViaArray {
    private Integer[] arr = new Integer[10];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Integer item) {
        if (size == arr.length) {
            Integer[] a = new Integer[arr.length + 10];
            System.arraycopy(a, 0, arr, 0, a.length);
            arr = a;
        }
        arr[size++] = item;
    }

    public Integer dequeue() {
        if (size < 1) {
            System.out.println("Очередь пуста");
            return null;
        }
        int item = arr[0];
        System.arraycopy(arr, 1, arr, 0, arr.length - 1);
        size--;
        return item;
    }

    public Integer first() {
        if (size < 1) {
            System.out.println("Очередь пуста");
            return null;
        }

        return arr[0];
    }

    public Object[] toArray() {
        if (size == 0) {
            return new Object[] {};
        }
        Integer[] a = new Integer[size];
        System.arraycopy(arr, 0, a, 0, size);
        return a;
    }

}
