import java.util.Scanner;

/**
 * Created by yuu on 8/4/17.
 */
public class Problem545C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pos = new int[n];
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }
        if (n <= 2) {
            System.out.println(n);
        }
        else {
            int counter = 2;
            for (int i = 1; i < n-1; i++) {
                if (pos[i] - height[i] > pos[i-1]) {
                    counter++;
                    continue;
                }
                if (pos[i] + height[i] < pos[i+1]) {
                    counter++;
                    pos[i] += height[i];
                }
            }
            System.out.println(counter);
        }
    }
}
