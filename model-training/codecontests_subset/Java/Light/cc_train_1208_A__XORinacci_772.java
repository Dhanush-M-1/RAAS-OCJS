import java.util.*;
import java.io.*;

public class Hello {
    static class FastReader {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        final int testcase = scan.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testcase; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int x = scan.nextInt();

            stringBuilder.append(solution(a, b, x)).append('\n');
        }
        System.out.println(stringBuilder);
    }

    public static int solution(final int a, final int b, final int x) {
        if (x % 3 == 2) {
            return a ^ b;
        } else if (x % 3 == 1) {
            return b;
        } else {
            return a;
        }
    }
}