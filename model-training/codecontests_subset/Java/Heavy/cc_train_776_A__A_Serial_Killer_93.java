import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {

    static long mod = 1000000007L;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String[] s = {scanner.nextToken(), scanner.nextToken()};
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(s[0]).append(" ").append(s[1]).append("\n");
        for (int i = 0; i < n; i++) {
            String killed = scanner.nextToken();
            String ne = scanner.nextToken();
            if (s[0].equals(killed)) {
                s[0] = ne;
            } else {
                s[1] = ne;
            }
            sb.append(s[0]).append(" ").append(s[1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}

/*

1 1 1
1 1 2
1 2 1
2 1 1
1 1 3

*/