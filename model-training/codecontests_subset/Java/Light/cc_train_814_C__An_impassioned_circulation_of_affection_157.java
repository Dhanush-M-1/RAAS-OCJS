import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(x.readLine());
        String s = x.readLine();
        int[][] best = new int[26][n + 1];
        for (int i = 0; i < 26; i++) {
            int[] pre = new int[n];
            if (s.charAt(0) == 'a' + i) {
                pre[0] = 1;
            }
            for (int j = 1; j < n; j++) {
                pre[j] = pre[j - 1];
                if (s.charAt(j) == 'a' + i) {
                    pre[j]++;
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int num = pre[k]; //number of that letter
                    if (j != 0) num -= pre[j - 1];
                    int cost = k - j + 1 - num;
                    best[i][cost] = Math.max(best[i][cost], k - j + 1);
                }
            }
            for (int j = 1; j <= n; j++) {
                best[i][j] = Math.max(best[i][j], best[i][j - 1]);
            }
        }
        int q = Integer.parseInt(x.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(x.readLine());
            int m = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            System.out.println(best[c - 'a'][m]);
        }
    }
}