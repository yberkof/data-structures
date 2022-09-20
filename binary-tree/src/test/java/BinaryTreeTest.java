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
        BinaryTree tree2 = new BinaryTree();
        tree2.add(12);
        tree2.add(5);
        tree2.add(9);
        tree2.add(3);
        tree2.add(4);
        tree2.add(10);
        tree2.add(8);
        tree2.add(6);
        tree2.add(1);
        tree2.add(7);
        tree2.add(15);
        tree2.add(11);
        tree2.add(20);
        tree2.add(16);
        tree2.add(18);
        tree2.add(17);
        tree2.add(13);
        tree2.add(2);
        tree2.add(14);

        tree2.print();
        tree2.delete(15);
        System.out.println();
        tree2.print();
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
        tree.add(10);

        assertNotNull(tree.search(6));
        assertNotNull(tree.search(10));
    }


    @Test
    public void size(){
        BinaryTree tree = new BinaryTree();
        tree.add(9);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(10);
        tree.add(10);
        tree.delete(11);

        tree.print();

        assertEquals(8,tree.size());
    }

    @Test
    public void catalan(){
        BinaryTree tree = new BinaryTree();
        tree.add(9);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(10);
        tree.add(10);
        tree.delete(11);

        assertEquals(1430,tree.catalan());

    }
}
