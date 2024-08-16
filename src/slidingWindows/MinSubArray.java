package slidingWindows;

import java.util.Arrays;

public class MinSubArray {
    public static void main(String[] args) {
        int[] input = {1,4,4};
        int target = 4;
        System.out.println(minSubArrayLen(input, target));
    }

    public static int minSubArrayLen(int[] input, int target) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < input.length; right++ ) {
            sum += input[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= input[left];
                left++;
            }
        }
        return minLen;
    }
}
