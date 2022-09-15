import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class DoublyLinkedListUtilsTest {

    @Test
    void add() {
        String s1 = "1234";
        String s2 = "4567";
        DoublyLinkedListUtils first = new DoublyLinkedListUtils();
        DoublyLinkedListUtils second = new DoublyLinkedListUtils();
        first.add(s1, "", Integer::parseInt);
        second.add(s2, "", Integer::parseInt);

    }

    @Test
    void sum() {
        String s1 = generateNumberString(75);
        String s2 = generateNumberString(62);
        DoublyLinkedListUtils first = new DoublyLinkedListUtils();
        DoublyLinkedListUtils second = new DoublyLinkedListUtils();
        first.add(s1, "", Integer::parseInt);
        second.add(s2, "", Integer::parseInt);
        String sum = first.sum(second);
        System.out.println(sum);
        BigDecimal bigDecimal = new BigDecimal(s1);
        BigDecimal bigDecimal2 = new BigDecimal(s2);
        System.out.println(bigDecimal.add(bigDecimal2));
        Assertions.assertEquals(bigDecimal.add(bigDecimal2), new BigDecimal(sum));
    }

    public static String generateNumberString(int n) {
        String AlphaNumericString = "1234567890";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }


    @Test
    void rotate() {
        String s1 = "123456789";
        DoublyLinkedListUtils first = new DoublyLinkedListUtils();
        first.add(s1, "", Integer::parseInt);

        first.rotate(10);

        first.print();
    }
}
