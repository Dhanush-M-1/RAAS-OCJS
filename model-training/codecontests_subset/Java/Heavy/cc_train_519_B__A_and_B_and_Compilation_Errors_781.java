import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AAndBAndCompilationErrors {
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t = fs.nextInt();
        long sum = 0;
        for(int i = 0; i < t; i++) {
            sum += fs.nextInt();
        }
        t--;
        long sum2 = 0;
        for(int i = 0; i < t; i++) {
            sum2 += fs.nextInt();
        }
        sb.append(sum - sum2);
        sb.append("\n");
        t--;
        sum = sum2;
        sum2 = 0;
        for(int i = 0; i < t; i++) {
            sum2 += fs.nextInt();
        }
        sb.append(sum - sum2);
        System.out.println(sb);
    }

    public static long div(long a, long b) {
        return (a + b - 1) / b;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
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

        float nextFloat() {
            return Float.parseFloat(next());
        }
    }
}
