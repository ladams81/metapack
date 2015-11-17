package acummulator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AcummulatorImplTest {

    private Accumulator accumulator;

    @Before
    public void setup() {
        accumulator = new AccumulatorImpl();
    }

    @Test
    public void testAccumulate() {
        int result = accumulator.accumulate(1, 2, 3);
        assertEquals(6, result);

        assertEquals(12, accumulator.accumulate(2, 4, 6));
    }

    @Test
    public void testAccumulate_NothingYetAccumulated() {
        int result = accumulator.accumulate();
        assertEquals(0, result);
    }

    @Test
    public void getTotal_ZeroAccumulated() {
        accumulator.accumulate();
        assertEquals(0, accumulator.getTotal());
    }

    @Test
    public void getTotal_SumA_OneValueInArray() {
        int result = accumulator.accumulate(5);

        int total = accumulator.getTotal();
        assertEquals(result, total);
    }

    @Test
    public void getTotal_SumA() {
        int result = accumulator.accumulate(5, 2, 3);

        int total = accumulator.getTotal();
        assertEquals(result, total);
    }

    @Test
    public void getTotal_SumAPlusSumB() {
        accumulator.accumulate(5, 2, 3);
        accumulator.accumulate(1, 2, 10);

        int total = accumulator.getTotal();
        assertEquals(23, total);
    }

    @Test
    public void getTotal_SumAPlusSumB_Negative() {
        accumulator.accumulate(-1, -1, -1);
        accumulator.accumulate(-2, -2, -2);

        int total = accumulator.getTotal();
        assertEquals(-9, total);
    }

    @Test
    public void reset() {
        accumulator.accumulate(5, 2, 3);
        assertTrue(accumulator.getTotal() != 0);

        accumulator.reset();
        assertEquals(0, accumulator.getTotal());
    }

}
