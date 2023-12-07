public class MyBinarySearchTree {

    MyTreeNode root;

    public void insert(MyTreeNode node) {
        root = insertHelper(root, node);
    }

    private MyTreeNode insertHelper(MyTreeNode root, MyTreeNode node) {

        int data = node.data;

        if (root == null) {
            root = node;
            return root;
        }

        if (data < root.data) {
            root.left = insertHelper(root.left, node);
            return root;
        }

        root.right = insertHelper(root.right, node);
        return root;
    }

    public void remove(int data) {
        if (!search(data)) {
            return;
        }

        removeHelper(root, data);
    }

    private MyTreeNode removeHelper(MyTreeNode root, int data) {

        if (root == null) {
            return root;
        } else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.data = successor(root);
                root.right = removeHelper(root.right, data);
            } else {
                root.data = predeccessor(root);
                root.left = removeHelper(root.left, data);
            }
        }

        return root;
    }

    private int successor(MyTreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predeccessor(MyTreeNode root) {
        root = root.right;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    public boolean searchHelper(MyTreeNode root, int data) {

        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }

        if (data < root.data) {
            return searchHelper(root.left, data);
        }

        return searchHelper(root.right, data);
    }

    public void print() {
        printHelper(root);
    }

    private void printHelper(MyTreeNode root) {

        if (root != null) {
            printHelper(root.left);
            System.out.println(root.data);
            printHelper(root.right);
        }

    }

    public static void main(String[] args) {

        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();

        myBinarySearchTree.insert(new MyTreeNode(5));
        myBinarySearchTree.insert(new MyTreeNode(1));
        myBinarySearchTree.insert(new MyTreeNode(9));
        myBinarySearchTree.insert(new MyTreeNode(2));
        myBinarySearchTree.insert(new MyTreeNode(7));
        myBinarySearchTree.insert(new MyTreeNode(3));
        myBinarySearchTree.insert(new MyTreeNode(6));
        myBinarySearchTree.insert(new MyTreeNode(4));
        myBinarySearchTree.insert(new MyTreeNode(8));
        myBinarySearchTree.remove(6);
        myBinarySearchTree.print();
        System.out.println(myBinarySearchTree.search(0));
        System.out.println(myBinarySearchTree.search(7));
    }

}
