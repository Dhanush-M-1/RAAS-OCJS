
import java.io.*;
import java.util.*;


public class D {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
            this(new InputStreamReader(System.in));
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

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        int me = p[n - 1];

        HashMap<Integer, HashSet<Integer>> pairs = new HashMap<>();
        for (int j = 0; j < m; j++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            if (!pairs.containsKey(l)) {
                pairs.put(l, new HashSet<Integer>());
            }
            pairs.get(l).add(r);
        }

        for (int i = n - 1; i >= 0; i--) {
            int ptr = i;
            while (ptr < n - 1 && pairs.getOrDefault(p[ptr], new HashSet<>()).contains(p[ptr + 1])) {
                int tmp = p[ptr];
                p[ptr] = p[ptr + 1];
                p[ptr + 1] = tmp;
                ptr++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (p[i] == me) {
                System.out.println(n - i - 1);
                break;
            }
        }
    }
}