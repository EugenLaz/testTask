import java.util.ArrayList;
import java.util.List;

public class CustomHashTable {
    Node[] nodesList;
    private int currentSize;
    private int capacity;

    public CustomHashTable(int capacity) {
        this.capacity=capacity;
        nodesList = new Node[capacity];
        currentSize=0;
    }

    public int getSize() {
        return currentSize;
    }

    private int hash(int key)
    {
        return key % capacity;
    }

    public boolean put(Integer key,Long value) {
        int i = hash(key);
        int tempor = i;
        int quadratic = 1;
        do
        {
            if (nodesList[tempor] == null)
            {
                nodesList[tempor] = new Node(key,value);
                currentSize++;
                return true;
            }
            else if (nodesList[tempor].getKey()==key) {
                nodesList[tempor].setValue(value);
                return true;
            }
            tempor = (tempor + quadratic * quadratic++) % capacity;
        } while (tempor!=i);
        throw new RuntimeException("TableOverflow");
    }

    public Long get(Integer key){
        int i = hash(key), h = 1;
        while (nodesList[i].getKey() != null)
        {
            if (nodesList[i].getKey()==key)
                return nodesList[i].getValue();
            i = (i + h * h++) % capacity;
        }
        return null;
    }

    public void print(){
        for (int i =0;i<capacity;i++){
            try {
                System.out.println(nodesList[i].toString());
            }catch (NullPointerException e){
                System.out.println("null");
            }
        }
    }

}
