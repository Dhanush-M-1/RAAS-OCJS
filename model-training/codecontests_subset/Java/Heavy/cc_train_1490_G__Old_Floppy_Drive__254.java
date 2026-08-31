import java.io.*;
import java.util.*;

public class D {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = scan.nextInt();
        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            int n = scan.nextInt(), m = scan.nextInt();
            long[] a = new long[n];
            long[] prefix = new long[n];
            for(int i = 0; i < n; i++) {
                prefix[i] = a[i] = scan.nextLong();
                if(i > 0) prefix[i] += prefix[i - 1];
            }
            TreeMap<Long, Integer> initial = new TreeMap<>();
            for(int i = 0; i < n; i++) {
                if(initial.isEmpty() || prefix[i] > initial.lastKey()) {
                    initial.put(prefix[i], i);
                }
            }
            for(int i = 0; i < m; i++) {
                long x = scan.nextLong();
                Long checkInitial = initial.ceilingKey(x);
                if(checkInitial != null) out.printf("%d ", initial.get(checkInitial));
                else if(prefix[n - 1] <= 0) out.print("-1 ");
                else {
                    long leftOver = x - initial.lastKey();
                    long cycleCount = (leftOver + prefix[n - 1] - 1) / prefix[n - 1];
                    long need = x - cycleCount * prefix[n - 1];
                    out.printf("%d ", cycleCount * n + initial.get(initial.ceilingKey(need)));
                }
            }
            out.println();
        }
    }

    static void ruffleSort(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        Arrays.sort(a);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}