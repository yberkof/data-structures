import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Integer root;
    Map<Integer, List<Integer>> nodes = new HashMap<>();

    public Graph() {
        this.root = null;
    }

    public void add(int data, List<Integer> children) {
        if (root == null)
            root = data;

        nodes.put(data,children);
    }


}
