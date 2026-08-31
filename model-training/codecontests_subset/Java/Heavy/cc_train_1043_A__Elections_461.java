import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a {
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        int[] arr = new int[n];
        int sum1 = 0;
        int sum2 = 0;
        int max = 0;
        for (int i = 0; i < n; i ++){
            arr[i]=in.nextInt();
            sum1+=arr[i];
            if (arr[i]>max) max=arr[i];
        }
        int k = max;
        while (sum1>=sum2) {
            sum2 = 0;
            for (int i = 0; i < n; i++) {
                sum2+=k-arr[i];
            }
            if (sum1>=sum2) k ++;
        }
        System.out.println(k);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
