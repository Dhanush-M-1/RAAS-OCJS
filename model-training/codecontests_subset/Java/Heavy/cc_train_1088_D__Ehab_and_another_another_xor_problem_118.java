import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
public class EhabAnotherXOR {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int curA = 0;
        int curB = 0;
        System.out.println("? 0 0");
        System.out.flush();
        int greater = scanner.nextInt();
        for(int i = 29; i >= 0; i--) {
            int curLoc = 1<<i;
            int outB = curLoc ^ curB;
            int outA = curLoc ^ curA;
            System.out.println("? " + outA + " " + curB);
            System.out.flush();
            int res1 = scanner.nextInt();
            if (res1 == -2) break;
            System.out.println("? " + curA + " " + outB);
            System.out.flush();
            int res2 = scanner.nextInt();
            if (res1 == res2) {
                if (greater == 1) curA ^= curLoc;
                else {
                    curB ^= curLoc;
                }
                greater = res1;
            }
            else if (res1 == -1) {
                curA ^= curLoc;
                curB ^= curLoc;
            }
        }
        System.out.println("! " + curA + " " + curB);
        System.out.flush();
    }
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        public FastScanner() {
            this(new InputStreamReader(System.in));
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
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
    }
}
