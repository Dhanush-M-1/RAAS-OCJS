import java.util.*;

public class Main {

    public static long solve(int n, int m, Set<Integer> broken) {
        long[] cnt = new long[n + 1];

        cnt[0] = 1;
        if (broken.contains(1)) {
            cnt[1] = 0;
        } else {
            cnt[1] = 1;
        }
        for (int i = 2; i <= n; ++i) {
//            System.out.println(String.format("%d, %d", i, cnt[i-1]));
            if (broken.contains(i)) {
                cnt[i] = 0;
            } else {
                cnt[i] = (cnt[i - 1] + cnt[i - 2]) % 1000000007L;
            }
        }
        return cnt[n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> broken = new HashSet<Integer>();
        for (int i = 0; i < m; ++i) {
            broken.add(sc.nextInt());
        }

        System.out.println(solve(n, m, broken));
    }
}
