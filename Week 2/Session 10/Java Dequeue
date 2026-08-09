import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add current number to window
            deque.add(num);
            set.add(num);

            // When the sliding window reaches size M
            if (deque.size() == m) {
                // Update maximum unique count
                if (set.size() > maxUnique) {
                    maxUnique = set.size();
                }

                // Optimization: If max possible unique elements found, break early
                if (maxUnique == m) {
                    break;
                }

                // Slide window: remove the leftmost element
                int first = deque.removeFirst();
                
                // If the removed element is not present elsewhere in the deque, remove from set
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        
        in.close();
        System.out.println(maxUnique);
    }
}
