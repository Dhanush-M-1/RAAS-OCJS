import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= a[n-1]; i++) {
            int num = solve(a, i, k);
            min = Math.min(min, num);
        }

        System.out.println(min);
    }

    private static int solve(int[] a, int target, int k) {
        int ret = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int w = a[i];
            if (w < target) {
                continue;
            }
            int opCount = 0;
            while (w > target) {
                opCount++;
                w /= 2;
            }
            if (target == w) {
                ret += opCount;
                count++;
            }
            if (count >= k) {
                break;
            }
        }

        return count >= k ? ret : Integer.MAX_VALUE;
    }
}
