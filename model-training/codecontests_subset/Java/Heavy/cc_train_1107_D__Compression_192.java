import java.util.*;
import java.io.*;

public class D {
    static boolean[][] arr;
    static boolean[] checked;
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int N = scanner.nextInt();
        arr = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            char[] nextLine = scanner.next().toCharArray();
            for(int j = 0; j < N/4; j++) {
                int num = Integer.parseInt(Character.toString(nextLine[j]), 16);
                for(int k = 0; k < 4; k++) {
                    arr[i][(j*4)+3-k] = (num&(1<<k)) > 0;
                }
            }
        }
        boolean[] row = new boolean[N];
        boolean[] col = new boolean[N];
        for(int i = 1; i < N; i++) {
            col[i] = true;
            for(int j = 0; j < N; j++) {
                if (arr[i][j] != arr[i-1][j]) {
                    col[i] = false;
                    break;
                }
            }
        }
        for(int j = 1; j < N; j++) {
            row[j] = true;
            for(int i = 0; i < N; i++) {
                if (arr[i][j] != arr[i][j-1]) {
                    row[j] = false;
                    break;
                }
            }
        }
        int ans = 1;
        for(int i = 1; i <= N; i++) {
            if (N%i!=0) continue;
            boolean bad = false;
            for(int j = 0; !bad && j < N; j++) {
                if (j%i!=0 && (!col[j] || !row[j])) {
                    bad = true;
                    continue;
                }
            }
            if (!bad) {
                ans = i;
            }
        }
        out.println(ans);
        out.flush();
    }
    public static class FastScanner {
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

        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
    }
}
