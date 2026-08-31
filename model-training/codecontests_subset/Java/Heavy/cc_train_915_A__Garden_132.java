import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int k = nextInt();
        int y[] = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (k % y[i] == 0 && y[i] > max) {
                max = y[i];
            }
        }
        pw.println(k / max);
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