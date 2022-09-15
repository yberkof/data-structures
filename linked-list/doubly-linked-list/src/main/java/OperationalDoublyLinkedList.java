import java.util.function.Function;

public class OperationalDoublyLinkedList extends DoublyLinkedList<Integer> {
    public boolean add(String text, String splitter, Function<String, Integer> parser) {
        String[] strings = text.split(splitter);
        for (String string : strings) {
            addLast(parser.apply(string));
        }
        return true;
    }

    public String sum(OperationalDoublyLinkedList second) {
        String result = "";
        Node<Integer> refFirst = this.getTail();
        Node<Integer> refSecond = second.getTail();
        int rem = 0;
        while (refFirst != null && refSecond != null) {
            int add = refSecond.getData() + refFirst.getData() + rem;
            if (add > 9) {
                rem = 1;
                add -= 10;
            } else {
                rem = 0;
            }
            result = add + result;
            refFirst = refFirst.getPrev();
            refSecond = refSecond.getPrev();
        }
        if (this.size() != second.size()) {
            Node<Integer> remNode = this.size() > second.size() ? refFirst : refSecond;
            while (remNode != null) {
                int add = remNode.getData() + rem;
                if (add > 9) {
                    rem = 1;
                    add -= 10;
                } else {
                    rem = 0;
                }
                result = add + result;
                remNode = remNode.getPrev();
            }
        }
        if (rem != 0) {
            result = rem + result;
        }
        return result;
    }

}
