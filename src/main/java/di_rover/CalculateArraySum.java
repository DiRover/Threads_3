package di_rover;

public class CalculateArraySum {

    public static long getArraySum(int[] array) {
        long sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
}
