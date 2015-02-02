package cw3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author James Thornton
 */

public class FunctionalArrayListTest {
    FunctionalArrayList FA1;
    @Before
    public void setUp(){
        FA1 = new FunctionalArrayList();
    }
    @Test
    public void isEmptyTest() {
        assertEquals(true, FA1.isEmpty());
        FA1.add(3);
        assertEquals(false, FA1.isEmpty());
        FA1.remove(0);
        assertEquals(true, FA1.isEmpty());
    }
    @Test
    public void EqualsTest() {
        assertEquals(true, FA1.isEmpty());
    }

    @Test
    public void sizeTest() {
        assertEquals(0, FA1.size());
        FA1.add(3);
        assertEquals(1, FA1.size());
        FA1.add(3);
        assertEquals(2, FA1.size());
        FA1.remove(0);
        assertEquals(1, FA1.size());
    }
    @Test
    public void getTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, FA1.get(0).getError());
        FA1.add("poopie");
        FA1.add("poos");
        assertEquals("poopie", FA1.get(0).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.get(-1).getError());
    }
    @Test
    public void AddTest() {
        //testing basic add at end of array
        FA1.add(3);
        FA1.add("stinky");
        FA1.add("poopie");
        FA1.add("poos");
        assertEquals(3, FA1.get(0).getReturnValue());
        assertEquals("stinky", FA1.get(1).getReturnValue());
        assertEquals("poopie", FA1.get(2).getReturnValue());
        assertEquals("poos", FA1.get(3).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.get(4).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.get(-1).getError());
        assertEquals(ErrorMessage.INVALID_ARGUMENT, FA1.add(null).getError());
        //testing adding a number into an index of the array
        FA1.add(1,4);
        assertEquals(3, FA1.get(0).getReturnValue());
        assertEquals(4, FA1.get(1).getReturnValue());
        assertEquals("stinky", FA1.get(2).getReturnValue());
        assertEquals("poopie", FA1.get(3).getReturnValue());
        assertEquals("poos", FA1.get(4).getReturnValue());
    /*tests out of bounds conditions note that you can insert an object into position 5 of an
    array of 4 elements as that will then be the same as adding an object to the end of the
    array*/
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.add(6,"index too big").getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.add(-1,"index too small").getError());
        //testing adding a number into the beginning of the array
        FA1.add(0,"start");
        assertEquals("start", FA1.get(0).getReturnValue());
        assertEquals(3, FA1.get(1).getReturnValue());
        assertEquals(4, FA1.get(2).getReturnValue());
        assertEquals("stinky", FA1.get(3).getReturnValue());
        assertEquals("poopie", FA1.get(4).getReturnValue());
        assertEquals("poos", FA1.get(5).getReturnValue());
        //testing adding a number into the end of the array
        FA1.add(6,"end");
        assertEquals("start", FA1.get(0).getReturnValue());
        assertEquals(3, FA1.get(1).getReturnValue());
        assertEquals(4, FA1.get(2).getReturnValue());
        assertEquals("stinky", FA1.get(3).getReturnValue());
        assertEquals("poopie", FA1.get(4).getReturnValue());
        assertEquals("poos", FA1.get(5).getReturnValue());
        assertEquals("end", FA1.get(6).getReturnValue());
    }
    @Test
    public void removeTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, FA1.remove(0).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.remove(1).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.remove(-1).getError());
        FA1.add("stinky");
        FA1.add("poopie");
        FA1.add("poos");
        assertEquals("stinky", FA1.get(0).getReturnValue());
        assertEquals("poopie", FA1.get(1).getReturnValue());
        assertEquals("poos", FA1.get(2).getReturnValue());
        //Test remove from middle
        FA1.remove(1);
        assertEquals("stinky", FA1.get(0).getReturnValue());
        assertEquals("poos", FA1.get(1).getReturnValue());
        assertEquals(2, FA1.size());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FA1.get(-1).getError());
        //Tests remove from end
        FA1.remove(1);
        assertEquals("stinky", FA1.get(0).getReturnValue());
        assertEquals(1, FA1.size());
        //Tests removing last element
        FA1.remove(0);
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, FA1.get(0).getError());
        assertEquals(0, FA1.size());
    }
    @Test
    public void extendArrayTest() {
        assertEquals(0, FA1.size());
        FA1.extendArray();
        assertEquals(1, FA1.size());
        FA1.extendArray();
        assertEquals(2, FA1.size());
    }
    @Test
    public void head() {
        //testing head method when list is empty and has more than 1 object in it
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, FA1.head().getError());
        FA1.add(3);
        assertEquals(3, FA1.head().getReturnValue());
        FA1.add("stinky");
        assertEquals(3, FA1.head().getReturnValue());
        FA1.add("poopie");
        assertEquals(3, FA1.head().getReturnValue());
        FA1.add("poos");
        assertEquals(3, FA1.head().getReturnValue());
    }
    @Test
    public void rest() {
        //testing rest method when list is empty and has more than 1 object in it
        //assertEquals(ErrorMessage.EMPTY_STRUCTURE, FA1.rest().getError());
        FA1.add(3);
        assertEquals(null, FA1.rest().get(0).getReturnValue());
        FA1.add("stinky");
        assertEquals("stinky", FA1.rest().get(0).getReturnValue());
        FA1.add("poopie");
        assertEquals("stinky", FA1.rest().get(0).getReturnValue());
        assertEquals("poopie", FA1.rest().get(1).getReturnValue());
        FA1.add("poos");
        assertEquals("stinky", FA1.rest().get(0).getReturnValue());
        assertEquals("poopie", FA1.rest().get(1).getReturnValue());
        assertEquals("poos", FA1.rest().get(2).getReturnValue());
        assertEquals(null, FA1.rest().get(4).getReturnValue());
    }
}
