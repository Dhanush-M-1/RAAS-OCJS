import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {

    private static void solve() throws Exception {
        int n = fs.nextInt();
        int m = fs.nextInt();
        int[] a = fs.readArray(n);
        int[] b = fs.readArray(m);
        HashSet<Integer> hs = new HashSet<>();
        for (int i : b) hs.add(i);
        for (int i = 0 ; i < n ; i ++ ) {
            if (hs.contains(a[i])) {
                out.println("YES");
                out.println("1 " + a[i]);
                return;
            }
        }
        out.println("NO");

    }

    private static FastScanner fs = new FastScanner();
    private static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws  Exception{
        int T = fs.nextInt();
        for (int t = 0; t < T; t ++ ) {
            solve();
        }
        out.close();
    }

    static void debug(Object... O) {
        System.out.print("DEBUG ");
        System.out.println(Arrays.deepToString(O));
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextString() {
            return next();
        }
    }
}
