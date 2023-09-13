import java.util.Objects;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(Object value) {
        Node<T> node = (Node<T>) new Node<>(value);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = head;
        Node<T> previousCurrent = null;
        Node<T> nextCurrent = null;
        for (int i = 0; i < index ; i++) {
            previousCurrent = current;
            current = current.next;
           if (i == index - 1 && i != 0) {
               nextCurrent = current.next;
           }
        }
        previousCurrent.next = current.next;
        nextCurrent.previous = current.previous;
        current.value = null;
        size--;
    }

    public void clear() {
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.next;
            x.value = null;
            x.next = null;
            x.previous = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;
        public Node(T value) {
            this.value = value;
        }
    }

    public int getSize() {
        return size;
    }
}
