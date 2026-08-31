import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D1 {

    private void solve() {

        Map<Integer,Integer> map = new HashMap<>();

        int N = IO.nextInt();
        for(int i=0; i<N-1; i++)
        {
            int a = IO.nextInt();
            int b = IO.nextInt();

            map.put(a, 1 + map.getOrDefault(a, 0));
            map.put(b, 1 + map.getOrDefault(b, 0));
        }
        System.out.println(map.containsValue(2) ? "NO" : "YES");
    }

    //*************
    //*************
    //TEMPLATE CODE

    static long MOD = 0;

    public static void main(String[] args) {
        D1 instance = new D1();
        int testcases = 1;//IO.nextInt();
        while(testcases-->0)
            instance.solve();
    }

    static class IO {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st;

        static String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        static int[] nextIntArray(int size) {
            int a[] = new int[size];
            for (int i = 0; i < size; i++)
                a[i] = nextInt();
            return a;
        }

        static long[] nextLongArray(int size) {
            long a[] = new long[size];
            for (int i = 0; i < size; i++)
                a[i] = nextLong();
            return a;
        }

        static double[] nextDoubleArray(int size) {
            double a[] = new double[size];
            for (int i = 0; i < size; i++)
                a[i] = nextDouble();
            return a;
        }
    }
}