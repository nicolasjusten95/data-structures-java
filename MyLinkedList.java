public class MyLinkedList {

    // Implementation of doubly linked list

    Node head;
    Node tail;
    int size;

    MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (size == 0)
            tail = newNode;
        else {
            newNode.setNext(head);
            head.setPrevious(newNode);
        }
        head = newNode;
        size++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (size == 0)
            head = newNode;
        else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
        size++;
    }

    public Object removeLast() {
        Node last = tail;
        if (tail != null) {
            tail = last.getPrevious();
            tail.setNext(null);
            size--;
            return last.getData();
        }
        return null;
    }

    public Object removeFirst() {
        Node first = head;
        if (first != null) {
            head = first.getNext();
            head.setPrevious(null);
            size--;
            return first.getData();
        }
        return null;
    }

    public Object peekFirst() {
        return head.getData();
    }

    public Object peekLast() {
        return tail.getData();
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != null)
                sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    class Node {

        Object data;
        Node next;
        Node previous;

        Node(Object data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public Object getData() {
            return data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getPrevious() {
            return previous;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.print();
        myLinkedList.addFirst("2");
        myLinkedList.addFirst("1");
        myLinkedList.addLast("3");
        myLinkedList.print();
        System.out.println(myLinkedList.peekFirst());
        System.out.println(myLinkedList.peekLast());
        myLinkedList.removeFirst();
        myLinkedList.removeLast();
        myLinkedList.print();
    }
}
