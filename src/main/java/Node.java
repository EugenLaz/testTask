final public class Node {
    private int key;
    private long value;

    public Node(int key, long value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public Integer getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }

}
