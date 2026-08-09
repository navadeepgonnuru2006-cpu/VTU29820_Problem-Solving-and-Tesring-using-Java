import java.util.Arrays;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // Store indices 0 to n - 1
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices in descending order based on heights
        Arrays.sort(indices, (a, b) -> Integer.compare(heights[b], heights[a]));

        // Build the result array using sorted indices
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[indices[i]];
        }

        return result;
    }
}
