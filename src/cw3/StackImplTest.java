package cw3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author James Thornton
 */

public class StackImplTest {
    StackImpl SA;
    StackImpl SL;
    List AL = new ArrayList();
    List LL = new LinkedList();

    @Before
    public void setUp() {
        SA = new StackImpl(AL);
        SL = new StackImpl(LL);
    }

    @Test
    public void isEmptyTest() {
        assertEquals(true, SA.isEmpty());
        SA.push(3);
        assertEquals(false, SA.isEmpty());
        SA.pop();
        assertEquals(true, SA.isEmpty());
        assertEquals(true, SL.isEmpty());
        SL.push(3);
        assertEquals(false, SL.isEmpty());
        SL.pop();
        assertEquals(true, SL.isEmpty());
    }
    @Test
    public void sizeTest() {
        assertEquals(0, SA.size());
        SA.push(3);
        assertEquals(1, SA.size());
        SA.push("A");
        assertEquals(2, SA.size());
        SA.push(5);
        assertEquals(3, SA.size());
        assertEquals(0, SL.size());
        SL.push(3);
        assertEquals(1, SL.size());
        SL.push("A");
        assertEquals(2, SL.size());
        SL.push(5);
        assertEquals(3, SL.size());
    }

    @Test
    public void pushTest() {

        SA.push(3);
        assertEquals(3, SA.get(0).getReturnValue());
        SA.push("a");
        assertEquals("a", SA.get(0).getReturnValue());
        SA.push(5);
        assertEquals(5, SA.get(0).getReturnValue());
        SL.push(3);
        assertEquals(3, SL.get(0).getReturnValue());
        SL.push("a");
        assertEquals("a", SL.get(0).getReturnValue());
        SL.push(5);
        assertEquals(5, SL.get(0).getReturnValue());

    }

    @Test
    public void topTest() {
        SA.push(3);
        assertEquals(3, SA.top().getReturnValue());
        SA.push("a");
        assertEquals("a", SA.top().getReturnValue());
        SA.push(5);
        assertEquals(5, SA.top().getReturnValue());
        SL.push(3);
        assertEquals(3, SL.top().getReturnValue());
        SL.push("a");
        assertEquals("a", SL.top().getReturnValue());
        SL.push(5);
        assertEquals(5, SL.top().getReturnValue());
    }

    @Test
    public void popTest() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SA.pop().getError());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SL.pop().getError());
        SA.push(3);
        SA.push("a");
        SA.push(5);
        assertEquals(5, SA.top().getReturnValue());
        assertEquals(5, SA.pop().getReturnValue());
        assertEquals("a", SA.top().getReturnValue());
        assertEquals("a", SA.pop().getReturnValue());
        assertEquals(3, SA.top().getReturnValue());
        assertEquals(3, SA.pop().getReturnValue());
        assertEquals(null, SA.top().getReturnValue());
        SL.push(3);
        SL.push("a");
        SL.push(5);
        assertEquals(5, SL.top().getReturnValue());
        assertEquals(5, SL.pop().getReturnValue());
        assertEquals("a", SL.top().getReturnValue());
        assertEquals("a", SL.pop().getReturnValue());
        assertEquals(3, SL.top().getReturnValue());
        assertEquals(3, SL.pop().getReturnValue());
        assertEquals(null, SL.top().getReturnValue());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SA.pop().getError());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, SL.pop().getError());
    }
}