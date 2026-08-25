import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Skip comparing a word with itself
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Move to the next word once a match is found
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"mass", "as", "hero", "superhero"};
        System.out.println(stringMatching(words1)); // Output: [as, hero]

        String[] words2 = {"leetcode", "et", "code"};
        System.out.println(stringMatching(words2)); // Output: [et, code]

        String[] words3 = {"blue", "green", "bu"};
        System.out.println(stringMatching(words3)); // Output: []
    }
}
