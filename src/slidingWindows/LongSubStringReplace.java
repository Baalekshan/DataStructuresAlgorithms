package slidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LongSubStringReplace {
    public static int lengthOfLongestSubstring(String str, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char endChar = str.charAt(windowEnd);
            charMap.put(endChar, charMap.getOrDefault(endChar, 0) + 1);
            System.out.println("window :"+charMap);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charMap.get(endChar));
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char startChar = str.charAt(windowStart);
                charMap.put(startChar, charMap.get(startChar) - 1);
                windowStart++;
                System.out.println("shrink: "+charMap);
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabccbb", 2)); // 5
        System.out.println(lengthOfLongestSubstring("abbcb", 1));    // 4
        System.out.println(lengthOfLongestSubstring("abccde", 1));   // 3
    }
}
