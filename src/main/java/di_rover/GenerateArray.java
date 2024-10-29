package di_rover;

import java.util.Random;

public class GenerateArray {
    private static final Random random = new Random();
    private static final int min = 2;
    private static final int max = 10;

    public static int[] calculate(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
}
