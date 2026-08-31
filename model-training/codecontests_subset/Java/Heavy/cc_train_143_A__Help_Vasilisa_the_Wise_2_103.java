
import java.io.*;
import java.util.*;

public class JavaApplication14 {

    public static void main(String[] args) {

        FastReader sc = new FastReader();
        int r1 = sc.nextInt(), r2 = sc.nextInt();
        int c1 = sc.nextInt(), c2 = sc.nextInt();
        int d1 = sc.nextInt(), d2 = sc.nextInt();

        /* r1 = a + b
           r2 = x + y
        c1=r1+d2-2b
        c1=r2+d1-2y
         */
        int b = 0, y = 0;
        if (r1 <= 2 || r2 <= 2 || c1 <= 2 || c2 <= 2 || d1 <= 2 || d2 <= 2) {
            System.out.println(-1);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (c1 == (r1 + d2 - (2 * i))) {
                b = i;
                break;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (c1 == (r2 + d1 - (2 * i))) {
                y = i;
                break;
            }
        }
        int[] a = {b, y, r1 - b, r2 - y};
        for (int i = 0; i < 4; i++) {
            if (a[i] > 9||a[i]==0) {
                System.out.println(-1);
                return;
            }
            for (int j = 0; i != j && j < 3; j++) {
                if (a[i] == a[j]) {
                    System.out.println(-1);
                    return;
                }
            }

        }
            System.out.println((r1 - b) + " " + b + "\n" + (r2 - y) + " " + y);
        }
    }


class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        InputStreamReader inr = new InputStreamReader(System.in);
        br = new BufferedReader(inr);
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
