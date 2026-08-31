import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = scanner.nextInt();
        long[] s = new long[n];
        int[] ans = new int[n];
        SegTree sg= new SegTree(n, 0, n-1);
        for(int i = 0; i < n; i++) {
            s[i] = scanner.nextLong();
            sg.increment(1, i,i, s[i]);
        }
        for(int i = 1; i <= n; i++) {
            int loc = sg.minimum(1, 0, n-1);
            sg.increment(1, loc, loc, Long.MAX_VALUE/3);
            ans[loc] = i;
            sg.increment(1, loc, n-1, -i);
        }
        for(int i = 0; i < n; i++) {
            if (i > 0) out.print(" ");
            out.print(ans[i]);
        }
        out.println();
        out.flush();
    }
    
    static class SegTree {
        int[] hi, lo;
        long[] min, delta;
        int sz;
        public SegTree (int ss, int l, int r) {
            hi = new int[4 * ss + 1];
            lo = new int[4 * ss + 1];
            min = new long[4 * ss + 1];
            delta = new long[4 * ss + 1];
            sz = ss;
            init(1, l, r);
        }
        void init(int cur, int l, int r) {
            hi[cur] = r;
            lo[cur] = l;
            if (l == r) {
                return;
            }
            int mid = (l + r)/2;
            init(cur * 2, l, mid);
            init(cur*2+1, mid + 1, r);
        }
        void increment(int cur, int l, int r, long amt) {
            if (l > hi[cur] || r < lo[cur]) return;
            if (r >= hi[cur] && l <= lo[cur]) {
                delta[cur] += amt;
                return;
            }
            prop(cur);
            increment(cur*2, l, r, amt);
            increment(cur*2 + 1, l, r, amt);
            update(cur);
        }
        void prop(int cur) {
            delta[cur * 2] += delta[cur];
            delta[cur * 2 + 1] += delta[cur];
            delta[cur] = 0;
        }
        void update(int cur) {
            min[cur] = Math.min(min[cur*2] + delta[cur*2], min[cur*2+1] + delta[cur*2+1]);
        }
        int minimum(int cur, int l, int r) {
            if (l > hi[cur] || r < lo[cur]) {
                return Integer.MAX_VALUE/2;
            }
            if (lo[cur] == hi[cur]) return min[cur] + delta[cur] == 0 ? lo[cur] : Integer.MAX_VALUE/2;
            prop(cur);
            if (delta[cur*2+1] + min[cur*2+1] == 0) {
                int min = minimum(cur*2+1, l, r);
                update(cur);
                return min;
            }
            int min = minimum(cur*2, l, r);
            update(cur);
            return min;
        }
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
    }
}
