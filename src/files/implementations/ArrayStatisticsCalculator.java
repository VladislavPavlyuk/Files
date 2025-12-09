package files.implementations;

import files.interfaces.IArrayStatistics;
import java.util.Arrays;

public class ArrayStatisticsCalculator implements IArrayStatistics {
    @Override
    public int getMax(int[] array) {
        return Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
    }

    @Override
    public int getMin(int[] array) {
        return Arrays.stream(array).min().orElse(Integer.MAX_VALUE);
    }

    @Override
    public int getSum(int[] array) {
        return Arrays.stream(array).sum();
    }
}


