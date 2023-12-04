public class MyAdjacencyMatrix {

    // Implementation of directed graph as adjacency matrix
    private Node[] nodes;
    private boolean[][] adjMatrix;

    MyAdjacencyMatrix(int numVertices) {
        this.nodes = new Node[numVertices];
        this.adjMatrix = new boolean[numVertices][numVertices];
    }

    public void setNode(int i, Node node) {
        nodes[i] = node;
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
    }

    public boolean checkEdge(int i, int j) {
        return adjMatrix[i][j];
    }

    public void print() {
        System.out.print("\t");
        for (Node node : nodes) {
            System.out.print(node.data + "\t");
        }
        System.out.println();
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.print(nodes[i].data + "\t");
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyAdjacencyMatrix myAdjacencyMatrix = new MyAdjacencyMatrix(5);
        myAdjacencyMatrix.setNode(0, new Node('A'));
        myAdjacencyMatrix.setNode(1, new Node('B'));
        myAdjacencyMatrix.setNode(2, new Node('C'));
        myAdjacencyMatrix.setNode(3, new Node('D'));
        myAdjacencyMatrix.setNode(4, new Node('E'));
        myAdjacencyMatrix.addEdge(0, 1);
        myAdjacencyMatrix.addEdge(1, 3);
        myAdjacencyMatrix.addEdge(3, 4);
        myAdjacencyMatrix.addEdge(3, 2);
        System.out.println(myAdjacencyMatrix.checkEdge(3, 2));
        myAdjacencyMatrix.removeEdge(3, 2);
        System.out.println(myAdjacencyMatrix.checkEdge(3, 2));
        myAdjacencyMatrix.print();
    }

}

class Node {
    char data;

    Node(char data) {
        this.data = data;
    }
}
