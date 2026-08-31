import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] pos = new int[n];
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
            heights[i] = in.nextInt();
        }
        int hold = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            int max = Math.max(hold, Math.max(left, right));
            int tmpHold = hold;
            int tmpLeft = left;
            int tmpRight = right;
            hold = max;
            int prev = i > 0 ? pos[i - 1] : Integer.MIN_VALUE;
            int prevHeight = i > 0 ? heights[i - 1] : 0;
            left = Math.max(left, pos[i] - heights[i] > prev ? tmpHold + 1 : tmpHold);
            left = Math.max(left, pos[i] - heights[i] > prev ? tmpLeft + 1 : tmpLeft);
            if (prev + prevHeight < pos[i]) {
                left = Math.max(left, pos[i] - heights[i] > prev + prevHeight ? tmpRight + 1 : tmpRight);
            } else {
                left = Math.max(left, pos[i] - heights[i] > prev ? tmpRight + 1 : tmpRight);
            }
            int next = i < n - 1 ? pos[i + 1] : Integer.MAX_VALUE;
            right = max + (pos[i] + heights[i] < next ? 1 : 0);
        }
        System.out.println(Math.max(hold, Math.max(left, right)));
    }
}