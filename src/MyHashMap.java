import java.util.Arrays;
import java.util.HashMap;

public class MyHashMap<K, V> {
    private static final int DEFAULT_SIZE = 8;
    private Node<K, V>[] node = new Node[DEFAULT_SIZE];
    private int size;

    public void put(Object key, Object value) {
        int index = getBucketIndex((K) key);
        Node<K, V> kvNode = (Node<K, V>) new Node<>(key, value, null);
        if (size == node.length) {
            node = Arrays.copyOf(node, DEFAULT_SIZE + 8);
        }
        if (node[index] == null) {
            node[index] = kvNode;
        } else {
            Node<K, V> current = node[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = kvNode;
        }
        size++;
    }

    public void remove(Object key) {
        int index = getBucketIndex((K) key);
        if (node[index].getKey().equals(key)) {
            node[index].value = null;
            node[index].key = null;
            size--;
        } else {
            node[index].next.value = null;
            node[index].key = null;
            size--;
        }
    }


    public void clear() {
        if (node != null && size > 0) {
            size = 0;
            for (int i = 0; i < node.length; i++)
                node[i] = null;
        }
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        Object result = "";
        int index = getBucketIndex((K) key);
        if (node[index].getKey().equals(key)) {
            result = node[index].value;
        } else {
            Node<K, V> current = node[index];
            while (current.next != null ) {
                if (current.getKey().equals(key)) {
                    result = node[index].next.value;
                    break;
                }
                current = current.next;
            }
            if (current.next == null) {
                result = null;
            }
        }
        return result;
    }

    private int getBucketIndex(K kay) {
        return Math.abs(kay.hashCode()) % node.length;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }
    }
}
