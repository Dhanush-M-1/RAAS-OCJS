import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int res = Integer.MAX_VALUE;

        outer: for (int i = 0; i < n; i++) {
            int x = 0;
            if (b[i] > a[0]) {
                x = b[i] - (a[0] % m);
            } else {
                x = m+b[i] - (a[0] % m);
            }
            x %= m;

            int[] copyA = new int[n];
            for (int j = 0; j < n; j++) {
                copyA[j] = (a[j] + x) % m;
            }
            Arrays.sort(copyA);

            for (int j = 0; j < n; j++) {
                if (copyA[j] != b[j]) {
                    continue outer;
                }
            }

            res = Math.min(res, x);
        }

        System.out.println(res);
    }

}
/*
5 + x mod 3 = 2

 */
