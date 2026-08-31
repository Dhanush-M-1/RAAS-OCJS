import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class EhabAndAnotherAnotherXorProblem2 {
    void solve() {
        int a = 0, b = 0;
        int res = ask(0, 0);
        for (int i = 29; i >= 0; i--) {
            int x = ask(a | 1 << i, b);
            int y = ask(a, b | 1 << i);
            if (x == y) {
                if (res > 0) {
                    a |= 1 << i;
                } else {
                    b |= 1 << i;
                }
                res = x;
            } else {
                if (x < 0) {
                    a |= 1 << i;
                    b |= 1 << i;
                }
            }
        }
        out.printf("! %d %d%n", a, b);
    }
    
    int ask(int c, int d) {
        out.printf("? %d %d%n", c, d);
        out.flush();
        return in.nextInt();
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new EhabAndAnotherAnotherXorProblem2().solve();
        out.close();
    }
    
    static FastScanner in;
    static PrintWriter out;
    
    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;
        
        public FastScanner(BufferedReader in) {
            this.in = in;
        }
        
        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        
        public long nextLong() {
            return Long.parseLong(nextToken());
        }
        
        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
