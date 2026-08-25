import java.util.Scanner;

public class Solution {

    /**
     * Solves LeetCode 28: Find the Index of the First Occurrence in a String.
     * Uses the Knuth-Morris-Pratt (KMP) algorithm for O(m + n) time complexity.
     *
     * @param haystack Main text string
     * @param needle   Pattern string to search for
     * @return Starting index of the first occurrence of needle, or -1 if not found
     */
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();

        if (n > m) {
            return -1;
        }

        // Precompute Longest Prefix Suffix (LPS) array
        int[] lps = buildLPS(needle);

        int i = 0; // Pointer for haystack
        int j = 0; // Pointer for needle

        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == n) {
                return i - j; // Found match, return starting index
            } else if (i < m && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS to skip unnecessary comparisons
                } else {
                    i++;
                }
            }
        }

        return -1; // Match not found
    }

    /**
     * Builds the Longest Prefix Suffix (LPS) table for KMP pattern matching.
     */
    private static int[] buildLPS(String needle) {
        int n = needle.length();
        int[] lps = new int[n];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Standard competitive programming/console entry check
        if (scanner.hasNext()) {
            String haystack = scanner.next();
            String needle = scanner.next();

            int index = strStr(haystack, needle);
            System.out.println(index);
        } else {
            // Default sample test cases execution
            String haystack1 = "sadbutsad";
            String needle1 = "sad";
            System.out.println("Example 1 Output: " + strStr(haystack1, needle1)); // Expected: 0

            String haystack2 = "leetcode";
            String needle2 = "leeto";
            System.out.println("Example 2 Output: " + strStr(haystack2, needle2)); // Expected: -1
        }

        scanner.close();
    }
}
