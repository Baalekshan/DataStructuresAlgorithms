package slidingWindows;

import java.util.Arrays;

public class findMaxAverage {
    public static void main(String[] args) {
        int[] input = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxavg(input, k));
    }
    public static double findMaxavg(int[] input, int k) {
        double currAvg;
        double maxAvg = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += input[i];
        }
        maxAvg = (double) sum / k;
        for (int i = k; i < input.length; i++) {
            sum += input[i] - input[i - k];
            currAvg = (double) sum / k;
            if (currAvg > maxAvg) {
                maxAvg = currAvg;
            }
        }
        return maxAvg;
    }
}
