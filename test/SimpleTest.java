import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleTest {

    @Test
    public void nextInSequenceTest() {
        Integer[] seq = new Integer[]{4, 9, 12};
        int depth = 0;
        Simple s = new Simple("text", 3, true, seq, depth);
        Integer[] result = new Integer[]{4, 9, 12, 0, 0, 0, 0};
        for (int i = 0; i < result.length; i++)
            assertEquals(result[i], s.nextInSequence());


        seq = new Integer[]{7};
        depth = 1;
        s = new Simple("text", 3, true, seq, depth);
        result = new Integer[]{7, 7, 7, 7, 7, 7};
        for (int i = 0; i < result.length; i++)
            assertEquals(result[i], s.nextInSequence());


        seq = new Integer[]{3, 8};
        depth = 1;
        s = new Simple("text", 3, true, seq, depth);
        result = new Integer[]{3, 8, 8, 8, 8, 8, 8};
        for (int i = 0; i < result.length; i++)
            assertEquals(result[i], s.nextInSequence());


        seq = new Integer[]{2, 4};
        depth = 2;
        s = new Simple("text", 3, true, seq, depth);
        result = new Integer[]{2, 4, 6, 10, 16, 26, 42, 68};
        for (int i = 0; i < result.length; i++)
            assertEquals(result[i], s.nextInSequence());


        seq = new Integer[]{2, 4, 6, 8};
        depth = 3;
        s = new Simple("text", 3, true, seq, depth);
        result = new Integer[]{2, 4, 6, 8, 18, 32, 58, 108};
        for (int i = 0; i < result.length; i++)
            assertEquals(result[i], s.nextInSequence());
    }

    @Test
    public void truthTest() {
        Simple s = new Simple("text here", 1, false, new Integer[]{1}, 1);
        assertEquals(s.truth(), false);
    }

    @Test
    public void numberTest() {
        Simple s = new Simple("text here", 1, false, new Integer[]{1}, 1);
        assertEquals(s.number(), 1);
    }

    @Test
    public void textTest() {
        Simple s = new Simple("text here", 1, false, new Integer[]{1}, 1);
        assertTrue(s.text().equals("text here"));
    }

    @Test
    public void flipTest() {
        Simple s = new Simple("", 1, false, new Integer[]{1}, 1);
        assertEquals(s.truth(), false);
        s.flip();
        assertEquals(s.truth(), true);
    }

    @Test
    public void toStringTest() {
        Simple s = new Simple("text here", 1, false, new Integer[]{1}, 1);
        assertTrue(s.toString().equals("Simple[false, 1, \"text here\"]"));
    }
}