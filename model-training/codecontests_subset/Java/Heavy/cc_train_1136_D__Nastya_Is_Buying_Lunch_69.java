import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;

public class Solve4 {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        new Solve4().solve(pw);
        pw.flush();
        pw.close();
    }

    public void solve(PrintWriter pw) throws FileNotFoundException, IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt(), m = sc.nextInt();
        HashSet<Integer> p = new HashSet();
        HashSet<Integer>[] s = new HashSet[n + 1];
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            s[i] = new HashSet();
        }
        for (int i = 0; i < m; i++) {
            s[sc.nextInt()].add(sc.nextInt());
        }
        p.add(a[n]);
        int ans = 0;
        for (int i = n - 1; i > 0; i--) {
            Iterator<Integer> it = s[a[i]].iterator();
            int cnt = 0;
            while (it.hasNext()) {
                if (p.contains(it.next())) {
                    cnt++;
                }
            }
            if(cnt==p.size()) ans++;
            else p.add(a[i]);
        }
        pw.println(ans);
    }

    static public class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(System.in));

        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
