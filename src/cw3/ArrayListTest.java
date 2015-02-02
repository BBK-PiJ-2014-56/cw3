package cw3;

/**
 * @author James Thornton
 */

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.Test;


public class ArrayListTest {

    ArrayList A1;
    @Before
    public void setUp(){
        A1 = new ArrayList();
    }
    @Test
    public void isEmptyTest() {
        assertEquals(true, A1.isEmpty());
        A1.add(3);
        assertEquals(false, A1.isEmpty());
        A1.remove(0);
        assertEquals(true, A1.isEmpty());
    }
    @Test
    public void EqualsTest() {
        assertEquals(true, A1.isEmpty());
    }

    @Test
    public void sizeTest() {
        assertEquals(0, A1.size());
        A1.add(3);
        assertEquals(1, A1.size());
        A1.add(3);
        assertEquals(2, A1.size());
        A1.remove(0);
        assertEquals(1, A1.size());
    }
    @Test
    public void getTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, A1.get(0).getError());
        A1.add("poopie");
        A1.add("poos");
        assertEquals("poopie", A1.get(0).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.get(-1).getError());
    }
    @Test
    public void AddTest() {
        //testing basic add at end of array
        A1.add(3);
        A1.add("stinky");
        A1.add("poopie");
        A1.add("poos");
        assertEquals(3, A1.get(0).getReturnValue());
        assertEquals("stinky", A1.get(1).getReturnValue());
        assertEquals("poopie", A1.get(2).getReturnValue());
        assertEquals("poos", A1.get(3).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.get(4).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.get(-1).getError());
        assertEquals(ErrorMessage.INVALID_ARGUMENT, A1.add(null).getError());
        //testing adding a number into an index of the array
        A1.add(1,4);
        assertEquals(3, A1.get(0).getReturnValue());
        assertEquals(4, A1.get(1).getReturnValue());
        assertEquals("stinky", A1.get(2).getReturnValue());
        assertEquals("poopie", A1.get(3).getReturnValue());
        assertEquals("poos", A1.get(4).getReturnValue());
		/*tests out of bounds conditions note that you can insert an object into position 5 of an
		array of 4 elements as that will then be the same as adding an object to the end of the
		array*/
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.add(6,"index too big").getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.add(-1,"index too small").getError());
        //testing adding a number into the beginning of the array
        A1.add(0,"start");
        assertEquals("start", A1.get(0).getReturnValue());
        assertEquals(3, A1.get(1).getReturnValue());
        assertEquals(4, A1.get(2).getReturnValue());
        assertEquals("stinky", A1.get(3).getReturnValue());
        assertEquals("poopie", A1.get(4).getReturnValue());
        assertEquals("poos", A1.get(5).getReturnValue());
        //testing adding a number into the end of the array
        A1.add(6,"end");
        assertEquals("start", A1.get(0).getReturnValue());
        assertEquals(3, A1.get(1).getReturnValue());
        assertEquals(4, A1.get(2).getReturnValue());
        assertEquals("stinky", A1.get(3).getReturnValue());
        assertEquals("poopie", A1.get(4).getReturnValue());
        assertEquals("poos", A1.get(5).getReturnValue());
        assertEquals("end", A1.get(6).getReturnValue());
    }
    @Test
    public void removeTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, A1.remove(0).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.remove(1).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.remove(-1).getError());
        A1.add("stinky");
        A1.add("poopie");
        A1.add("poos");
        assertEquals("stinky", A1.get(0).getReturnValue());
        assertEquals("poopie", A1.get(1).getReturnValue());
        assertEquals("poos", A1.get(2).getReturnValue());
        //Test remove from middle
        A1.remove(1);
        assertEquals("stinky", A1.get(0).getReturnValue());
        assertEquals("poos", A1.get(1).getReturnValue());
        assertEquals(2, A1.size());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, A1.get(-1).getError());
        //Tests remove from end
        A1.remove(1);
        assertEquals("stinky", A1.get(0).getReturnValue());
        assertEquals(1, A1.size());
        //Tests removing last element
        A1.remove(0);
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, A1.get(0).getError());
        assertEquals(0, A1.size());
    }
    @Test
    public void extendArrayTest() {
        assertEquals(0, A1.size());
        A1.extendArray();
        assertEquals(1, A1.size());
        A1.extendArray();
        assertEquals(2, A1.size());
    }
}

