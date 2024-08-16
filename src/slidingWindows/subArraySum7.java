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
                // Print the subarray or perform any processing you need
                System.out.print("Subarray with sum " + sumSize + ": ");
                for (int i = startIndex; i <= index; i++) {
                    System.out.print(inputArr[i] + " ");
                }
                System.out.println();
            }
        }
        return solutions;
    }

    public static void main (String[]args){
        int[] inputArr = {2, 3, 4, 5, 2};
        int subarraySize = 7;
        getMaxSubarray(inputArr, subarraySize);
    }
}

