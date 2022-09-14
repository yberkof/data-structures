import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<E> {
    private transient Node<E> head;
    private transient Node<E> tail;
    private transient int size;

    public DoublyLinkedList() {
        initialize();
    }

    private void initialize() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void linkFirst(E e) {
        if (head == null) {
            head = new Node<>(e, null, null);
            tail = head;
            size++;
            return;
        }
        head.prev = new Node<>(e, head, null);
        head = head.prev;
        size++;
    }

    void linkLast(E e) {
        if (tail == null) {
            linkFirst(e);
            return;
        }
        tail.next = new Node<>(e, null, tail);
        tail = tail.next;
        size++;
    }

    void linkBefore(E e, Node<E> succ) {
        Node<E> prev = succ.prev;
        if (prev == null) {
            linkFirst(e);
            return;
        }
        prev.next = new Node<>(e, succ, prev);
        succ.prev = prev.next;
        size++;
    }

    void linkAfter(E e, Node<E> pre) {
        Node<E> next = pre.next;
        if (next == null) {
            linkLast(e);
            return;
        }
        next.prev = new Node<>(e, next, pre);
        pre.next = next.prev;
        size++;
    }

    private E unlinkFirst(Node<E> f) {
        if (f != head || f == null) throw new IllegalArgumentException("");
        if (size == 1) {
            initialize();
            return f.data;
        }
        Node<E> next = f.next;
        next.prev = null;
        head = next;
        f.next = null;
        size--;
        return f.data;
    }

    private E unlinkLast(Node<E> l) {
        if (l != tail || l == null) throw new IllegalArgumentException("");
        if (size == 1) {
            initialize();
            return l.data;
        }
        Node<E> prev = l.prev;
        prev.next = null;
        tail = prev;
        l.prev = null;
        size--;
        return l.data;

    }

    E unlink(Node<E> x) {
        Node<E> prev = x.prev;
        Node<E> next = x.next;
        if (prev == null) {
            unlinkFirst(x);
            return x.data;
        }
        if (next == null) {
            unlinkLast(x);
            return x.data;
        }
        prev.next = x.next;
        next.prev = x.prev;
        x.prev = null;
        x.next = null;
        size--;
        return x.data;
    }

    public E getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }

    public E getLast() {
        if (tail == null) throw new NoSuchElementException();
        return tail.data;
    }

    public E removeFirst() {
        if (head == null) throw new NoSuchElementException();
        return unlinkFirst(head);
    }

    public E removeLast() {
        if (tail == null) throw new NoSuchElementException();
        return unlinkLast(tail);
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
    }


    public boolean contains(Object o) {
        if (!(o instanceof Node)) return false;
        Node<E> node = (Node<E>) o;
        return findByValue(node.data) != null;
    }

    public int size() {
        return size;
    }

    public boolean add(E e) {
        if (e == null) throw new NullPointerException();
        linkLast(e);
        return true;
    }

    public boolean remove(Object o) {
        Node<E> ref = head;
        while (ref != null) {
            if (Objects.equals(o, ref.data)) {
                unlink(ref);
                return true;
            }
            ref = ref.next;
        }
        return false;

    }

    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);
        Node<E> ref = head;
        if (index == size) {
            for (E e : c) {
                linkLast(e);
            }
            return true;
        }
        ref = node(index);
        for (E e : c) {
            linkBefore(e, ref);
        }
        return true;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size) linkLast(element);
        else linkBefore(element, node(index));
    }

    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private Node<E> node(int index) {
        Node<E> ref = head;
        while (index > 0) {
            ref = ref.next;
            index--;
        }
        return ref;
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.data;
        x.data = element;
        return oldVal;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    public void clear() {
        initialize();
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) throw new IndexOutOfBoundsException(index);
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) throw new IndexOutOfBoundsException(index);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return 0 <= index && index <= size;
    }

    public int indexOf(E o) {
        Node<E> ref = head;
        int index = 0;
        while (ref != null) {
            if (Objects.equals(o, ref.data)) return index;
            index++;
            ref = ref.next;
        }
        return -1;

    }

    public int lastIndexOf(E o) {
        Node<E> ref = tail;
        int index = size - 1;
        while (ref != null) {
            if (Objects.equals(o, ref.data)) return index;
            index--;
            ref = ref.prev;
        }
        return index;
    }

    public E peek() {
        final Node<E> f = head;
        return (f == null) ? null : f.data;
    }

    public E element() {
        return getFirst();
    }

    public E poll() {
        final Node<E> f = head;
        return (f == null) ? null : unlinkFirst(f);
    }

    public E remove() {
        return removeFirst();
    }

    public boolean offer(E e) {
        return add(e);
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E peekFirst() {
        final Node<E> f = head;
        return (f == null) ? null : f.data;
    }

    public E peekLast() {
        final Node<E> l = tail;
        return (l == null) ? null : l.data;
    }

    public E pollFirst() {
        final Node<E> f = head;
        return (f == null) ? null : unlinkFirst(f);
    }

    public E pollLast() {
        final Node<E> l = tail;
        return (l == null) ? null : unlinkLast(l);
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }


    public boolean removeFirstOccurrence(E o) {
        return remove(o);
    }

    public boolean removeLastOccurrence(E o) {
        Node<E> ref = tail;
        while (ref != null) {
            if (Objects.equals(o, ref.data)) {
                unlink(ref);
                return true;
            }

        }
        return false;
    }

    Node<E> findByValue(E e) {
        if (head == null) throw new NoSuchElementException("Empty list");
        Node<E> temp = head;
        while (temp != null) {
            if (Objects.equals(temp.data, e)) return temp;
            temp = temp.next;
        }
        throw new NoSuchElementException(e.toString());
    }

    void reverse() {
        reverse(0, size - 1);
    }

    void reverse(int start, int end) {
        if (start > end)
            throw new IllegalArgumentException();
        Node<E> startNode = node(start);
        Node<E> endNode = node(end);
        while (startNode != endNode && endNode.next != startNode) {
            swap(startNode, endNode);
            startNode = startNode.next;
            endNode = endNode.prev;
        }


    }

    private void swap(Node<E> startNode, Node<E> endNode) {
        E temp = startNode.data;
        startNode.data = endNode.data;
        endNode.data = temp;
    }

    public void quickSort(Comparator<E> comparator) {
        quickSort(head, tail, comparator);

    }

    private void quickSort(Node<E> head, Node<E> tail, Comparator<E> comparator) {
        if (tail != null && tail.next != head) {
            Node<E> pivot = tail;
            Node<E> ref = head;
            Node<E> current = pivot;
            Node<E> endNode = tail;
            while (ref != endNode) {
                Node<E> next = ref.next;
                assert (ref.data != null);
                if (comparator.compare(ref.data, pivot.data) >= 0) {
                    if (ref == head)
                        head = head.next;
                    unlink(ref);
                    linkAfter(ref.data, current);
                    current = current.next;
                    tail = current;
                }
                ref = next;
            }
            quickSort(head, pivot.prev, comparator);
            quickSort(pivot.next, tail, comparator);

        }
    }

//    private void partition(Node<E> head, Node<E> tail, Node<E> pivot, Comparator<E> comparator) {
//        System.out.print("( Pivot: " + pivot.data + " ");
//        Node<E> ref = head;
//        Node<E> current = pivot;
//        Node<E> endNode = tail;
//        while (ref != endNode) {
//            System.out.print("," + ref.data);
//            Node<E> next = ref.next;
//            assert (ref.data != null);
//            if (comparator.compare(ref.data, pivot.data) >= 0) {
//                unlink(ref);
//                linkAfter(ref.data, current);
//                current = current.next;
//                System.out.print(" Flipped");
//            }
//            ref = next;
//        }
//        System.out.print(")");
//        System.out.println();
//    }

    void print(Node<E> head, Node<E> tail) {
        System.out.print("(");
        while (head != null && head.prev != tail) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.print(")");
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }

}
