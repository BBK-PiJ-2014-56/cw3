package cw3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jimjohn_thornton on 31/01/15.
 */
public class FunctionalLinkedListTest {
    FunctionalLinkedList FLL1;

    @Before
    public void setUp(){
        FLL1 = new FunctionalLinkedList();
    }

    @Test
    public void isEmptyTest() {
        assertEquals(true, FLL1.isEmpty());
        FLL1.add(3);
        assertEquals(false, FLL1.isEmpty());
        System.out.println(FLL1.size());
        FLL1.remove(0);
        System.out.println(FLL1.size());
        assertEquals(true, FLL1.isEmpty());
    }

    @Test
    public void EqualsTest() {
        assertEquals(true, FLL1.isEmpty());
    }

    @Test
    public void sizeTest() {
        //System.out.println(FLL1.size());
        assertEquals(0, FLL1.size());
        FLL1.add(3);
        //System.out.println(FLL1.size());
        assertEquals(1, FLL1.size());
        FLL1.add(3);
        //System.out.println(FLL1.size());
        assertEquals(2, FLL1.size());
        FLL1.remove(0);
        //System.out.println(FLL1.size());
        assertEquals(1, FLL1.size());
    }

    @Test
    public void getTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, FLL1.get(0).getError());
        FLL1.add("poopie");
        FLL1.add("poos");
        assertEquals("poopie", FLL1.get(0).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.get(-1).getError());
    }

    @Test
    public void AddTest() {
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.add(0,"index too big").getError());

        //testing basic add at end of array
        FLL1.add(3);
        FLL1.add("stinky");
        FLL1.add("poopie");
        FLL1.add("poos");

        assertEquals(3, FLL1.get(0).getReturnValue());
        assertEquals("stinky", FLL1.get(1).getReturnValue());
        assertEquals("poopie", FLL1.get(2).getReturnValue());
        assertEquals("poos", FLL1.get(3).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.get(4).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.get(-1).getError());
        assertEquals(ErrorMessage.INVALID_ARGUMENT, FLL1.add(null).getError());
        //testing adding a number into an index of the array
        FLL1.add(1,4);
        assertEquals(3, FLL1.get(0).getReturnValue());
        assertEquals(4, FLL1.get(1).getReturnValue());
        assertEquals("stinky", FLL1.get(2).getReturnValue());
        assertEquals("poopie", FLL1.get(3).getReturnValue());
        assertEquals("poos", FLL1.get(4).getReturnValue());
		/*tests out of bounds conditions note that you can insert an object into position 5 of an
		array of 4 elements as that will then be the same as adding an object to the end of the
		array*/
        //System.out.println(FLL1.size());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.add(6,"index too big").getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.add(-1,"index too small").getError());
        //testing adding a number into the beginning of the array
        FLL1.add(0,"start");
        //System.out.println(FLL1.size());
        assertEquals("start", FLL1.get(0).getReturnValue());
        assertEquals(3, FLL1.get(1).getReturnValue());
        assertEquals(4, FLL1.get(2).getReturnValue());
        assertEquals("stinky", FLL1.get(3).getReturnValue());
        assertEquals("poopie", FLL1.get(4).getReturnValue());
        assertEquals("poos", FLL1.get(5).getReturnValue());
        //testing adding a number into the end of the array
        FLL1.add(6,"end");
        assertEquals("start", FLL1.get(0).getReturnValue());
        assertEquals(3, FLL1.get(1).getReturnValue());
        assertEquals(4, FLL1.get(2).getReturnValue());
        assertEquals("stinky", FLL1.get(3).getReturnValue());
        assertEquals("poopie", FLL1.get(4).getReturnValue());
        assertEquals("poos", FLL1.get(5).getReturnValue());
        assertEquals("end", FLL1.get(6).getReturnValue());
    }

    @Test
    public void removeTest() {
        //System.out.println(FLL1.isEmpty());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, FLL1.remove(0).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.remove(1).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.remove(-1).getError());
        FLL1.add("stinky");
        FLL1.add("poopie");
        FLL1.add("poos");
        assertEquals("stinky", FLL1.get(0).getReturnValue());
        assertEquals("poopie", FLL1.get(1).getReturnValue());
        assertEquals("poos", FLL1.get(2).getReturnValue());
        //Test remove from middle
        FLL1.remove(1);
        assertEquals("stinky", FLL1.get(0).getReturnValue());
        assertEquals("poos", FLL1.get(1).getReturnValue());
        assertEquals(2, FLL1.size());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, FLL1.get(-1).getError());
        //Tests remove from end
        FLL1.remove(1);
        assertEquals("stinky", FLL1.get(0).getReturnValue());
        assertEquals(1, FLL1.size());
        //Tests removing last element
        FLL1.remove(0);
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, FLL1.get(0).getError());
        assertEquals(0, FLL1.size());
    }
    @Test
    public void headTest() {
        //testing head method when list is empty and has more than 1 object in it
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, FLL1.head().getError());
        FLL1.add(3);
        assertEquals(3, FLL1.head().getReturnValue());
        FLL1.add("stinky");
        assertEquals(3, FLL1.head().getReturnValue());
        FLL1.add("poopie");
        assertEquals(3, FLL1.head().getReturnValue());
        FLL1.add("poos");
        assertEquals(3, FLL1.head().getReturnValue());
    }
    @Test
    public void restTest() {
        //testing rest method when list is empty and has more than 1 object in it
        //assertEquals(ErrorMessage.EMPTY_STRUCTURE, FLL1.rest().getError());
        FLL1.add(3);
        assertEquals(null, FLL1.rest().get(0).getReturnValue());
        FLL1.add("stinky");
        assertEquals("stinky", FLL1.rest().get(0).getReturnValue());
        FLL1.add("poopie");
        assertEquals("stinky", FLL1.rest().get(0).getReturnValue());
        assertEquals("poopie", FLL1.rest().get(1).getReturnValue());
        FLL1.add("poos");
        assertEquals("stinky", FLL1.rest().get(0).getReturnValue());
        assertEquals("poopie", FLL1.rest().get(1).getReturnValue());
        assertEquals("poos", FLL1.rest().get(2).getReturnValue());
        assertEquals(null, FLL1.rest().get(4).getReturnValue());
    }
}
