import java.util.LinkedList;

public class MyAdjacencyList {

    // Implementation of directed graph as adjacency list
    private LinkedList<Node>[] adjList;

    MyAdjacencyList(int numVertices) {
        this.adjList = new LinkedList[numVertices];
    }

    public void setNode(int i, Node node) {
        LinkedList<Node> newLinkedList = new LinkedList<>();
        newLinkedList.add(node);
        adjList[i] = newLinkedList;
    }

    public void addEdge(int i, int j) {
        LinkedList<Node> currentList = adjList[i];
        Node currentNode = adjList[j].getFirst();
        currentList.add(currentNode);
    }

    public void removeEdge(int i, int j) {
        LinkedList<Node> currentLinkedList = adjList[i];
        Node currentNode = adjList[j].getFirst();
        currentLinkedList.remove(currentNode);
    }

    public boolean checkEdge(int i, int j) {
        LinkedList<Node> currentLinkedList = adjList[i];
        Node currentNode = adjList[j].getFirst();
        for (Node node : currentLinkedList) {
            if (node.equals(currentNode)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < adjList.length; i++) {
            for (Node node : adjList[i]) {
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyAdjacencyList myAdjacencyList = new MyAdjacencyList(5);
        myAdjacencyList.setNode(0, new Node('A'));
        myAdjacencyList.setNode(1, new Node('B'));
        myAdjacencyList.setNode(2, new Node('C'));
        myAdjacencyList.setNode(3, new Node('D'));
        myAdjacencyList.setNode(4, new Node('E'));
        myAdjacencyList.addEdge(0, 1);
        myAdjacencyList.addEdge(1, 3);
        myAdjacencyList.addEdge(3, 4);
        myAdjacencyList.addEdge(3, 2);
        System.out.println(myAdjacencyList.checkEdge(3, 2));
        myAdjacencyList.removeEdge(3, 2);
        System.out.println(myAdjacencyList.checkEdge(3, 2));
        myAdjacencyList.print();
    }

}

class Node {
    char data;

    Node(char data) {
        this.data = data;
    }
}
