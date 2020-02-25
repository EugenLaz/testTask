import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class CustomTableTest{
     IntToLongHashTable table;
     @Before
     public void initializeTable(){
         table = new IntToLongHashTable();
     }
    @Test
    public void shouldReturnZeroWhenGetSizeOnEmptyMap(){
        Assert.assertEquals(table.getSize(),0);
    }
    @Test
    public void shouldReturnValueOnNonEmptyMap(){
        table.put(1,3l);
        table.put(3,4l);
        Assert.assertEquals(table.getSize(),2);
    }
    @Test
    public void shouldNotChangeSizeWhenValueOverwriteByExistingKey(){
        table.put(2,4l);
        int before =table.getSize();
        table.put(2,44l);
        Assert.assertEquals(before,table.getSize());
    }

    @Test
    public void shouldReturnValueByKey(){
         table.put(1,44l);
         Assert.assertEquals(table.get(1),44);
    }
    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementExceptionOnNonExistingKey(){
         table.get(14);
    }
    @Test
    public void shouldReturnValuesFromElemetsWithIdenticalHashesAndDifferentKeys(){
         //Hash is calculated by key % tableCapacity rule, both elements have hash value of 2
         table.put(2,1l);
         table.put(9,2l);
         Assert.assertEquals(table.get(9),2l);
         Assert.assertEquals(table.get(2),1l);

    }
    @Test
    public void shouldReturnValueAfterRewriting(){
         table.put(1,14l);
         table.put(1,22l);
         Assert.assertEquals(table.get(1),22l);
    }

    @Test
    public void shouldPutNewValueOnNonExistingKey(){
         table.put(1,1l);
    }
    @Test
    public void test(){
         //initial capacity of table is 7 for testing purpose
        table.put(1,1l);
        table.put(2,2l);
        table.put(3,3l);
        table.put(4,4l);
        table.put(5,5l);
        table.put(6,6l);
        table.put(7,7l);
        table.put(8,8l);

    }


}
