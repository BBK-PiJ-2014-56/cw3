package cw3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author James Thornton
 */

public class SampleableListTest {
    

    /**
     * Created by jimjohn_thornton on 31/01/15.
     */

    SampleableList SFLL1;

    @Before
    public void setUp(){
        SFLL1 = new SampleableListImpl();
    }

    @Test
    public void isEmptyTest() {
        assertEquals(true, SFLL1.isEmpty());
        SFLL1.add(3);
        assertEquals(false, SFLL1.isEmpty());
        //System.out.println(SFLL1.size());
        SFLL1.remove(0);
        //System.out.println(SFLL1.size());
        assertEquals(true, SFLL1.isEmpty());
    }

    @Test
    public void EqualsTest() {
        assertEquals(true, SFLL1.isEmpty());
    }

    @Test
    public void sizeTest() {
        //System.out.println(SFLL1.size());
        assertEquals(0, SFLL1.size());
        SFLL1.add(3);
        //System.out.println(SFLL1.size());
        assertEquals(1, SFLL1.size());
        SFLL1.add(3);
        //System.out.println(SFLL1.size());
        assertEquals(2, SFLL1.size());
        SFLL1.remove(0);
        //System.out.println(SFLL1.size());
        assertEquals(1, SFLL1.size());
    }

    @Test
    public void getTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFLL1.get(0).getError());
        SFLL1.add("poopie");
        SFLL1.add("poos");
        assertEquals("poopie", SFLL1.get(0).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.get(-1).getError());
    }

    @Test
    public void AddTest() {
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.add(0,"index too big").getError());

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
        //System.out.println(SFLL1.size());
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
    }

    @Test
    public void removeTest() {
        //System.out.println(SFLL1.isEmpty());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFLL1.remove(0).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.remove(1).getError());
        //assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.remove(-1).getError());
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
    }
    /*@Test
    public void headTest() {
        //testing head method when list is empty and has more than 1 object in it
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFLL1.head().getError());
        SFLL1.add(3);
        assertEquals(3, SFLL1.head().getReturnValue());
        SFLL1.add("stinky");
        assertEquals(3, SFLL1.head().getReturnValue());
        SFLL1.add("poopie");
        assertEquals(3, SFLL1.head().getReturnValue());
        SFLL1.add("poos");
        assertEquals(3, SFLL1.head().getReturnValue());
    }
    @Test
    public void restTest() {
        //testing rest method when list is empty and has more than 1 object in it
        //assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFLL1.rest().getError());
        SFLL1.add(3);
        //System.out.println(SFLL1.head().getReturnValue());//.get(0).getReturnValue());
        assertEquals(null, SFLL1.rest().get(0).getReturnValue());
        SFLL1.add("stinky");
        //System.out.println(SFLL1.get(1).getReturnValue());
        //assertEquals("stinky", SFLL1.rest().get(0).getReturnValue());
        SFLL1.add("poopie");
        //System.out.println(SFLL1.get(2).getReturnValue());
        //assertEquals("stinky", SFLL1.rest().get(0).getReturnValue());
        //assertEquals("poopie", SFLL1.rest().get(1).getReturnValue());
        SFLL1.add("poos");
        //System.out.println(SFLL1.get(3).getReturnValue());
        //System.out.println(SFLL1.rest().get(0).getReturnValue());//.get(0).getReturnValue());
        //System.out.println(SFLL1.rest().get(1).getReturnValue());
        //System.out.println(SFLL1.rest().get(2).getReturnValue());
        assertEquals("stinky", SFLL1.rest().get(0).getReturnValue());
        assertEquals("poopie", SFLL1.rest().get(1).getReturnValue());
        assertEquals("poos", SFLL1.rest().get(2).getReturnValue());
        assertEquals(null, SFLL1.rest().get(4).getReturnValue());
    }*/
    @Test
    public void sampleTest() {
        //testing sample method when list is empty and has more than 1 object in it
        //assertEquals(ErrorMessage.EMPTY_STRUCTURE, SFLL1.head().getError());
        SFLL1.add(3);
        //assertEquals("stinky", SFLL1.sample().get(0).getReturnValue());
        SFLL1.add("stinky");
        //assertEquals("stinky", SFLL1.rest().get(0).getReturnValue());
        SFLL1.add("poopie");
        //assertEquals("stinky", SFLL1.rest().get(0).getReturnValue());
        SFLL1.add("poos");
        //assertEquals("stinky", SFLL1.rest().get(0).getReturnValue());

        assertEquals(3, SFLL1.sample().get(0).getReturnValue());
        assertEquals("poopie", SFLL1.sample().get(1).getReturnValue());
        assertEquals(null, SFLL1.sample().get(2).getReturnValue());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, SFLL1.sample().get(2).getError());
/*
        System.out.println(SFLL1.sample().get(0).getReturnValue());
        System.out.println(SFLL1.sample().get(2).getError());
        System.out.println(SFLL1.sample().get(2).getError());
        System.out.println(SFLL1.sample().get(3).getError());
        System.out.println(SFLL1.sample().get(4).getError());
*/
    }

}
