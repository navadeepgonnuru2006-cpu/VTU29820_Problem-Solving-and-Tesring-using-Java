public class Solution {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindrome (center is s[i])
            int len1 = expandAroundCenter(s, i, i);
            // Case 2: Even-length palindrome (center is between s[i] and s[i+1])
            int len2 = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            // Update starting and ending indices if a longer palindrome is found
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return length of the expanded palindrome
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // Output: "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));  // Output: "bb"
    }
}
