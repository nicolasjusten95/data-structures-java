import java.util.ArrayList;
import java.util.Objects;

public class MyHashTable<K, V> {

    // Implementation of hash table with capacity of 10;
    int size;
    int numBuckets;
    ArrayList<HashNode<K, V>> bucketArray;

    MyHashTable() {
        this.bucketArray = new ArrayList<>();
        this.numBuckets = 10;
        this.size = 0;

        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key) {
        int index = hashCode(key) % numBuckets;
        // HashCode could be negative
        index = index < 0 ? index * -1 : index;
        return index;
    }

    public V remove(K key) {

        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> previous = null;
        while (head != null) {
            if (head.key.equals(key))
                break;
            previous = head;
            head = head.next;
        }

        if (head == null || !head.key.equals(key))
            return null;

        size--;
        if (previous != null)
            previous.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(index);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    void add(K key, V value) {

        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newHashNode = new HashNode<>(key, value);
        newHashNode.next = head;
        bucketArray.set(bucketIndex, newHashNode);

        if (size / numBuckets >= 0.75) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = numBuckets * 2;
            size = 0;
            for (int i = 0; i < numBuckets; i++) {
                bucketArray.add(null);
            }
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < bucketArray.size(); i++) {
            HashNode<K, V> head = bucketArray.get(i);
            while (head != null) {
                System.out.println(head.key + " : " + head.value);
                head = head.next;
            }
        }
    }

    class HashNode<K, V> {

        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        MyHashTable<Integer, String> myHashTable = new MyHashTable<>();
        myHashTable.add(1, "Test1");
        myHashTable.add(3, "Test3");
        myHashTable.add(5, "Test5");
        myHashTable.add(6, "Test6");
        myHashTable.remove(3);
        System.out.println(myHashTable.get(5));
        myHashTable.print();

    }

}
