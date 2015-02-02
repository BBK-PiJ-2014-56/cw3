package cw3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests to see if both types of list work
 * @author James Thornton
 */

public class SampleableListTest {

    private SampleableList SFLL1;
    private SampleableList SFAL1;

    @Before
    public void setUp(){
        SFLL1 = new SampleableListImpl(new FunctionalLinkedList());
        SFAL1 = new SampleableListImpl(new FunctionalArrayList());
    }

    @Test
    public void isEmptyTest() {
        assertEquals(true, SFLL1.isEmpty());
        SFLL1.add(3);
        assertEquals(false, SFLL1.isEmpty());
        SFLL1.remove(0);
        assertEquals(true, SFLL1.isEmpty());
        assertEquals(true, SFAL1.isEmpty());
        SFAL1.add(3);
        assertEquals(false, SFAL1.isEmpty());
        SFAL1.remove(0);
        assertEquals(true, SFAL1.isEmpty());
    }

    @Test
    public void EqualsTest() {
        assertEquals(true, SFLL1.isEmpty());
        assertEquals(true, SFAL1.isEmpty());
    }

    @Test
    public void sizeTest() {
        assertEquals(0, SFLL1.size());
        SFLL1.add(3);
        assertEquals(1, SFLL1.size());
        SFLL1.add(3);
        assertEquals(2, SFLL1.size());
        SFLL1.remove(0);
        assertEquals(1, SFLL1.size());

        assertEquals(0, SFAL1.size());
        SFAL1.add(3);
        assertEquals(1, SFAL1.size());
        SFAL1.add(3);
        assertEquals(2, SFAL1.size());
        SFAL1.remove(0);
        assertEquals(1, SFAL1.size());
    }

