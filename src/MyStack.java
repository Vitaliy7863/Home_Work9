import java.util.Arrays;

public class MyStack<T> {
    private static final int DEFAULT_LENGTHS = 10;
    private T[] data;
    private int size;

    public void push(Object value) {
        if (size >= data.length) {
            data = Arrays.copyOf(data, data.length + 10);
        }
        data[size] = (T) value;
        size++;
    }

    public void remove(int index) {
        for (int i = 0; i < size - index; i++) {
            data[index + i] = data[index + i + 1];
        }
        size--;
    }

    public void clear() {
        size = 0;
        data = Arrays.copyOf(data, 0);
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return data[size - 1];
    }

    public T pop() {
        if (size == 0) {
            return null;
        }
        T first = data[size - 1];
        data[size - 1] = null;
        size--;
        return first;
    }

    public MyStack() {
        data = ((T[]) new Object[DEFAULT_LENGTHS]);
        size = 0;
    }
}
