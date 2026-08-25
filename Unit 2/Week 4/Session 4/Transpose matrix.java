import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    /**
     * Transposes an m x n matrix into an n x m matrix.
     *
     * @param matrix 2D input array of size m x n
     * @return Transposed 2D array of size n x m
     */
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Output matrix has dimensions n x m
        int[][] result = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Standard competitive programming / console execution layout
        if (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[][] transposed = transpose(matrix);

            // Print the resulting transposed matrix
            for (int i = 0; i < transposed.length; i++) {
                for (int j = 0; j < transposed[0].length; j++) {
                    System.out.print(transposed[i][j] + (j == transposed[0].length - 1 ? "" : " "));
                }
                System.out.println();
            }
        } else {
            // Sample test case fallback for standard run execution
            int[][] sample1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };

            int[][] sample2 = {
                {1, 2, 3},
                {4, 5, 6}
            };

            System.out.println("Sample 1 Transposed: " + Arrays.deepToString(transpose(sample1)));
            System.out.println("Sample 2 Transposed: " + Arrays.deepToString(transpose(sample2)));
        }

        scanner.close();
    }
}
