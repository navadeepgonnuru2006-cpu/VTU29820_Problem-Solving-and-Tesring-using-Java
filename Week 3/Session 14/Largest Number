import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert int array to String array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator: compare combined strings (s2 + s1) vs (s1 + s2)
        Arrays.sort(strNums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // Edge case: if the highest value number is "0", the result is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build result string
        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }

        return sb.toString();
    }
}
