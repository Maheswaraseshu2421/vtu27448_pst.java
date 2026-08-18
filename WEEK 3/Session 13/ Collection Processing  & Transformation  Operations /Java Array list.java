import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        List<List<Integer>> lines = new ArrayList<>();

        // Read n lines of integers
        for (int i = 0; i < n; i++) {
            int d = scan.nextInt(); // Number of integers in this line
            List<Integer> currentLine = new ArrayList<>();
            
            for (int j = 0; j < d; j++) {
                currentLine.add(scan.nextInt());
            }
            
            lines.add(currentLine);
        }

        int q = scan.nextInt(); // Number of queries

        // Process each query
        for (int i = 0; i < q; i++) {
            int x = scan.nextInt(); // 1-based line index
            int y = scan.nextInt(); // 1-based position index

            // Convert 1-based indices to 0-based indices for Java ArrayList
            int lineIdx = x - 1;
            int posIdx = y - 1;

            // Check if line number and position exist
            if (lineIdx >= 0 && lineIdx < lines.size() && 
                posIdx >= 0 && posIdx < lines.get(lineIdx).size()) {
                System.out.println(lines.get(lineIdx).get(posIdx));
            } else {
                System.out.println("ERROR!");
            }
        }

        scan.close();
    }
}
