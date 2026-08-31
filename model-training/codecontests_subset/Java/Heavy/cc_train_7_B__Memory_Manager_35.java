import java.util.Arrays;
import java.util.Scanner;


public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = sc.nextInt();
        int[]memoty = new int[m+1];
        int[]d = new int[m+1];
        boolean[]removed = new boolean[t+1];
        int cnt = 0;
        for (int i = 1; i <= t; i++) {
            char s = sc.next().charAt(0);
            if (s=='a') {
                int k = sc.nextInt();
                Arrays.fill(d, 0);
                for (int j = 1; j <= m; j++) {
                    if (memoty[j]==0) {
                        d[j] = 1;
                        d[j] += d[j-1];
                    }
                }
                boolean f = false;
                for (int j = 1; j <= m; j++) {
                    if (d[j] >= k) {
                        cnt++;
                        for (int j2 = j-k+1; j2 <= j; j2++) {
                            memoty[j2] = cnt;
                        }
                        System.out.println(cnt);
                        f = true;
                        break;
                    }
                }
                if (!f) {
                    System.out.println("NULL");
                }
            }
            else {
                if (s=='e') {
                    int k = sc.nextInt();
                    if (k <= 0 || k > cnt || removed[k]) {
                        System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    }
                    else {
                        removed[k] = true;
                        for (int j = 1; j <= m; j++) {
                            if (memoty[j]==k)
                                memoty[j] = 0;
                        }
                    }
                }
                else {
                    int p = 0;
                    for (int j = 1; j <= m; j++) {
                        if (memoty[j]!=0) {
                            memoty[++p] = memoty[j];
                        }
                    }
                    for (int j = p+1; j <= m; j++) {
                        memoty[j] = 0;
                    }
                }
            }
        }
    }

}
