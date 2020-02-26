import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class IntToLongHashTableTest {
    private IntToLongHashTable table;

    @Before
    public void initializeTable() {
        table = new IntToLongHashTable();
    }

    @Test
    public void shouldReturnZeroWhenGetSizeOnEmptyMap() {
        Assert.assertEquals(0,table.size());
    }

    @Test
    public void shouldGetSizeOnNonEmptyMap() {
        table.put(1, 3l);
        table.put(3, 4l);
        Assert.assertEquals(2, table.size());
    }

    @Test
    public void shouldNotChangeSizeWhenValueOverwriteByExistingKey() {
        table.put(2, 4l);
        int before = table.size();
        table.put(2, 44l);
        Assert.assertEquals(before, table.size());
    }

    @Test
    public void shouldReturnValueByKey() {
        table.put(1, 44l);
        Assert.assertEquals(44l,(long)table.get(1));
    }
    @Test
    public void shouldReturnNullOnNonExistingKey() {
        Assert.assertNull(table.get(14));
    }

    @Test
    public void shouldPutElementsWithIdenticalHashesAndDifferentKeys() {
        //Hash is calculated by key % tableCapacity rule, both elements have hash value of 2
        table.put(2, 1l);
        table.put(9, 2l);
        Assert.assertEquals(2l,(long)table.get(9));
        Assert.assertEquals(1l,(long)table.get(2));

    }

    @Test
    public void shouldUpdateValueByExistingKey() {
        table.put(1, 14l);
        table.put(1, 22l);
        Assert.assertEquals(22l,(long)table.get(1));
    }

    @Test
    public void shouldResizeAndGetElement(){
        for(int i =0;i<13;i++){
            table.put(i,(long)i);
        }
        Assert.assertEquals(0,(long)table.get(0));
    }
    @Test
    public void shouldResizeAndPutNewElement() {
        for(int i =0;i<=8;i++)
            table.put(i,(long)i);
        Assert.assertEquals(8l,(long)table.get(8));
    }

    @Test
    public void shouldResizeTwiceAndUpdateExistingElements(){
        for(int i =15;i>=0;i--){
            table.put(i,(long)i);
        }
        for(int i =0;i<=15;i++){
            Assert.assertEquals(i,(long)table.get(i));
        }
    }

    @Test
    public void shouldGetSizeAfterResizing() {
        table.put(1, 1l);
        table.put(2, 2l);
        table.put(3, 3l);
        table.put(4, 4l);
        table.put(5, 5l);
        table.put(6, 6l);
        table.put(7, 7l);
        table.put(8, 8l);
        Assert.assertEquals(8,table.size());
    }

    @Test
    public void shouldPutElementOnExistingKeyAfterResizing(){
        for(int i =0;i<=8;i++){
            table.put(i,(long)i);
        }
        table.put(1,44l);
        Assert.assertEquals(44l,(long)table.get(1));
    }



}
