package histogram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;


// TODO: Uncomment me when you're done implementing the class
public class SimpleHistogramTest {

    @Test
    public void testHistogram() {
        Character[] target = {'a','b','c','a'};
        Histogram<Character> h = new SimpleHistogram<>(target);
        Iterator<Character> iter = h.iterator();
        int elemCount = 0;
        while(iter.hasNext()) {
            iter.next();
            elemCount++;
        }

        assertEquals(3, elemCount);
        assertEquals(2, h.getCount('a'));
        assertEquals(1, h.getCount('b'));
        assertEquals(1, h.getCount('c'));
        assertEquals(4, h.getTotalCount());
    }
}

