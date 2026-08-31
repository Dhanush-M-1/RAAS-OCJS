import java.util.*;

public class Prob1269B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long tmp = ((b[i] - a[0])) % m;
            boolean done = true;
            for (int j = 0; j < n; j++) {
                if ((a[j % n] + tmp) % m != (b[(i + j) % n]) % m) {
                    done = false;
                    break;
                }
            }
            if (done) {
                ans = Math.min(ans, (tmp < 0) ? tmp + m : tmp % m);
            }
        }
        System.out.println(ans);
    }
}
