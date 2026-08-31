import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        int d = in.nextInt();

        int curr = 0, min = 0;
        int res = 0;

        for(int i = 0; i < n; ++i) {
            int x = in.nextInt();

            if(x != 0) {
                curr += x;
                min += x;
            } else {
                if(curr < 0) {
                    res++;
                    curr = d;
                }

                min = Math.max(0, min);
            }

            curr = Math.min(curr, d);
            if(min > d) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(res);

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
}
