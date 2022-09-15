import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    @Test
    public void add(){
        BinaryTree tree = new BinaryTree();
        tree.add(3);
        tree.add(4);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(9);
        tree.add(1);

        tree.print();
    }


    @Test
    public void delete(){
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(7);
        tree.add(8);
        tree.add(6);
        tree.add(9);
        tree.add(1);
        tree.add(10);

        tree.print();
        tree.delete(7);
        System.out.println();
        tree.print();
    }


    @Test
    public void search(){
        BinaryTree tree = new BinaryTree();
        tree.add(9);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(1);

        assertTrue(tree.search(6) != null);
        assertFalse(tree.search(10) == null);
    }
}
