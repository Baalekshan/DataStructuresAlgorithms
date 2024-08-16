package slidingWindows;

import java.util.HashMap;
import java.util.Map;

public class shortSeq {

    public static String getShortestSubstring(String inputString, String characters) {
        // Current sliding window starting index
        int windowStartIndex = 0;

        // Start/end indexes of the smallest window that has all the needed chars
        int smallestWindowStartIndex = 0, smallestWindowEndIndex = 0;

        // Calculate how many times of which characters we need to find
        Map<Character, Integer> neededCharCounts = new HashMap<>();
        for (char c : characters.toCharArray()) {
            neededCharCounts.put(c, neededCharCounts.getOrDefault(c, 0) + 1);
        }

        // How many of the needed chars we didn't find yet in the current window
        int missingCharCount = characters.length();

        // Traverse the entire string and look for missing needed chars
        for (int windowEndIndex = 0; windowEndIndex < inputString.length(); windowEndIndex++) {
            char ch = inputString.charAt(windowEndIndex);

            // If we found one of the missing needed chars, decrease its needed count by one
            if (neededCharCounts.containsKey(ch)) {
                if (neededCharCounts.get(ch) > 0) {
                    missingCharCount--;
                }
                neededCharCounts.put(ch, neededCharCounts.get(ch) - 1);
            }

            // If we managed to find all the needed chars in the current sliding window
            // Repeatedly shrink the window from the left as long as we still have all the needed chars in the window
            if (missingCharCount == 0) {
                char leftChar = inputString.charAt(windowStartIndex);
                while (windowStartIndex < windowEndIndex && (!neededCharCounts.containsKey(leftChar) || neededCharCounts.get(leftChar) < 0)) {
                    if (neededCharCounts.containsKey(leftChar)) {
                        neededCharCounts.put(leftChar, neededCharCounts.get(leftChar) + 1);
                    }
                    windowStartIndex++;
                    leftChar = inputString.charAt(windowStartIndex);
                }

                // Take note of the smallest window (that has all the needed chars) that we found up to this moment
                if (smallestWindowEndIndex == 0 || (windowEndIndex - windowStartIndex) < (smallestWindowEndIndex - smallestWindowStartIndex)) {
                    smallestWindowStartIndex = windowStartIndex;
                    smallestWindowEndIndex = windowEndIndex;
                }
            }
        }

        // Return the smallest window substring
        return smallestWindowEndIndex == 0 ? "" : inputString.substring(smallestWindowStartIndex, smallestWindowEndIndex + 1);
    }

    public static void main(String[] args) {
        String inputString = "ADOBECODEBANC";
        String characters = "ABC";
        String result = getShortestSubstring(inputString, characters);
        System.out.println(result);  // Output: "BANC"
    }
}
