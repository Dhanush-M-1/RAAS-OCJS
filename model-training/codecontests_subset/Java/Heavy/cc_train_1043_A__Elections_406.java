import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int y[] = new int[n];
        int max = 0;
        int o = 0;
        for (int i = 0; i < n; i++) {
            y[i] = nextInt();
            o += y[i];
            if (y[i] > max) max = y[i];
        }
        int a = 0;
        for (int i = 0; i < n; i++) {
            a += (max - y[i]);
        }
        if (a > o) {
            pw.println(max);
            pw.close();
            return;
        }
        int div = o - a + 1;
        int need = (int) Math.ceil(div * 1.0 / n);
        pw.println(need + max);
        pw.close();
    }
    static StringTokenizer st;
    static BufferedReader sc;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(sc.readLine());
        }
        return st.nextToken();
    }
    static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
}