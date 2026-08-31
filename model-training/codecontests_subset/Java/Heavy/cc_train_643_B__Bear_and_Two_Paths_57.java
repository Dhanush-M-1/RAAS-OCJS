

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_04 {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner();
        //BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = input.nextInt();
        int k = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();

        if (n == 4 || n + 1 > k) {
            System.out.println(-1);
            return;
        }

        System.out.printf("%d %d", a, c);
        for (int i = 1; i <=n; i++) {
            if (i != a && i!=b && i!=c && i!=d) {
                System.out.printf(" %d", i);
            }
        }
        System.out.printf(" %d %d\n", d, b);

        System.out.printf("%d %d", c, a);
        for (int i = 1; i <=n; i++) {
            if (i != a && i!=b && i!=c && i!=d) {
                System.out.printf(" %d", i);
            }
        }
        System.out.printf(" %d %d\n", b, d);
    }

    static class Scanner {
        final BufferedReader input;
        String[] buffer;
        int pos;


        public Scanner() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }


        private String read() {
            try {
                if (buffer == null || pos >= buffer.length) {
                    buffer = input.readLine().split("\\s+");
                    pos = 0;
                }
                return buffer[pos++];
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        long nextLong() {
            return Long.parseLong(read());
        }

        int nextInt() {
            return Integer.parseInt(read());
        }

        double nextDouble() {
            return Double.parseDouble(read());
        }

        String nextLine() {
            if (buffer != null && pos < buffer.length) {
                throw new RuntimeException("Buffer is not empty");
            }
            try {
                return input.readLine();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}