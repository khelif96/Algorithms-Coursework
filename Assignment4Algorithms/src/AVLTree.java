import java.util.Random;

/**
 * Created by mohamed on 7/22/17.
 */
public class AVLTree {

    Node root; // Root node of the AVL Tree

    int getHeight(Node N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }
    int getMax(int a, int b) {
        if(a > b){
            return a;
        }else{
            return b;
        }
    }


    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = getMax(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = getMax(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

  
    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = getMax(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = getMax(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    int getBalance(Node N) {
        if (N == null){
            return 0;
        }
        return getHeight(N.left) - getHeight(N.right);
    }

    Node insert(Node node, int key) {

        if (node == null) {
            return (new Node(key));
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        }else if (key > node.key) {
            node.right = insert(node.right, key);
        }else {
            return node; // Return Duplicate key
        }
        node.height = 1 + getMax(getHeight(node.left), getHeight(node.right));

      
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void printPreorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            printPreorderTraversal(node.left);
            printPreorderTraversal(node.right);
        }
    }

    void printInorderTraversal(Node node){
        if(node != null){
            printInorderTraversal(node.left);
            System.out.print(node.key+ " ");
            printInorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        int treeSize = 10;
        Random rand = new Random();
        for (int i = 0; i < treeSize; i++) {
            tree.root = tree.insert(tree.root, rand.nextInt(50)+1);

        }



        System.out.println("Preorder traversal of constructed AVL tree is : ");
        tree.printPreorderTraversal(tree.root);
        System.out.println("\nInorder traversal of constructed AVL Tree is: ");
        tree.printInorderTraversal(tree.root);
    }
}
