package cw3;

/**
 * @author James Thornton
 */

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class LinkedListTest {
    LinkedList LL1;

    @Before
    public void setUp(){
        LL1 = new LinkedList();
    }

    @Test
    public void isEmptyTest() {
        assertEquals(true, LL1.isEmpty());
        LL1.add(3);
        assertEquals(false, LL1.isEmpty());
        LL1.remove(0);
        assertEquals(true, LL1.isEmpty());
    }

    @Test
    public void EqualsTest() {
        assertEquals(true, LL1.isEmpty());
    }

    @Test
    public void sizeTest() {
        assertEquals(0, LL1.size());
        LL1.add(3);
        assertEquals(1, LL1.size());
        LL1.add(3);
        assertEquals(2, LL1.size());
        LL1.remove(0);
        assertEquals(1, LL1.size());
    }

    @Test
    public void getTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, LL1.get(0).getError());
        LL1.add("some things");
        LL1.add("other things");
        assertEquals("some things", LL1.get(0).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(-1).getError());
    }

    @Test
    public void AddTest() {

        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.add(1,"index too big").getError());
        //testing basic add at end of array
        LL1.add(3);
        LL1.add("someStuff");
        LL1.add("some things");
        LL1.add("other things");

        assertEquals(3, LL1.get(0).getReturnValue());
        assertEquals("someStuff", LL1.get(1).getReturnValue());
        assertEquals("some things", LL1.get(2).getReturnValue());
        assertEquals("other things", LL1.get(3).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(4).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(-1).getError());
        assertEquals(ErrorMessage.INVALID_ARGUMENT, LL1.add(null).getError());
        //testing adding a number into an index of the array
        LL1.add(1,4);
        assertEquals(3, LL1.get(0).getReturnValue());
        assertEquals(4, LL1.get(1).getReturnValue());
        assertEquals("someStuff", LL1.get(2).getReturnValue());
        assertEquals("some things", LL1.get(3).getReturnValue());
        assertEquals("other things", LL1.get(4).getReturnValue());
		/*tests out of bounds conditions note that you can insert an object into position 5 of an
		array of 4 elements as that will then be the same as adding an object to the end of the
		array*/
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.add(6,"index too big").getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.add(-1,"index too small").getError());
        //testing adding a number into the beginning of the array
        LL1.add(0,"start");
        assertEquals("start", LL1.get(0).getReturnValue());
        assertEquals(3, LL1.get(1).getReturnValue());
        assertEquals(4, LL1.get(2).getReturnValue());
        assertEquals("someStuff", LL1.get(3).getReturnValue());
        assertEquals("some things", LL1.get(4).getReturnValue());
        assertEquals("other things", LL1.get(5).getReturnValue());
        //testing adding a number into the end of the array
        LL1.add(6,"end");
        assertEquals("start", LL1.get(0).getReturnValue());
        assertEquals(3, LL1.get(1).getReturnValue());
        assertEquals(4, LL1.get(2).getReturnValue());
        assertEquals("someStuff", LL1.get(3).getReturnValue());
        assertEquals("some things", LL1.get(4).getReturnValue());
        assertEquals("other things", LL1.get(5).getReturnValue());
        assertEquals("end", LL1.get(6).getReturnValue());
    }

    @Test
    public void removeTest() {

        assertEquals(ErrorMessage.EMPTY_STRUCTURE, LL1.remove(0).getError());
        System.out.println(LL1.size());
        LL1.add("someStuff");
        LL1.add("some things");
        LL1.add("other things");
        assertEquals("someStuff", LL1.get(0).getReturnValue());
        assertEquals("some things", LL1.get(1).getReturnValue());
        assertEquals("other things", LL1.get(2).getReturnValue());
        //Test remove from middle
        LL1.remove(1);
        assertEquals("someStuff", LL1.get(0).getReturnValue());
        assertEquals("other things", LL1.get(1).getReturnValue());
        assertEquals(2, LL1.size());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(-1).getError());
        //Tests remove from end
        LL1.remove(1);
        assertEquals("someStuff", LL1.get(0).getReturnValue());
        assertEquals(1, LL1.size());
        //Tests removing last element
        LL1.remove(0);
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, LL1.get(0).getError());
        assertEquals(0, LL1.size());
    }
}


