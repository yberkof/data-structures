public class BinaryTree {
    protected Node root;

    private static Node newNode(Integer value) {
        return new Node(value, null, null);
    }

    public void add(Integer value) {
        Node ref = root;
        if (root == null) {
            root = newNode(value);
            return;
        }
        while (true) {
            Node child;
            if (ref.data < value) {
                if (ref.right == null) {
                    ref.right = newNode(value);
                    break;
                } else ref = ref.right;
            } else {
                child = ref.left;
                if (child == null) {
                    ref.left = newNode(value);
                    break;
                } else ref = ref.left;
            }
        }
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

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int value) {
        if (root == null) return root;

        if (value < root.data) root.left = deleteRec(root.left, value);
        else if (value > root.data) root.right = deleteRec(root.right, value);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            int minValue = minValue(root.right);
            root.data = minValue;

            root.right = deleteRec(root.right, minValue);
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


}
