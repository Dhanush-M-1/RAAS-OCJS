import java.util.*;
import java.io.*;

public class VC8FinalD {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    final long MOD = 1000L * 1000L * 1000L + 7;
    void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        int a = nextInt();
        int b = nextInt();
        int q = nextInt();

        long[] arr1 = new long[n];
        long[] arr2 = new long[n];
        BIT b1 = new BIT();
        b1.initPara(arr1);
        BIT b2 = new BIT();
        b2.initPara(arr2);
        long[] days = new long[1 + n];

        List<Long> res = new ArrayList<>();
        for(int i = 0; i < q; i++) {
            int tp = nextInt();
            if(tp == 1) {
                int day = nextInt();
                int val = nextInt();

                long v = Math.min(val, Math.max(0, b - days[day - 1]));
                b1.addValue(day - 1, v);
                v = Math.min(val, Math.max(0, a - days[day - 1]));
                b2.addValue(day - 1, v);

                days[day - 1] += val;
            }
            else {
                int p = nextInt();
                long sum = b1.sum(p - 2);
                sum += b2.sum(n - 1) - b2.sum(p + k - 2);
                res.add(sum);
            }

        }
        for(long v : res) {
            outln(v);
        }
    }
    public class BIT {
        private long[] fen;
        private int n;

        void initPara(long[] arr) {
            n = arr.length;
            fen = new long[1 + n];
        }

        void addValue(int p, long val) { //add val to tree node at p and all its parent, p is 0-based
            p++;
            for (int i = p; i <= n; i += i & -i)
                fen[i] += val;
        }

        void updateValue(int p, long val) { //update the current to val at p
            long diff = val - (sum(p) - sum(p - 1));
            addValue(p, diff);
        }

        long sum(int p) { //get sum between [0, p], p is 0-based
            long res = 0;
            p++;
            for (int i = p; i > 0; i -= i & -i)
                res += fen[i];
            return res;
        }
    }
    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    private void outln(Object o) {
        System.out.println(o);
    }
    private void out(Object o) {
        System.out.print(o);
    }
    public VC8FinalD() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new VC8FinalD();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
