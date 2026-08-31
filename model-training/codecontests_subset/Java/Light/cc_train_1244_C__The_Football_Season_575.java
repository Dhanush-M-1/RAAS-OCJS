import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        long n = sc.nextLong();
        long p = sc.nextLong();
        long w = sc.nextLong();
        long d = sc.nextLong();
        for (int i = 0; i < w; i++) {
            if(p - i * d >= 0 && (p - i * d) % w == 0 && (p - i * d) / w + i <= n){
                pw.print((p - i * d) / w + " " + i + " " + (n - ((p - i * d) / w + i)));
                pw.close();
                return;
            }
        }
        pw.print(-1);
        pw.close();
    }
}

class FastScanner {
    static BufferedReader br;
    static StringTokenizer st = new StringTokenizer("");

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}