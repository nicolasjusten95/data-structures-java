import java.util.NoSuchElementException;

public class MyStack<E> {

    // Array with items of the stack
    private Object[] items;

    // Represent top of the stack
    private int top;

    // Represent capacity of the stack
    private int capacity;

    // Constructor
    public MyStack(int size) {
        this.items = new Object[size];
        this.capacity = size;
        this.top = -1;
    }

    // Push function
    public void push(E item) {
        if (isFull())
            throw new StackOverflowError("Stack is full");
        items[++top] = item;
    }

    // Pop function
    public E pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");
        E item = (E) items[top];
        items[top--] = null;
        return item;
    }

    // Function to get the size of the stack
    private int size() {
        return top + 1;
    }

    // Function to check whether the stack is empty
    private boolean isEmpty() {
        return size() == 0;
    }

    // Function to check whether the stack is full
    private boolean isFull() {
        return size() == capacity;
    }

    private void print() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i <= top; i++) {
            sb.append(items[i]);
            if (i < top)
                sb.append(", ");
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {

        MyStack<String> myStack = new MyStack<>(5);

        myStack.push("Item 1");
        myStack.push("Item 2");
        myStack.push("Item 3");

        myStack.print();

        myStack.pop();

        myStack.print();
    }

}
