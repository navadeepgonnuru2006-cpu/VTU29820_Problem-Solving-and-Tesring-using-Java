import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int[] patternCode = normalize(pattern);

        for (String word : words) {
            if (Arrays.equals(normalize(word), patternCode)) {
                result.add(word);
            }
        }

        return result;
    }

    // Maps a string to its canonical positional signature (e.g., "abb" -> [0, 1, 1])
    private static int[] normalize(String s) {
        int n = s.length();
        int[] res = new int[n];
        int[] firstOccur = new int[26];
        Arrays.fill(firstOccur, -1);

        int code = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (firstOccur[c - 'a'] == -1) {
                firstOccur[c - 'a'] = code++;
            }
            res[i] = firstOccur[c - 'a'];
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words1 = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern1 = "abb";
        System.out.println(findAndReplacePattern(words1, pattern1)); 
        // Output: [mee, aqq]

        String[] words2 = {"a", "b", "c"};
        String pattern2 = "a";
        System.out.println(findAndReplacePattern(words2, pattern2)); 
        // Output: [a, b, c]
    }
}
