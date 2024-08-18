package slidingWindows;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSub {
    public static int noRepeatSub(String string) {
        int windowStart = 0;
        int windowMax = 0;
        Map<Character, Integer> stringMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char endString = string.charAt(windowEnd);
            stringMap.put(endString, stringMap.getOrDefault(endString, 0) + 1);
            System.out.println("Window: "+stringMap);
            while (stringMap.get(endString) > 1) {
                char startString = string.charAt(windowStart);
                stringMap.put(startString, stringMap.get(endString) - 1);
                if (stringMap.get(startString) == 0) {
                    stringMap.remove(startString);
                    System.out.println("remove: "+ stringMap);
                }
                System.out.println("shrink: "+ stringMap);
                windowStart++;
            }
            windowMax = Math.max(windowMax, windowEnd - windowStart + 1);
        }
        System.out.println(windowStart);
        return windowMax;

    }

    public static void main(String[] args) {
        String fruits = "ccaabbb";
        System.out.println(noRepeatSub(fruits));

    }
}
