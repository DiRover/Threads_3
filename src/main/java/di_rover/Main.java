package di_rover;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int[] arrBig = GenerateArray.calculate(39001100);
        final int[] arrSmall = GenerateArray.calculate(100000);

        final CalculateArraySumWithRecursionByArrayIndexes calculateArraySumWithRecursionByArrayIndexesBig = new CalculateArraySumWithRecursionByArrayIndexes(arrBig, 0 , arrBig.length);
        final CalculateArraySumWithRecursionByArrayIndexes calculateArraySumWithRecursionByArrayIndexesSmall = new CalculateArraySumWithRecursionByArrayIndexes(arrSmall, 0 , arrSmall.length);

        //Recursion by array indexes
        try (ForkJoinPool forkJoinPoolBig = new ForkJoinPool(Runtime.getRuntime().availableProcessors())) {
            //Execute Big Array.
            /*
            * Important!!! If you invoke multi-treads for calculate array twice, time for second run will be ZERO (0)!!
            * I think multi-treads cached results
            * */
            long startTimeMultiBig = System.currentTimeMillis();
            long sumMultiBig = forkJoinPoolBig.invoke(calculateArraySumWithRecursionByArrayIndexesBig);
            long endTimeMultiBig = System.currentTimeMillis();
            System.out.println("Многопоточная сумма большого массива: " + sumMultiBig);
            System.out.println("Время многопоточного выполнения большого массива: " + (endTimeMultiBig - startTimeMultiBig) + " мс");

            final long startTimeSingle = System.currentTimeMillis();
            final long sumSingle = CalculateArraySum.getArraySum(arrBig);
            final long endTimeSingle = System.currentTimeMillis();
            System.out.println("Однопоточная сумма большого массива: " + sumSingle);
            System.out.println("Время однопоточного выполнения большого массива: " + (endTimeSingle - startTimeSingle) + " мс");
        }

        try (ForkJoinPool forkJoinPoolSmall = new ForkJoinPool(Runtime.getRuntime().availableProcessors())) {
            //Execute Small Array
            long startTimeMultiSmall = System.currentTimeMillis();
            long sumMultiSmall = forkJoinPoolSmall.invoke(calculateArraySumWithRecursionByArrayIndexesSmall);
            long endTimeMultiSmall = System.currentTimeMillis();
            System.out.println("Многопоточная сумма малого массива: " + sumMultiSmall);
            System.out.println("Время многопоточного выполнения малого массива: " + (endTimeMultiSmall - startTimeMultiSmall) + " мс");

            final long startTimeSingleSmall = System.currentTimeMillis();
            final long sumSingleSmall = CalculateArraySum.getArraySum(arrSmall);
            final long endTimeSingleSmall = System.currentTimeMillis();
            System.out.println("Однопоточная сумма малого массива: " + sumSingleSmall);
            System.out.println("Время однопоточного выполнения малого массива: " + (endTimeSingleSmall - startTimeSingleSmall) + " мс");
        }

        final CalculateArraySumWithRecursion calculateArraySumWithRecursionBig = new CalculateArraySumWithRecursion(arrBig);
        final CalculateArraySumWithRecursion calculateArraySumWithRecursionSmall = new CalculateArraySumWithRecursion(arrSmall);

        //Recursion by only arrays
        try (ForkJoinPool forkJoinPoolBigOnlyArrays = new ForkJoinPool(Runtime.getRuntime().availableProcessors())) {
            //Execute Big Array.
            /*
             * Important!!! If you invoke multi-treads for calculate array twice, time for second run will be ZERO (0)!!
             * I think multi-treads cached results
             * */
            long startTimeMultiBig = System.currentTimeMillis();
            long sumMultiBig = forkJoinPoolBigOnlyArrays.invoke(calculateArraySumWithRecursionBig);
            long endTimeMultiBig = System.currentTimeMillis();
            System.out.println("Многопоточная сумма большого массива: " + sumMultiBig);
            System.out.println("Время многопоточного выполнения большого массива: " + (endTimeMultiBig - startTimeMultiBig) + " мс");

            final long startTimeSingle = System.currentTimeMillis();
            final long sumSingle = CalculateArraySum.getArraySum(arrBig);
            final long endTimeSingle = System.currentTimeMillis();
            System.out.println("Однопоточная сумма большого массива: " + sumSingle);
            System.out.println("Время однопоточного выполнения большого массива: " + (endTimeSingle - startTimeSingle) + " мс");
        }

        try (ForkJoinPool forkJoinPoolSmallOnlyArrays = new ForkJoinPool(Runtime.getRuntime().availableProcessors())) {
            //Execute Small Array
            long startTimeMultiSmall = System.currentTimeMillis();
            long sumMultiSmall = forkJoinPoolSmallOnlyArrays.invoke(calculateArraySumWithRecursionSmall);
            long endTimeMultiSmall = System.currentTimeMillis();
            System.out.println("Многопоточная сумма малого массива: " + sumMultiSmall);
            System.out.println("Время многопоточного выполнения малого массива: " + (endTimeMultiSmall - startTimeMultiSmall) + " мс");

            final long startTimeSingleSmall = System.currentTimeMillis();
            final long sumSingleSmall = CalculateArraySum.getArraySum(arrSmall);
            final long endTimeSingleSmall = System.currentTimeMillis();
            System.out.println("Однопоточная сумма малого массива: " + sumSingleSmall);
            System.out.println("Время однопоточного выполнения малого массива: " + (endTimeSingleSmall - startTimeSingleSmall) + " мс");
        }
    }
}