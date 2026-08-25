import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the matrixRotation function below.
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> ring = new ArrayList<>();

            // 1. Extract elements in anti-clockwise order
            
            // Top edge (left to right)
            for (int j = layer; j < n - layer; j++) {
                ring.add(matrix.get(layer).get(j));
            }
            // Right edge (top + 1 to bottom)
            for (int i = layer + 1; i < m - layer; i++) {
                ring.add(matrix.get(i).get(n - 1 - layer));
            }
            // Bottom edge (right - 1 to left)
            for (int j = n - 2 - layer; j >= layer; j--) {
                ring.add(matrix.get(m - 1 - layer).get(j));
            }
            // Left edge (bottom - 1 to top + 1)
            for (int i = m - 2 - layer; i > layer; i--) {
                ring.add(matrix.get(i).get(layer));
            }

            int L = ring.size();
            int effectiveR = r % L;

            // 2. Put rotated elements back into matrix
            int idx = 0;

            // Top edge
            for (int j = layer; j < n - layer; j++) {
                matrix.get(layer).set(j, ring.get((idx + effectiveR) % L));
                idx++;
            }
            // Right edge
            for (int i = layer + 1; i < m - layer; i++) {
                matrix.get(i).set(n - 1 - layer, ring.get((idx + effectiveR) % L));
                idx++;
            }
            // Bottom edge
            for (int j = n - 2 - layer; j >= layer; j--) {
                matrix.get(m - 1 - layer).set(j, ring.get((idx + effectiveR) % L));
                idx++;
            }
            // Left edge
            for (int i = m - 2 - layer; i > layer; i--) {
                matrix.get(i).set(layer, ring.get((idx + effectiveR) % L));
                idx++;
            }
        }

        // 3. Print resultant matrix
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix.get(i).get(j)).append(j == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);
        int n = Integer.parseInt(mnr[1]);
        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
