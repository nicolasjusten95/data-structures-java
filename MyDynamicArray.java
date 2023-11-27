public class MyDynamicArray {

    // Implementation of dynamic array with default capacity of 5
    final int DEFAULT_CAPACITY = 5;

    Object[] array;
    int size;
    int capacity;

    MyDynamicArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = new Object[DEFAULT_CAPACITY];
    }

    private void grow() {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    private void shrink() {
        int newCapacity = capacity / 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    public void add(Object item) {
        if (size >= capacity)
            grow();
        array[size++] = item;
    }

    public void insert(Object item, int index) {
        if (size >= capacity)
            grow();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    public void remove() {
        array[--size] = null;
        if (size < capacity / 3)
            shrink();
    }

    public void delete(Object item) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item))
                found = true;
            if (found)
                array[i] = array[i + 1];
        }
        if (found)
            size--;
        if (size < capacity / 3)
            shrink();
    }

    public int search(Object item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1)
                sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        MyDynamicArray myDynamicArray = new MyDynamicArray();
        myDynamicArray.add(0);
        myDynamicArray.add(1);
        myDynamicArray.add(2);
        myDynamicArray.add(3);
        myDynamicArray.add(4);
        myDynamicArray.add(5);
        myDynamicArray.add(7);
        myDynamicArray.print();
        myDynamicArray.insert(6, 6);
        myDynamicArray.print();
        System.out.println(myDynamicArray.search(1));
        myDynamicArray.remove();
        myDynamicArray.print();
        myDynamicArray.delete(5);
        myDynamicArray.print();
        myDynamicArray.remove();
        myDynamicArray.remove();
        myDynamicArray.remove();
        myDynamicArray.remove();
        myDynamicArray.print();
    }
}
