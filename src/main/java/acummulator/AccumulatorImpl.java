package acummulator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AccumulatorImpl implements Accumulator {

    private List<Integer> results = new ArrayList<>();

    public int accumulate(int... values) {
        int ret = IntStream.of(values).boxed().mapToInt(Integer::intValue).sum();
        results.add(ret);
        return ret;
    }

    public int getTotal() {
        return results.stream().mapToInt(Integer::intValue).sum();
    }

    public void reset() {
        results.clear();
    }
}
