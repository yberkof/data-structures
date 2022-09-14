public class Node<E> {
    private E data;

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    private Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
}
