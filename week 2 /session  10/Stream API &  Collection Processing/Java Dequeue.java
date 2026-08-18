import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            // Add the new element to the back
            deque.addLast(arr[i]);
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);

            // If window size exceeds k, remove from the front
            if (deque.size() > k) {
                int removed = deque.removeFirst();

                frequency.put(removed, frequency.get(removed) - 1);

                if (frequency.get(removed) == 0) {
                    frequency.remove(removed);
                }
            }

            // Once the window reaches size k, update maximum
            if (deque.size() == k) {
                maxUnique = Math.max(maxUnique, frequency.size());
            }
        }

        System.out.println(maxUnique);

        sc.close();
    }
}
