public class MyStack {

    // Array implementation of fixed size stack

    private Object[] items;
    private int top;
    private int size;

    MyStack(int size) {
        this.items = new Object[size];
        this.size = size;
        this.top = -1;
    }

    public void push(Object item) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        items[++top] = item;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Object item = items[top];
        items[top--] = null;
        return item;
    }

    private int size() {
        return top + 1;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    private boolean isFull() {
        return size() == size;
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
        MyStack myStack = new MyStack(3);
        myStack.pop();
        myStack.push("Item 1");
        myStack.push("Item 2");
        myStack.print();
        myStack.push("Item 3");
        myStack.push("Item 4");
        myStack.print();
        myStack.pop();
        myStack.print();
    }

}
