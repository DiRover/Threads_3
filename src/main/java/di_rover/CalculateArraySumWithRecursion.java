package di_rover;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class CalculateArraySumWithRecursion  extends RecursiveTask<Long> {
    private final int[] array;

    public CalculateArraySumWithRecursion(int[] arr) {
        this.array = arr;
    }

    @Override
    protected Long compute() {
        if (array.length <= 2) {
            return (long) Arrays.stream(array).sum();
        }

        CalculateArraySumWithRecursion firstPart = new CalculateArraySumWithRecursion(Arrays.copyOfRange(array, 0, array.length/2));
        CalculateArraySumWithRecursion secondPart = new CalculateArraySumWithRecursion(Arrays.copyOfRange(array, array.length/2, array.length));

        firstPart.fork();
        secondPart.fork();

        return firstPart.join() + secondPart.join();
    }
}
