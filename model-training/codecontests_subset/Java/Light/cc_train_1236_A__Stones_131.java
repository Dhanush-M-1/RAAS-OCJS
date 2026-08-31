import java.io.*;
import java.util.*;

public class JavaLessons {

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            int x = Math.min(a, b / 2);
            long first = (long) x * 3 + (Math.min(b - 2 * x, c / 2)) * 3;
            int y = Math.min(b, c / 2);
            long second = (long) y * 3 + Math.min((b - y) / 2, a) * 3;
            out.println(Math.max(first, second));
        }

        out.close();
    }

    static BufferedReader br;
    static StringTokenizer st = new StringTokenizer("");
    static PrintWriter out;

    static String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

}
