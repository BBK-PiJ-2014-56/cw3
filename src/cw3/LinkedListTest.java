package cw3;

/**
 * Created by jimjohn_thornton on 24/01/15.
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
        //LL1.remove(0);
        //assertEquals(true, LL1.isEmpty());
    }

    @Test
    public void EqualsTest() {
        assertEquals(true, LL1.isEmpty());
    }

    @Test
    public void sizeTest() {
        System.out.println(LL1.size());
        assertEquals(0, LL1.size());
        LL1.add(3);
        System.out.println(LL1.size());
        assertEquals(1, LL1.size());
        LL1.add(3);
        System.out.println(LL1.size());
        assertEquals(2, LL1.size());
        LL1.remove(0);
        System.out.println(LL1.size());
        assertEquals(1, LL1.size());
    }

    @Test
    public void getTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, LL1.get(0).getError());
        LL1.add("poopie");
        LL1.add("poos");
        assertEquals("poopie", LL1.get(0).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(-1).getError());
    }

    @Test
    public void AddTest() {
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.add(0,"index too big").getError());

        //testing basic add at end of array
        LL1.add(3);
        LL1.add("stinky");
        LL1.add("poopie");
        LL1.add("poos");

        assertEquals(3, LL1.get(0).getReturnValue());
        assertEquals("stinky", LL1.get(1).getReturnValue());
        assertEquals("poopie", LL1.get(2).getReturnValue());
        assertEquals("poos", LL1.get(3).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(4).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(-1).getError());
        assertEquals(ErrorMessage.INVALID_ARGUMENT, LL1.add(null).getError());
        //testing adding a number into an index of the array
        LL1.add(1,4);
        assertEquals(3, LL1.get(0).getReturnValue());
        assertEquals(4, LL1.get(1).getReturnValue());
        assertEquals("stinky", LL1.get(2).getReturnValue());
        assertEquals("poopie", LL1.get(3).getReturnValue());
        assertEquals("poos", LL1.get(4).getReturnValue());
		/*tests out of bounds conditions note that you can insert an object into position 5 of an
		array of 4 elements as that will then be the same as adding an object to the end of the
		array*/
        System.out.println(LL1.size());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.add(6,"index too big").getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.add(-1,"index too small").getError());
        //testing adding a number into the beginning of the array
        LL1.add(0,"start");
        System.out.println(LL1.size());
        assertEquals("start", LL1.get(0).getReturnValue());
        assertEquals(3, LL1.get(1).getReturnValue());
        assertEquals(4, LL1.get(2).getReturnValue());
        assertEquals("stinky", LL1.get(3).getReturnValue());
        assertEquals("poopie", LL1.get(4).getReturnValue());
        assertEquals("poos", LL1.get(5).getReturnValue());
        //testing adding a number into the end of the array
        LL1.add(6,"end");
        assertEquals("start", LL1.get(0).getReturnValue());
        assertEquals(3, LL1.get(1).getReturnValue());
        assertEquals(4, LL1.get(2).getReturnValue());
        assertEquals("stinky", LL1.get(3).getReturnValue());
        assertEquals("poopie", LL1.get(4).getReturnValue());
        assertEquals("poos", LL1.get(5).getReturnValue());
        assertEquals("end", LL1.get(6).getReturnValue());
    }

    @Test
    public void removeTest() {
        System.out.println(LL1.isEmpty());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, LL1.remove(0).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.remove(1).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.remove(-1).getError());
        LL1.add("stinky");
        LL1.add("poopie");
        LL1.add("poos");
        assertEquals("stinky", LL1.get(0).getReturnValue());
        assertEquals("poopie", LL1.get(1).getReturnValue());
        assertEquals("poos", LL1.get(2).getReturnValue());
        //Test remove from middle
        LL1.remove(1);
        assertEquals("stinky", LL1.get(0).getReturnValue());
        assertEquals("poos", LL1.get(1).getReturnValue());
        assertEquals(2, LL1.size());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, LL1.get(-1).getError());
        //Tests remove from end
        LL1.remove(1);
        assertEquals("stinky", LL1.get(0).getReturnValue());
        assertEquals(1, LL1.size());
        //Tests removing last element
        LL1.remove(0);
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, LL1.get(0).getError());
        assertEquals(0, LL1.size());
    }

    /*@Test
    public void extendArrayTest() {
        assertEquals(0, LL1.size());
        LL1.extendArray();
        assertEquals(1, LL1.size());
        LL1.extendArray();
        assertEquals(2, LL1.size());
    }*/

}


