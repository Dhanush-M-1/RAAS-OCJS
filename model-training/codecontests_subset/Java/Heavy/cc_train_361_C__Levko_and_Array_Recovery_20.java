import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: Jovfer
 * Date: 10.11.13
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */
public class taskA {
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        taskA taskA = new taskA();
        taskA.open();
        taskA.solve();
        taskA.close();
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String str = in.readLine();
            if (str == null) return null;
            else st = new StringTokenizer(str);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private void close() {
        try {
            out.close();
            in.close();
        } catch (IOException ignore) {
        }
    }

    int n, m, k;
    int[] a;

    int[] up, d;

    int[] ll,rr,op,tt;

    private void solve() throws IOException {
        n = nextInt();
        m = nextInt();
        a = new int[n];
        d= new int[n];
        up = new int[n];
        ll = new int[m];
        rr = new int[m];
        op = new int[m];
        tt = new int[m];
        Arrays.fill(up, (int) (1e9));
        Arrays.fill(d,0);
        for (int i = 0; i < m; i++) {
            int t = nextInt();
            tt[i] = t;
            int l = nextInt()-1,r =nextInt()-1;
            ll[i]=l;
            rr[i]=r;
            if (t==1) {
                int curD = nextInt();
                op[i]=curD;
                for (int j = l; j <= r; j++) {
                    d[j] += curD;
                    //up[j] = Math.min(up[j], (int)1e9-d[j]);
                }
            } else { //t==2
                int curM = nextInt();
                op[i]=curM;
                for (int j = l; j <= r; j++) {
                    up[j] = Math.min(up[j],curM - d[j]);
                    if (up[j] < -(1e9)) {
                        out.println("NO");
                        return;
                    }
                }
            }
        }
        a = up.clone();
        for (int i = 0; i < m; i++) {
            int t = tt[i];
            int l = ll[i];
            int r = rr[i];
            int cur = op[i];
            if (t == 1) {
                for (int j = l; j <= r; j++) {
                    a[j] += cur;
                }
            } else {
                int max = a[r];
                for (int j = l; j < r; j++) {
                    max = Math.max(max,a[j]);
                }
                if (max != cur) {
                    out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");
        for (int i = 0; i < n; i++) {
            out.print(up[i]);
            out.print(' ');
        }
    }

    private void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }

}
