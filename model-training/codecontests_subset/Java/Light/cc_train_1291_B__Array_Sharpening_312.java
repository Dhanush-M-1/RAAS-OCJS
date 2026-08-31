import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int u = 0; u < t; u++) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt() + 1;
            }

            int leftMax = -1;
            int rightMax = n;
            for (int i = 0; i < n && a[i] > i; i++) {
                leftMax = i;
            }
            for (int i = n - 1; i >= 0 && a[i] > n - 1 - i; i--) {
                rightMax = i;
            }
            if (rightMax <= leftMax)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
