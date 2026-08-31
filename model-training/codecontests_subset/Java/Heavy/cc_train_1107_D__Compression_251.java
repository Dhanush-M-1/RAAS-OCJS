import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = 1;
        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Task {
        int n;
        int[][] board;
        int[][] prefix;

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            n = scan.nextInt();
            board = new int[n][n];
            prefix = new int[n][n];
            for(int i = 0; i < n; i++) {
                String input = scan.next();
                int index = 0;
                for(int j = 0; j * 4 < n; j++) {
                    int curr = Integer.parseInt(input.substring(j, j + 1), 16);
                    for(int k = 0; k < 4; k++) board[i][index++] = (curr & (1 << (4 - k - 1))) > 0 ? 1 : 0;
                }
            }
            for(int i = 0; i < n; i++) {
                prefix[i][0] = board[i][0];
                prefix[0][i] = board[0][i];
                if(i > 0) {
                    prefix[i][0] += prefix[i - 1][0];
                    prefix[0][i] += prefix[0][i - 1];
                }
            }
            for(int i = 1; i < n; i++) {
                for(int j = 1; j < n; j++) {
                    prefix[i][j] = board[i][j];
                    prefix[i][j] += prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
                }
            }
            int ans = 0;
            for(int i = 1; i * i <= n; i++) {
                if(n % i == 0) {
                    if(works(i)) ans = Math.max(ans, i);
                    if(works(n / i)) ans = Math.max(ans, n / i);
                }
            }
            out.println(ans);
        }

        public int rectSum(int a, int b, int aa, int bb) {
            int leftRectangle = b == 0 ? 0 : prefix[aa][b - 1];
            int topRectangle = a == 0 ? 0 : prefix[a - 1][bb];
            int cornerRectangle = a == 0 || b == 0 ? 0 : prefix[a - 1][b - 1];
            return prefix[aa][bb] - leftRectangle - topRectangle + cornerRectangle;
        }

        public boolean works(int size) {
            for(int i = 0; i < n; i += size) {
                for(int j = 0; j < n; j += size) {
                    int currSum = rectSum(i, j, i + size - 1, j + size - 1);
                    if(currSum != 0 && currSum != size * size) return false;
                }
            }
            return true;
        }
    }

    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
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