
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int tt = sc.nextInt();
        while(tt-- > 0){
            int n = sc.nextInt();
            int[] arr = sc.readArray(n);

            if(arr[0] + arr[1] <= arr[n - 1]){
                System.out.println("1 2 " + n);
            }else
                System.out.println(-1);

        }
    }

    private static class FastReader {
        private BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        int[] readArray(int n){
            int[] arr = new int[n];
            for(int i = 0; i < n; ++i)
                arr[i] = nextInt();

            return arr;
        }
        long[] readLongArray(int n){
            long[] arr = new long[n];
            for(int i = 0; i < n; ++i)
                arr[i] = nextLong();

            return arr;
        }

        double[] readDoubleArray(int n){
            double[] arr = new double[n];
            for(int i = 0; i < n; ++i)
                arr[i] = nextDouble();
            return arr;
        }
    }
}
