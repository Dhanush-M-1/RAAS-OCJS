import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class ExamGeometry {
    void solve() {
        int[] x = new int[3], y = new int[3];
        for (int i = 0; i < 3; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        
        long AB = squareDistance(x[0], y[0], x[1], y[1]);
        long BC = squareDistance(x[1], y[1], x[2], y[2]);
        
        if (AB != BC) {
            out.println("No");
            return;
        }
        
        if (det(x[1] - x[0], y[1] - y[0], x[2] - x[1], y[2] - y[1]) == 0) {
            out.println("No");
            return;
        }
        
        out.println("Yes");
    }
    
    long det(long x1, long y1, long x2, long y2) {
        return x1 * y2 - y1 * x2;
    }
    
    long squareDistance(long x1, long y1, long x2, long y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new ExamGeometry().solve();
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
