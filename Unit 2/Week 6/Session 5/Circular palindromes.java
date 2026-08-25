import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String nStr = br.readLine();
        if (nStr == null || nStr.trim().isEmpty()) return;
        
        int n = Integer.parseInt(nStr.trim());
        String s = br.readLine().trim();

        // Solve for all rotations of S
        int[] result = getMaxPalindromePerRotation(s, n);

        // Fast output
        StringBuilder sb = new StringBuilder();
        for (int ans : result) {
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int[] getMaxPalindromePerRotation(String s, int n) {
        // Double string to represent all cyclic rotations as length-n windows
        String doubled = s + s;
        int m = doubled.length();

        // 1. Transform string for Manacher's Algorithm (insert '#' between characters)
        char[] t = new char[2 * m + 3];
        t[0] = '^';
        t[2 * m + 2] = '$';
        for (int i = 0; i < m; i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = doubled.charAt(i);
        }
        t[2 * m + 1] = '#';

        // 2. Run Manacher's Algorithm
        int tLen = t.length;
        int[] p = new int[tLen]; // p[i] = radius of palindrome centered at i
        int center = 0, right = 0;

        for (int i = 1; i < tLen - 1; i++) {
            int mirror = 2 * center - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // 3. Process rotations using sliding window over Manacher centers
        int[] ans = new int[n];

        for (int k = 0; k < n; k++) {
            // Window in original doubled string is [k, k + n - 1]
            // Transformed indices range from 2*k + 1 to 2*(k + n) + 1
            int winStart = 2 * k + 1;
            int winEnd = 2 * (k + n) + 1;

            int maxPalLen = 0;

            for (int i = winStart; i <= winEnd; i++) {
                // Max radius centered at i clipped to current rotation boundary
                int maxPossibleRadius = Math.min(i - winStart, winEnd - i);
                int actualRadius = Math.min(p[i], maxPossibleRadius);
                
                maxPalLen = Math.max(maxPalLen, actualRadius);
            }

            ans[k] = maxPalLen;
        }

        return ans;
    }
}
