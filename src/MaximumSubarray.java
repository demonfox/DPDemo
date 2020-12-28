public class MaximumSubarray {
    // the more classic way of solving this is Kadane's Algorithm
    public int kadaneAlgorithm(int[] array) {
        int currSum = array[0];
        int currMax = array[0];
        for (int i=1; i<array.length; i++) {
            currSum = (array[i] > (array[i] + currSum)) ? array[i] : array[i] + currSum;
            currMax = (currSum > currMax) ? currSum : currMax;
        }
        return currMax;
    }

    public int dp(int[] array) {
        // define MS[i] as the maximum sum ending with element array[i]
        int[] MS = new int[array.length];
        MS[0] = array[0];
        for (int i=1; i<array.length; i++) {
            MS[i] = Math.max(MS[i-1] + array[i], array[i]);
        }
        int max = MS[0];
        for (int i=1; i<array.length; i++) {
            if (MS[i] > max)
                max = MS[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int array1[] = { 1, 2, -3, -4, 2, 7, -2, 3 };
        MaximumSubarray m = new MaximumSubarray();
        System.out.println("Maximum subarray is (Kadane's Algorithm): " + m.kadaneAlgorithm(array1));
        System.out.println("Maximum subarray is (DP): " + m.dp(array1));
        int array2[] = { -2, -3, -4, -2, -7, -2, -3,-11 };
        System.out.println("Maximum subarray is (Kadane's Algorithm): " + m.kadaneAlgorithm(array2));
        System.out.println("Maximum subarray is (DP): " + m.dp(array2));
    }
}