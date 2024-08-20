package slidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LongOneSeqReplace {
    public static int longestOnes(int[] input, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int maxOnesCount = 0;

        for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            System.out.println(input[windowEnd]);
            if (input[windowEnd] == 1) {
                maxOnesCount++;

                System.out.println("increase: "+maxOnesCount);
            }

            if((windowEnd - windowStart + 1 - maxOnesCount) > k) {
                if(input[windowStart] == 1) {
                    maxOnesCount--;
                    System.out.println("decrease: "+maxOnesCount);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
