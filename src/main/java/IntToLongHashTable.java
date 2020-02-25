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

    //Inserting new element. The index is counted with Quadratic probing method
    public void put(Integer key, Long value) {
        int startingElement = hash(key);
        int currentPosition = startingElement;
        int quadraticFactor = 1;
        do {
            if (nodeArray[currentPosition] == null) {
                nodeArray[currentPosition] = new Node(key, value);
                currentSize++;
                return;
            } else if (nodeArray[currentPosition].getKey() == key) {
                nodeArray[currentPosition] = new Node(key, value);
                return;
            }
            currentPosition = (currentPosition + quadraticFactor * quadraticFactor++) % capacity;
        } while (currentPosition != startingElement);
        //if cycled the current map and could not find empty slot->
        // Double the size of current map and rewrite current elements considering new Hash
        resize();
        put(key, value);
    }

    public long get(int key) {
        int i = hash(key), quadraticFactor = 1;
        while (nodeArray[i] != null) {
            if (nodeArray[i].getKey() == key)
                return nodeArray[i].getValue();
            //If expected slot does not contain element with given key Try next slot considering QuadraticFactor
            i = (i + quadraticFactor * quadraticFactor++) % capacity;
        }
        throw new NoSuchElementException();
    }

    private void resize() {
        int oldCapacity = capacity;
        Node[] oldNodeArray = nodeArray;
        capacity *= 2;
        currentSize = 0;
        nodeArray = new Node[capacity];
        for (int i = 0; i < oldCapacity; i++) {
            if (oldNodeArray[i] != null)
                put(oldNodeArray[i].getKey(), oldNodeArray[i].getValue());
        }
    }

}
