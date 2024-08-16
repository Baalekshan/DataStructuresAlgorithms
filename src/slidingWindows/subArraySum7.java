package slidingWindows;

import java.util.Arrays;

public class subArraySum7 {
    public static int[] getMaxSubarray(int[] inputArr, int sumSize) {
        int currentSum = 0;
        int StartIndex = 0;
        int index = 0;
        // Iterate entire array from left to right
        for (index = 0; index < inputArr.length; index++) {
            // Increase the window size by one from the right
            currentSum += inputArr[index];

            if (currentSum == sumSize) {
                return Arrays.copyOfRange(inputArr, StartIndex, index);

            } else if (currentSum > sumSize) {
                // We are over the max window size so remove one element from the left
                StartIndex++;
                currentSum -= inputArr[index - StartIndex];
            }

        }
        return Arrays.copyOfRange(inputArr, StartIndex, index);
    }
    public static void main (String[]args){
        int[] inputArr = {2, 3, 4, 5, 2};
        int subarraySize = 7;
        int[] result = getMaxSubarray(inputArr, subarraySize);

        System.out.println("Max subarray: " + Arrays.toString(result));
    }
}

