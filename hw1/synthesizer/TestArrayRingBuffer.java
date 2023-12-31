package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);

        assertEquals(4, arb.fillCount());
        assertEquals(1, arb.dequeue());

        arb.enqueue(5);
        arb.enqueue(6);
        assertEquals(5, arb.fillCount());

        arb.enqueue(7);
        arb.enqueue(8);
        arb.enqueue(9);
        arb.enqueue(10);
        arb.enqueue(11);
        assertEquals(10, arb.fillCount());

        for (int i = 0; i < 10; i++) {
            arb.dequeue();
        }

        assertEquals(0, arb.fillCount());

//        arb.enqueue(13);
//        arb.enqueue(14);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
