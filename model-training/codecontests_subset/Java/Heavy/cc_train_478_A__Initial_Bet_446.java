
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InitialBet {
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = fs.nextInt();
            sum += arr[i];
        }
        if(sum % 5 != 0 || sum / 5 == 0) sb.append(-1);
        else sb.append(sum / 5); 
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