    @Test
    public void getTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFLL1.get(0).getError());
        SFLL1.add("poopie");
        SFLL1.add("poos");
        assertEquals("poopie", SFLL1.get(0).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.get(-1).getError());

        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFAL1.get(0).getError());
        SFAL1.add("poopie");
        SFAL1.add("poos");
        assertEquals("poopie", SFAL1.get(0).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFAL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFAL1.get(-1).getError());
    }

    @Test
    public void AddTest() {
        //testing basic add at end of array
        SFLL1.add(3);
        SFLL1.add("stinky");
        SFLL1.add("poopie");
        SFLL1.add("poos");

        assertEquals(3, SFLL1.get(0).getReturnValue());
        assertEquals("stinky", SFLL1.get(1).getReturnValue());
        assertEquals("poopie", SFLL1.get(2).getReturnValue());
        assertEquals("poos", SFLL1.get(3).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.get(4).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.get(-1).getError());
        assertEquals(ErrorMessage.INVALID_ARGUMENT, SFLL1.add(null).getError());
        //testing adding a number into an index of the array
        SFLL1.add(1,4);
        assertEquals(3, SFLL1.get(0).getReturnValue());
        assertEquals(4, SFLL1.get(1).getReturnValue());
        assertEquals("stinky", SFLL1.get(2).getReturnValue());
        assertEquals("poopie", SFLL1.get(3).getReturnValue());
        assertEquals("poos", SFLL1.get(4).getReturnValue());
        /*tests out of bounds conditions note that you can insert an object into position 5 of an
        array of 4 elements as that will then be the same as adding an object to the end of the
        array*/
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.add(6,"index too big").getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.add(-1,"index too small").getError());
        //testing adding a number into the beginning of the array
        SFLL1.add(0,"start");
        //System.out.println(SFLL1.size());
        assertEquals("start", SFLL1.get(0).getReturnValue());
        assertEquals(3, SFLL1.get(1).getReturnValue());
        assertEquals(4, SFLL1.get(2).getReturnValue());
        assertEquals("stinky", SFLL1.get(3).getReturnValue());
        assertEquals("poopie", SFLL1.get(4).getReturnValue());
        assertEquals("poos", SFLL1.get(5).getReturnValue());
        //testing adding a number into the end of the array
        SFLL1.add(6,"end");
        assertEquals("start", SFLL1.get(0).getReturnValue());
        assertEquals(3, SFLL1.get(1).getReturnValue());
        assertEquals(4, SFLL1.get(2).getReturnValue());
        assertEquals("stinky", SFLL1.get(3).getReturnValue());
        assertEquals("poopie", SFLL1.get(4).getReturnValue());
        assertEquals("poos", SFLL1.get(5).getReturnValue());
        assertEquals("end", SFLL1.get(6).getReturnValue());

        SFAL1.add(3);
        SFAL1.add("stinky");
        SFAL1.add("poopie");
        SFAL1.add("poos");

        assertEquals(3, SFAL1.get(0).getReturnValue());
        assertEquals("stinky", SFAL1.get(1).getReturnValue());
        assertEquals("poopie", SFAL1.get(2).getReturnValue());
        assertEquals("poos", SFAL1.get(3).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFAL1.get(4).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFAL1.get(-1).getError());
        assertEquals(ErrorMessage.INVALID_ARGUMENT, SFAL1.add(null).getError());
        //testing adding a number into an index of the array
        SFAL1.add(1,4);
        assertEquals(3, SFAL1.get(0).getReturnValue());
        assertEquals(4, SFAL1.get(1).getReturnValue());
        assertEquals("stinky", SFAL1.get(2).getReturnValue());
        assertEquals("poopie", SFAL1.get(3).getReturnValue());
        assertEquals("poos", SFAL1.get(4).getReturnValue());
        /*tests out of bounds conditions note that you can insert an object into position 5 of an
        array of 4 elements as that will then be the same as adding an object to the end of the
        array*/
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFAL1.add(6,"index too big").getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFAL1.add(-1,"index too small").getError());
        //testing adding a number into the beginning of the array
        SFAL1.add(0,"start");
        //System.out.println(SFAL1.size());
        assertEquals("start", SFAL1.get(0).getReturnValue());
        assertEquals(3, SFAL1.get(1).getReturnValue());
        assertEquals(4, SFAL1.get(2).getReturnValue());
        assertEquals("stinky", SFAL1.get(3).getReturnValue());
        assertEquals("poopie", SFAL1.get(4).getReturnValue());
        assertEquals("poos", SFAL1.get(5).getReturnValue());
        //testing adding a number into the end of the array
        SFAL1.add(6,"end");
        assertEquals("start", SFAL1.get(0).getReturnValue());
        assertEquals(3, SFAL1.get(1).getReturnValue());
        assertEquals(4, SFAL1.get(2).getReturnValue());
        assertEquals("stinky", SFAL1.get(3).getReturnValue());
        assertEquals("poopie", SFAL1.get(4).getReturnValue());
        assertEquals("poos", SFAL1.get(5).getReturnValue());
        assertEquals("end", SFAL1.get(6).getReturnValue());
    }

    @Test
    public void removeTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFLL1.remove(0).getError());
        SFLL1.add("stinky");
        SFLL1.add("poopie");
        SFLL1.add("poos");
        assertEquals("stinky", SFLL1.get(0).getReturnValue());
        assertEquals("poopie", SFLL1.get(1).getReturnValue());
        assertEquals("poos", SFLL1.get(2).getReturnValue());
        //Test remove from middle
        SFLL1.remove(1);
        assertEquals("stinky", SFLL1.get(0).getReturnValue());
        assertEquals("poos", SFLL1.get(1).getReturnValue());
        assertEquals(2, SFLL1.size());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.get(-1).getError());
        //Tests remove from end
        SFLL1.remove(1);
        assertEquals("stinky", SFLL1.get(0).getReturnValue());
        assertEquals(1, SFLL1.size());
        //Tests removing last element
        SFLL1.remove(0);
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFLL1.get(0).getError());
        assertEquals(0, SFLL1.size());

        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFAL1.remove(0).getError());
        SFAL1.add("stinky");
        SFAL1.add("poopie");
        SFAL1.add("poos");
        assertEquals("stinky", SFAL1.get(0).getReturnValue());
        assertEquals("poopie", SFAL1.get(1).getReturnValue());
        assertEquals("poos", SFAL1.get(2).getReturnValue());
        //Test remove from middle
        SFAL1.remove(1);
        assertEquals("stinky", SFAL1.get(0).getReturnValue());
        assertEquals("poos", SFAL1.get(1).getReturnValue());
        assertEquals(2, SFAL1.size());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFAL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFAL1.get(-1).getError());
        //Tests remove from end
        SFAL1.remove(1);
        assertEquals("stinky", SFAL1.get(0).getReturnValue());
        assertEquals(1, SFAL1.size());
        //Tests removing last element
        SFAL1.remove(0);
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFAL1.get(0).getError());
        assertEquals(0, SFAL1.size());
    }

    @Test
    public void sampleTest() {
        //testing sample method when list is empty and has more than 1 object in it
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFLL1.sample().get(0).getError());
        SFLL1.add(3);
        SFLL1.add("stinky");
        SFLL1.add("poopie");
        SFLL1.add("poos");

        assertEquals(3, SFLL1.sample().get(0).getReturnValue());
        assertEquals("poopie", SFLL1.sample().get(1).getReturnValue());
        assertEquals(null, SFLL1.sample().get(2).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.sample().get(2).getError());


        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFAL1.sample().get(0).getError());
        SFAL1.add(3);
        SFAL1.add("stinky");
        SFAL1.add("poopie");
        SFAL1.add("poos");

        assertEquals(3, SFAL1.sample().get(0).getReturnValue());
        assertEquals("poopie", SFAL1.sample().get(1).getReturnValue());
        assertEquals(null, SFAL1.sample().get(2).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFAL1.sample().get(2).getError());
    }

}
