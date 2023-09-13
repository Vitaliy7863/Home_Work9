import java.util.Arrays;

public class MyQueue<T> {
    private static final int DEFAULT_LENGTHS = 10;
    private T[] data;
    private int size;

    public void add(Object value) {
        if (size >= data.length) {
            data = Arrays.copyOf(data, data.length + 10);
        }
        data[size] = (T) value;
        size++;
    }

    public void clear() {
        data = Arrays.copyOf(data, 0);
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return data[0];
    }

    public T poll() {
        T result = data[0];
        size--;
        for (int i = 0; i <= data.length; i++) {
            if (i < size) {
            data[i] = data[i + 1];
            }
        }
        return result;
    }

    public MyQueue() {
        data = ((T[]) new Object[DEFAULT_LENGTHS]);
        size = 0;
    }
}
