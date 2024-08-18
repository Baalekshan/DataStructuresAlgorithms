package slidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LargestSubSequence {
    public static int totalFruit(int[] fruits) {
        int windowStart = 0;
        int windowMax = 0;
        Map<Integer, Integer> fruitMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            System.out.println(windowEnd);
            int endFruit = fruits[windowEnd];
            fruitMap.put(endFruit, fruitMap.getOrDefault(endFruit, 0)+1);
            while (fruitMap.size() > 2) {
                int startFruit = fruits[windowStart];
                fruitMap.put(startFruit, fruitMap.get(startFruit)-1);
                if (fruitMap.get(startFruit) == 0) {
                    fruitMap.remove(startFruit);
                }
                windowStart++;
            }
            windowMax = Math.max(windowMax, windowEnd - windowStart + 1);
        }

        System.out.println(windowStart);
        return windowMax;

    }

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));

    }
}
