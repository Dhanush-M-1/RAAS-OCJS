import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class ZgukistringZ {
    
    static final int INF = Integer.MAX_VALUE / 4;
    
    void solve() {
        String a = in.nextToken(), b = in.nextToken(), c = in.nextToken();
        int[] ca = new int[26], cb = new int[26], cc = new int[26];
        for (char ch : a.toCharArray()) ca[ch - 'a']++;
        for (char ch : b.toCharArray()) cb[ch - 'a']++;
        for (char ch : c.toCharArray()) cc[ch - 'a']++;
        
        int mb = INF;
        for (int i = 0; i < 26; i++) {
            if (cb[i] > 0) {
                mb = Math.min(mb, ca[i] / cb[i]);
            }
        }
        
        int max = 0;
        int[] res = new int[]{0, 0};
        for (int nb = 0; nb <= mb; nb++) {
            int nc = INF;
            for (int i = 0; i < 26; i++) {
                if (cc[i] > 0) {
                    nc = Math.min(nc, (ca[i] - nb * cb[i]) / cc[i]);
                }
            }
            if (max < nb + nc) {
                max = nb + nc;
                res[0] = nb;
                res[1] = nc;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            ca[i] -= res[0] * cb[i];
            ca[i] -= res[1] * cc[i];
        }
        
        for (int i = 0; i < res[0]; i++) {
            out.print(b);
        }
        for (int i = 0; i < res[1]; i++) {
            out.print(c);
        }
        for (int i = 0; i < 26; i++) {
            while (ca[i] > 0) {
                out.print((char) (i + 'a'));
                ca[i]--;
            }
        }
        out.println();
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new ZgukistringZ().solve();
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
