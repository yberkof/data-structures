import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int num = 900000000;
        int[] arr = new int[num];
        num--;
        for (int i = 0; i < arr.length; i++) {
            num = (--num) < 1 ? 1 : num;
            arr[i] = num;
        }

        long startTime = System.nanoTime();

        System.out.println(minJumps(new int[]{1, 4, 3, 2, 6, 7}));
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000000000.0);
    }



//
    static int minJumps(int[] arr) {
        if (arr.length == 1)
            return 0;
        ArrayList<Pair> map = new ArrayList<>();
        boolean enough = false;
        for (int i = 0; i < arr.length && !enough; i++) {
            enough = i + arr[i] > arr.length - 1;
            map.add(new Pair(i , Math.min(i + arr[i], arr.length - 1)));
        }

        return getLastInd(map, arr.length - 1, map.size());
    }

    private static int getLastInd(ArrayList<Pair> values, int look, int end) {
        int lastInd = -1;
        for (int i = 0; i < end ; i++) {
            Pair integers = values.get(i);
            if (integers.start < (look) && integers.end>=look) {
                lastInd = i;
                break;
            }
        }
        if (lastInd == 0)
            return 1;

        if (lastInd == -1)
            return -1;

        int res = getLastInd(values, lastInd, lastInd );

        if (res == -1)
            return -1;

        return 1 + res;
    }

    private static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


}
