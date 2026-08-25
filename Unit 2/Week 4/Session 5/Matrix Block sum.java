import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // 2D Prefix Sum Array padded with +1 to avoid out-of-bounds checks
        int[][] pref = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i + 1][j + 1] = mat[i][j] 
                                    + pref[i][j + 1] 
                                    + pref[i + 1][j] 
                                    - pref[i][j];
            }
        }

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Determine bounding box coordinates clamped within matrix limits
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                // Calculate subgrid sum in O(1) using 1-indexed prefix array coordinates
                answer[i][j] = pref[r2 + 1][c2 + 1] 
                             - pref[r1][c2 + 1] 
                             - pref[r2 + 1][c1] 
                             + pref[r1][c1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Optional standard input reading for competitive programming environments
        if (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] mat = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = scanner.nextInt();
                }
            }

            int[][] ans = matrixBlockSum(mat, k);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(ans[i][j] + (j == n - 1 ? "" : " "));
                }
                System.out.println();
            }
        } else {
            // Default sample test cases execution
            int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            int k1 = 1;
            System.out.println("Example 1 Output: " + Arrays.deepToString(matrixBlockSum(mat1, k1)));
            // Output: [[12, 21, 16], [27, 45, 33], [24, 39, 28]]

            int[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            int k2 = 2;
            System.out.println("Example 2 Output: " + Arrays.deepToString(matrixBlockSum(mat2, k2)));
            // Output: [[45, 45, 45], [45, 45, 45], [45, 45, 45]]
        }

        scanner.close();
    }
}
