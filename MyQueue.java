public class MyQueue {

    // Array implementation of fixed size queue

    private Object[] items;
    private int size;
    private int front;
    private int rear;

    MyQueue(int size) {
        this.items = new Object[size];
        this.size = size;
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(Object item) {
        if (isFull())
            System.out.println("Queue is full");
        else {
            if (front == -1)
                front++;
            items[++rear] = item;
        }
    }

    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            Object item = items[front];
            if (front == rear)
                front = rear = -1;
            else
                front++;
            return item;
        }
    }

    public Object peek() {
        if (isEmpty())
            System.out.println("Queue is empty");
        return items[front];
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = front; i <= rear; i++) {
            sb.append(items[i]);
            if (i < rear)
                sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.enqueue("Item 1");
        myQueue.enqueue("Item 2");
        myQueue.enqueue("Item 3");
        myQueue.enqueue("Item 4");
        myQueue.print();
        myQueue.dequeue();
        myQueue.print();
        System.out.println(myQueue.peek());
    }

}
