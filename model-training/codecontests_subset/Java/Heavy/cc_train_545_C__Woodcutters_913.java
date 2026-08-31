import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 3) {
            System.out.println(n);
            return;
        }
        int[] pos = new int[n];
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
            heights[i] = in.nextInt();
        }
        int count = 2;
        int prev = pos[0];
        for (int i = 1; i < n - 1; i++) {
            if (pos[i] - heights[i] > prev) {
                count++;
                prev = pos[i];
            } else if (pos[i] + heights[i] < pos[i + 1]) {
                count++;
                prev = pos[i] + heights[i];
            } else {
                prev = pos[i];
            }
        }
        System.out.println(count);
    }
}