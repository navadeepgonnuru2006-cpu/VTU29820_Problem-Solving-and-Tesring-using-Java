
import java.util.*;

public class Solution {
    public static int maxDistinct(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            return 0;
        }

        HashMap<Integer, Integer> frequency = new HashMap<>();
        int distinct = 0;
        int maximum = 0;

        for (int i = 0; i < arr.length; i++) {
            int incoming = arr[i];

            int oldCount = frequency.getOrDefault(incoming, 0);
            frequency.put(incoming, oldCount + 1);

            if (oldCount == 0) {
                distinct++;
            }

            if (i >= k) {
                int outgoing = arr[i - k];
                int count = frequency.get(outgoing);

                if (count == 1) {
                    frequency.remove(outgoing);
                    distinct--;
                } else {
                    frequency.put(outgoing, count - 1);
                }
            }

            if (i >= k - 1) {
                maximum = Math.max(maximum, distinct);
            }
        }

        return maximum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(maxDistinct(arr, k));

        sc.close();
    }
}
