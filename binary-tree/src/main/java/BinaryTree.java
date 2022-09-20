import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    protected Node root;
    protected int size;

    private static Node newNode(Integer value) {
        return new Node(value, null, null);
    }

    public void add(Integer value) {
        root = add(value, root);
        size++;
//        Node ref = root;
//        if (root == null) {
//            root = newNode(value);
//            return;
//        }
//        while (true) {
//            Node child;
//            if (ref.data < value) {
//                if (ref.right == null) {
//                    ref.right = newNode(value);
//                    break;
//                } else ref = ref.right;
//            } else if (ref.data > value) {
//                child = ref.left;
//                if (child == null) {
//                    ref.left = newNode(value);
//                    break;
//                } else ref = ref.left;
//            } else break;
//        }
    }


    public Node add(Integer value, Node root) {

        if (root == null) {
            return newNode(value);
        }


        if (root.data < value)
            root.right = add(value, root.right);
        else if (root.data > value)
            root.left = add(value, root.left);
        else {
            size--;
            return root;
        }

        return root;
    }

    public Node search(int value) {
        return search(root, value);
    }

    private Node search(Node node, int value) {
        if (node == null) return null;
        if (node.data == value) return node;

        if (node.data > value) return search(node.left, value);
        else return search(node.right, value);
    }

    public void delete(int key) {
        root = delete(root, key);
        size--;
    }

    private Node delete(Node root, int value) {
        if (root == null) {
            size++;
            return null;
        }

        if (value < root.data)
            root.left = delete(root.left, value);
        else if (value > root.data)
            root.right = delete(root.right, value);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            int minValue = minValue(root.right);
            root.data = minValue;

            root.right = delete(root.right, minValue);
        }

        return root;
    }

    int minValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }


    public int size() {
        return size;
    }

    public void print() {
        System.out.print("");
        preOrderPrint(root, "RO ");
//        System.out.print("[ ");
//        inOrderPrint(root);
//        System.out.println("]");
//        System.out.print("[ ");
//        postOrderPrint(root);
//        System.out.println("]");
    }

    private void preOrderPrint(Node node, String s) {
        if (node == null) return;
        System.out.print(s + node.data);
        System.out.println();
        preOrderPrint(node.left, s + "L" + " ");
        preOrderPrint(node.right, s + "R" + " ");
    }

    private void inOrderPrint(Node node) {
        if (node == null) return;
        inOrderPrint(node.left);
        System.out.print(node.data + " ");
        inOrderPrint(node.right);
    }

    private void postOrderPrint(Node node) {
        if (node == null) return;
        inOrderPrint(node.left);
        inOrderPrint(node.right);
        System.out.print(node.data + " ");
    }

    public int catalan() {
        int[] catalans = new int[size + 2];
        catalans[0] = catalans[1] = 1;

        for (int i = 2; i <= size; i++) {
            catalans[i] =0;
            for (int j = 0; j < i; j++) {
                catalans[i] += catalans[j] * catalans[i-j-1];
            }
        }

        return catalans[size];
    }

// ()()() ((())) ()(()) (())() (()())
//  1 2    1->2  2->1
//  1 2 3   1->2->3  1->3->2   2->3->2   3->2->1  3->1->2

    protected static class Node {
        protected Integer data;
        protected Node left;
        protected Node right;

        public Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

//  1
//    3
//      4
//   3    5
//   2

}
