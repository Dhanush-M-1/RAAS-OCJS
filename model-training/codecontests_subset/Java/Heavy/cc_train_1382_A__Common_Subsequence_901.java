import java.io.*;
import java.util.*;

public class CFA {

    final static PrintWriter out = new PrintWriter(System.out);
    final static Reader in = new Reader();

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (final IOException e) {
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
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static long binpow(final int a, final int b) {
        if (b == 0)
            return 1;
        final long res = binpow(a, b / 2);
        if (b % 2 == 1)
            return res * res * a;
        else
            return res * res;
    }

    static long gcd(final long a, final long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int n, m, y, k;
    static char[] c;
    static int[] a, b;
    static int[] p;
    static double x;

    public static void main(final String[] args) throws Exception {
        int t = in.nextInt();

        while(t-->0){
            n = in.nextInt();
            m = in.nextInt();

            HashSet<Integer> set = new HashSet<>();
            for(int i = 0;i < n;i++){
                set.add(in.nextInt());
            }

            int ans = -1;
            for(int i = 0;i < m;i++){
                int inp = in.nextInt();
                if(set.contains(inp) && ans == -1){
                    ans = inp;
                }
            }

            if(ans == -1){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
                System.out.println("1 "+ans);
            }
        }
        
        out.close();
    }

}

// 76 52 28 00 73 42 23 64 48