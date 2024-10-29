package di_rover;

import java.util.concurrent.RecursiveTask;

public class CalculateArraySumWithRecursionByArrayIndexes extends RecursiveTask<Integer> {
    private final int[] array;
    private final int start;
    private final int end;

    public CalculateArraySumWithRecursionByArrayIndexes(int[] arr, int start, int end) {
        this.array = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (start - end <= 2) {
            int sum = 0;

            for (int i = start; i < end ; i++) {
                sum += array[i];
            }
            return sum;
        }

        int mid = start + (end - start) /2;

        CalculateArraySumWithRecursionByArrayIndexes firstPart = new CalculateArraySumWithRecursionByArrayIndexes(array, start, mid);
        CalculateArraySumWithRecursionByArrayIndexes secondPart = new CalculateArraySumWithRecursionByArrayIndexes(array, mid, end);

        firstPart.fork();
        secondPart.fork();

        return firstPart.join() + secondPart.join();
    }
}
