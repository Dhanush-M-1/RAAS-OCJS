import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B {
    
    static StringTokenizer st;
    static BufferedReader in;
    static PrintWriter pw;
    static boolean[]used;
    static int[]p;
    static ArrayList<Integer> order;
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        int k = nextInt();
        p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = nextInt();
        }
        ArrayList<Integer>[]L = new ArrayList[n+1];
        int cnt = 0;
        int[]clas = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (p[i]==0) {
                L[++cnt] = new ArrayList<Integer>();
                L[cnt].add(i);
                clas[i] = cnt;
            }
        }
        for (int it = 1; it <= n; it++) {
            for (int i = 1; i <= n; i++) {
                if (clas[i]==0 && clas[p[i]] != 0) {
                    clas[i] = clas[p[i]];
                    L[clas[i]].add(i);
                }
            }
        }
        int t = 0;
        for (int i = 1; i <= cnt; i++) {
            if (L[i].contains(k)) {
                t = i;
                k = L[i].indexOf(k)+1;
                break;
            }
        }
        int[]q = new int[n+1];
        int r = 0;
        for (int i = 1; i <= cnt; i++) {
            if (i != t) {
                r++;
                q[r] = L[i].size();
            }
        }
        boolean[]ans = new boolean[n+1];
        cnt = r;
        boolean[][]possible = new boolean[n+1][cnt+1];
        Arrays.fill(possible[0], true);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cnt; j++) {
                if (possible[i][j-1])
                    possible[i][j] = true;
                if (i-q[j] >= 0 && possible[i-q[j]][j-1])
                    possible[i][j] = true;
            }
        }
        for (int i = 0; i <= n-k; i++) {
            if (possible[i][cnt])
                ans[i+k] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (ans[i])
                pw.println(i);
        }
        pw.close();
    }
    private static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    
    private static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    
    private static double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
    
    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}
