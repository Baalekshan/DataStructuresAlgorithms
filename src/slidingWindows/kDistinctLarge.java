package slidingWindows;

import java.util.HashMap;
import java.util.Map;

public class kDistinctLarge {
    public static int distinctLarge(String fruits) {
        int windowStart = 0;
        int windowMax = 0;
        int windowEnd = 0;
        String sub = "";
        Map<Character, Integer> fruitMap = new HashMap<>();
        for (windowEnd = 0; windowEnd < fruits.length(); windowEnd++) {
            System.out.println(windowEnd);
            char endFruit = fruits.charAt(windowEnd);
            fruitMap.put(endFruit, fruitMap.getOrDefault(endFruit, 0)+1);
            while (fruitMap.size() > 2) {
                char startFruit = fruits.charAt(windowStart);
                fruitMap.put(startFruit, fruitMap.get(startFruit)-1);
                if (fruitMap.get(startFruit) == 0) {
                    fruitMap.remove(startFruit);
                }
                windowStart++;
            }
            windowMax = Math.max(windowMax, windowEnd - windowStart + 1);
        }
        System.out.println(windowStart);
        System.out.println(windowEnd);
        return windowMax;

    }

    public static void main(String[] args) {
        String fruits = "ccaabbb";
        System.out.println(distinctLarge(fruits));

    }
}