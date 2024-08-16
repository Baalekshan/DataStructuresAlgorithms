package slidingWindows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subArraySum7 {
    public static ArrayList<int[]> getMaxSubarray(int[] inputArr, int sumSize) {
        int currentSum = 0;
        int startIndex = 0;
        ArrayList<int[]> solutions = new ArrayList<>();

        // Iterate entire array from left to right
        for (int index = 0; index < inputArr.length; index++) {
            // Increase the window size by one from the right
            currentSum += inputArr[index];

            // Adjust the start index while the current sum is greater than sumSize
            while (currentSum > sumSize && startIndex <= index) {
                currentSum -= inputArr[startIndex];
                startIndex++;
            }

            // If we have found a subarray with the desired sum, add it to solutions
            if (currentSum == sumSize) {
                solutions.add(Arrays.copyOfRange(inputArr, startIndex, index + 1));
            }
        }
        return solutions;
    }

    public static void main (String[]args){
        int[] inputArr = {2, 3, 4, 5, 2};
        int subarraySize = 7;
        ArrayList<int[]> result = getMaxSubarray(inputArr, subarraySize);
        System.out.println("Max subarrays with sum " + subarraySize + ":");
        for (int[] subarray : result) {
            System.out.println(Arrays.toString(subarray));
        }
    }
}

