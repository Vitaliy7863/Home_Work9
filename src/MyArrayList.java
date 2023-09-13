import java.util.Arrays;

public class MyArrayList<T> {
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

    public void remove(int index) {
        for (int i = 0; i < size - index; i++) {
            data[index + i] = data[index + i + 1];
        }
    }

    public void clear(){
        data = Arrays.copyOf(data, 0);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    public MyArrayList() {
        data = ((T[]) new Object[DEFAULT_LENGTHS]);
        size = 0;
    }
}