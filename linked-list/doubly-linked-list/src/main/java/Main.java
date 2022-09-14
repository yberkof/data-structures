public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add(1);
        integerDoublyLinkedList.add(7);
        integerDoublyLinkedList.add(13);
        integerDoublyLinkedList.add(5);
        integerDoublyLinkedList.add(4);
        integerDoublyLinkedList.add(3);
        integerDoublyLinkedList.add(9);
        integerDoublyLinkedList.add(2);
        integerDoublyLinkedList.add(8);
        integerDoublyLinkedList.add(10);
        integerDoublyLinkedList.add(11);
        integerDoublyLinkedList.add(6);
        integerDoublyLinkedList.add(12);
        integerDoublyLinkedList.quickSort(Integer::compare);
        for (int i = 0; i < 13; i++) {
            System.out.println(integerDoublyLinkedList.pop());
        }
    }
}
