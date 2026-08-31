import java.io.*;
import java.util.StringTokenizer;

public class C {

    static int find(int i, int[] nxt) { return nxt[i] = i == nxt[i] ? i : find(nxt[i], nxt); }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        long[] base = new long[n + 1];
        long s = 0;
        int[] nxt = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            base[i] = s;
            s += i;
            nxt[i] = i;
        }
        long[] a = new long[n];
        for(int i = 0; i < n; ++i) {
            a[i] = sc.nextLong();
        }
        FenwickTree ft = new FenwickTree(n);
        int[] ans = new int[n];
        for(int i = n - 1; i >= 0; --i) {
            int res = -1, lo = 1, hi = n;
            while(lo <= hi) {
                int mid = (lo + hi) / 2;
                long t = base[mid] - ft.query(mid);
                if (t >= a[i]) {
                    res = mid;
                    hi = mid - 1;
                } else
                    lo = mid + 1;
            }
            ans[i] = find(res, nxt);
            ft.update(ans[i] + 1, ans[i]);
            nxt[ans[i]]++;
        }
        for(int x: ans)
            out.print(x + " ");
        out.close();
    }

    static class FenwickTree {
        long[] ft;

        FenwickTree(int n) { ft = new long[n + 2]; }

        void update(int l, int v) {
            while(l < ft.length) {
                ft[l] += v;
                l += l & -l;
            }
        }

        long query(int i) {
            long s = 0;
            while(i > 0) {
                s += ft[i];
                i ^= i & -i;
            }
            return s;
        }
    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public boolean ready() throws IOException {return br.ready();}


    }
}