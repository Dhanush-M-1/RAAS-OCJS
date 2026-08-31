import java.util.*;
import java.io.*;

public class ReachMedian {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        Arrays.sort(arr);
        long out = 0L;
        int cur = N/2;
        if (arr[cur] < S) {
            while(cur < N && arr[cur] < S) out += (long)(S-arr[cur++]);
        }
        else if (arr[cur] > S) {
            while(cur >= 0 && arr[cur] > S) out += (long)(arr[cur--]-S);
        }
        System.out.println(out);
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
