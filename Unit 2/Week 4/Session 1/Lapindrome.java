import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            if (isLapindrome(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    private static boolean isLapindrome(String s) {
        int n = s.length();
        int mid = n / 2;

        int[] leftFreq = new int[26];
        int[] rightFreq = new int[26];

        // Fill left half frequency
        for (int i = 0; i < mid; i++) {
            leftFreq[s.charAt(i) - 'a']++;
        }

        // Fill right half frequency (skip middle element if length is odd)
        int rightStart = (n % 2 == 0) ? mid : mid + 1;
        for (int i = rightStart; i < n; i++) {
            rightFreq[s.charAt(i) - 'a']++;
        }

        // Compare frequencies of both halves
        return Arrays.equals(leftFreq, rightFreq);
    }
}
