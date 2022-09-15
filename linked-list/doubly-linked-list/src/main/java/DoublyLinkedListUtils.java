import java.util.function.Function;

public class DoublyLinkedListUtils extends DoublyLinkedList<Integer> {
    public boolean add(String text, String splitter, Function<String, Integer> parser) {
        String[] strings = text.split(splitter);
        for (String string : strings) {
            addLast(parser.apply(string));
        }
        return true;
    }

    public String sum(DoublyLinkedListUtils second) {
        StringBuilder result = new StringBuilder();
        Node<Integer> refFirst = this.getTail();
        Node<Integer> refSecond = second.getTail();
        Integer rem = 0;

        while (refFirst != null || refSecond != null) {
            int firstAdd = refFirst != null ? refFirst.getData() : 0;
            int secondAdd = refSecond != null ? refSecond.getData() : 0;
            int add = secondAdd + firstAdd + rem;
            rem = 0;
            if (add > 9) {
                rem = 1;
                add -= 10;
            }
            result.insert(0, add);
            refFirst = refFirst != null ? refFirst.getPrev() : null;
            refSecond = refSecond != null ? refSecond.getPrev() : null;
        }

        if (rem != 0) {
            result.insert(0, rem);
        }
        return result.toString();
    }


    public void rotate(int d) {
        rotate(0, this.size() - 1, d);
    }

    public void rotate(int start, int end, int d) {
        d = d % this.size();
//        reverse(start, end - d);
//        reverse(end - d + 1, end);
//        reverse();

        this.getHead().setPrev(this.getTail());
        this.getTail().setNext(this.getHead());

        for (int i = 0; i < d; i++) {
            this.head = head.getPrev();
            this.tail = tail.getPrev();
        }
        this.getHead().setPrev(null);
        this.getTail().setNext(null);

    }




}
