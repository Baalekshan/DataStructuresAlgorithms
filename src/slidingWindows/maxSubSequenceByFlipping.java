package slidingWindows;

import java.util.Arrays;

public class maxSubSequenceByFlipping {

    public static int[] flippingZeroes(int[] inputArr, int flip) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int zeroCount = 0;
        int startIndex = 0;

        // Sliding window approach
        while (right < inputArr.length) {
            if (inputArr[right] == 0) {
                zeroCount++;
            }

            // If zeroCount exceeds the number of flips, move the left pointer
            while (zeroCount > flip) {
                if (inputArr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum length and starting index
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }

            right++;
        }

        // Extract the max subsequence
        int[] maxSeq = Arrays.copyOfRange(inputArr, startIndex, startIndex + maxLength);
        return maxSeq;
    }

    public static void main(String[] args) {
        int[] inputArr = {0, 1, 0, 1, 0, 0, 1, 1};
        int flipC = 2;
        System.out.println(Arrays.toString(flippingZeroes(inputArr, flipC)));
    }
}