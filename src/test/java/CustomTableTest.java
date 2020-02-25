import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;

public class CustomTableTest{

    static CustomHashTable table;
    @Before
    public void beforeTests(){
        table = new CustomHashTable(4);
        table.put(1,(long)1);
    }

    @Test
    public void rewriteTest() {
        table.put(1,(long)5);
        Assert.assertEquals((long)table.get(1),5);
    }
    @Test
    public void getTest(){
        Assert.assertEquals((long)table.get(1),1);
    }
    @Test(expected = RuntimeException.class)
    public void fullTableTest() throws Exception {
        table.put(2,(long)1);
        table.put(3,(long)2);
        table.put(6,(long)4);
        table.put(7,(long)3);
    }
    @Test
    public void sizeTest(){
        Assert.assertEquals(table.getSize(),1);
    }
}
