package slidingWindows;

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordConcat {

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<>();

        if (words.length == 0 || words[0].length() == 0) {
            return resultIndices;
        }

        Map<String, Integer> wordFreq = new HashMap<>();

        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            System.out.println("Map: "+wordFreq);
        }

        int wordCount = words.length;
        int wordLength = words[0].length();
        int strLength = str.length();

        for (int i = 0; i <= strLength - wordCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            int j;

            for (j = 0; j < wordCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);

                System.out.println("Word:"+word);
                if (!wordFreq.containsKey(word)) {
                    break;
                }

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                if (wordsSeen.get(word) > wordFreq.getOrDefault(word, 0)) {
                    break;
                }

                if (j + 1 == wordCount) {
                    resultIndices.add(i);
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"})); // [0, 3]
        System.out.println(findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"})); // [3]
    }
}
