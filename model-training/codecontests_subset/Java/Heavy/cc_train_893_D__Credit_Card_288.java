import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    public static long mod = 17352642619633L;

    void run(FastScanner in, PrintWriter out) {

        int N = in.nextInt();
        long D = in.nextInt();

        long[] a = new long[N];
        for (int i = 0; i < N; i++) a[i] = in.nextLong();

        long[] bal = new long[N];
        long b = 0;
        for (int i = 0; i < N; i++) {
            b += a[i];
            bal[i] = b;
        }

        MaxStack ms = new MaxStack();
        for (int i = N-1; i >= 0; i--) {
            ms.add(bal[i]);
        }

        if (ms.max() > D) {
            out.println("-1");
            return;
        }

        int ret = 0;
        int delta = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] == 0) {
                if (bal[i] + delta < 0) {
                    // how much can we add
                    long canadd = D - (ms.max()+delta);
                    if (canadd < 0 || bal[i] + canadd + delta < 0) {
                        out.println("-1");
                        return;
                    }
                    delta += canadd;
                    ret++;
                }
            }
            ms.pop(bal[i]);
        }

        out.println(ret);
    }


    class MaxStack {
        LinkedList<Long> ll = new LinkedList<>();
        void add(long x) {
            if (ll.isEmpty() || x >= ll.peekLast()) {
                ll.offerLast(x);
            }
        }

        void pop(long x) {
            if (ll.peekLast() == x) ll.pollLast();
        }

        long max() {
            return ll.peekLast();
        }

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
