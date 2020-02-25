import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class IntToLongHashTable {
    private Node[] nodeArray;
    private int currentSize;
    private int capacity;

    public IntToLongHashTable() {
        capacity = 7;
        nodeArray = new Node[capacity];
        currentSize = 0;
    }

    public int getSize() {
        return currentSize;
    }

    private int hash(int key) {
        return key % capacity;
    }


    public void put(Integer key, Long value) {
        int i = hash(key);
        int tempor = i;
        int quadratic = 1;
        do {
            if (nodeArray[tempor] == null) {
                nodeArray[tempor] = new Node(key, value);
                currentSize++;
                return;
            } else if (nodeArray[tempor].getKey() == key) {
                nodeArray[tempor] = new Node(key, value);
                return;
            }
            tempor = (tempor + quadratic * quadratic++) % capacity;
        } while (tempor != i);
        resize();
        put(key,value);
    }

    public long get(int key) {
        int i = hash(key), h = 1;
        while (nodeArray[i] != null) {
            if (nodeArray[i].getKey() == key)
                return nodeArray[i].getValue();
            i = (i + h * h++) % capacity;
        }
        throw new NoSuchElementException();
    }

    protected void resize(){
        int oldCapacity = capacity;
        Node[] oldNodeArray = nodeArray;
        capacity*=2;
        currentSize=0;
        nodeArray = new Node[capacity];
        for(int i =0;i<oldCapacity;i++){
            if (oldNodeArray[i]!=null)
            put(oldNodeArray[i].getKey(),oldNodeArray[i].getValue());
        }
    }

}
