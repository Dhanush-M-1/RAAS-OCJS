import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class EhabAndAnotherAnotherXorProblem {
    
    void solve() {
        
        int a = 0, b = 0;
        boolean[] vis = new boolean[30];
        for (int i = 29; i >= 0; ) {
            int exp = ask(a, b);
            if (exp == 0) break;
            
            int c = a, d = b;
            int j = i;
            while (j >= 0) {
                c |= 1 << j;
                d |= 1 << j;
                int cur = ask(c, d);
                if (cur == exp) {
                    j--;
                } else {
                    break;
                }
            }
            if (exp > 0) {
                a |= 1 << j;
            } else {
                b |= 1 << j;
            }
            vis[j] = true;
            
            i = j - 1;
        }
        
        for (int i = 29; i >= 0; i--) {
            if (!vis[i]) {
                if (ask(a | 1 << i, b) > 0) continue;
                a |= 1 << i;
                b |= 1 << i;
            }
        }
        
        printAns(a, b);
    }
    
    int ask(int c, int d) {
        out.printf("? %d %d%n", c, d);
        out.flush();
        return in.nextInt();
    }
    
    void printAns(int a, int b) {
        out.printf("! %d %d%n", a, b);
        out.flush();
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new EhabAndAnotherAnotherXorProblem().solve();
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
