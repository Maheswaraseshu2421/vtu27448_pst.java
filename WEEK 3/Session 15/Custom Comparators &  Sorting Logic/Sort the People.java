import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        Integer[] index = new Integer[names.length];

        // Store indexes
        for (int i = 0; i < names.length; i++) {
            index[i] = i;
        }

        // Sort indexes based on heights in descending order
        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);

        // Create result array
        String[] result = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            result[i] = names[index[i]];
        }

        return result;
    }
}
