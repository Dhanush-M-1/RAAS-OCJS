import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        String s = fs.next();

        boolean flag = false;
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) > s.charAt(i+1)) {
                System.out.println("YES");
                System.out.println((i+1) + " " + (i+2));
                flag = true;
                break;
            }

            // end test cases
        }

        if (!flag) {
            System.out.println("NO");
        }

        // end main
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}