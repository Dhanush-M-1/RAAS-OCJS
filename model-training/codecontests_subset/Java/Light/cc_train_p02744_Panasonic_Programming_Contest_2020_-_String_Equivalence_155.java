import java.util.*;

public class Main {
    int n;
    int[] arr;
    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dfs(1, 0, 0);
    }

    void dfs(int i, int x, int usedMax) {
        if (i == n) {
            print(arr);
            return;
        }

        for (int j = 0; j <= usedMax + 1; j++) {
            int nx = x + j;
            arr[i] = nx;
            dfs(i + 1, x, Math.max(nx, usedMax));
        }
    }

    void print(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n ;i++) {
            sb.append((char) ('a' + arr[i]));
        }
        System.out.println(sb.toString());
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
