import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Codefest18B {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] nums = sc.readLongArray(n);
        Arrays.sort(nums);
        int medianIndex = n/2;
        long diff = 0L;
        for (int i = 0; i < n; i++) {
            if ((i < medianIndex && nums[i] > k) ||
                    (i > medianIndex && nums[i] < k) ||
                    (i == medianIndex)) {
                diff += abs(nums[i] - k);
            }
        }
        sb.append(diff);


        System.out.print(sb);
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

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}
