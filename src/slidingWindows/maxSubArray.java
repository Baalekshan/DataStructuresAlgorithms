package slidingWindows;

import java.util.Arrays;

public class maxSubArray {

    public static int[] getMaxSubarray(int[] inputArr, int subarraySize) {
        // Validate input
        if (subarraySize <= 0) {
            throw new IllegalArgumentException("Subarray size must be positive.");
        }

        int currentSum = 0;
        int maxSum = 0;
        int maxSumStartIndex = 0;

        // Iterate entire array from left to right
        for (int index = 0; index < inputArr.length; index++) {
            // Increase the window size by one from the right
            currentSum += inputArr[index];

            if (index < subarraySize) {
                // Continue to accumulate until we reach the desired subarray size (= max window size)
                maxSum = currentSum;
            } else {
                // We are over the max window size so remove one element from the left
                currentSum -= inputArr[index - subarraySize];

                if (currentSum > maxSum) {
                    // We have a new maximum sum window so record its starting index
                    maxSum = currentSum;
                    maxSumStartIndex = index - subarraySize + 1;
                }
            }
        }

        return Arrays.copyOfRange(inputArr, maxSumStartIndex, maxSumStartIndex + subarraySize);
    }

    public static void main(String[] args) {
        int[] inputArr = {2,3,4,5,2};
        int subarraySize = 2;
        int[] result = getMaxSubarray(inputArr, subarraySize);

        System.out.println("Max subarray: " + Arrays.toString(result));
    }
}
