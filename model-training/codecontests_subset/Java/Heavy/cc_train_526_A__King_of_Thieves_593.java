
import java.util.*;
import java.io.*;

public class p1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter ps = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main (String[] args) throws IOException {
        int n = readInt();
        boolean good = false;
        char[] in = readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            if (in[i] == '.')
                continue;
            for (int d = 1; d < n; d++) {
                int c;
                for (c = 1; i + d*c < n && in[i + d*c] == '*'; c++);
                c--;
                if (c >= 4) {
//                  System.out.println(i + " " + d + " " + c);
                    good = true;
                }
            }
        }
        if (good)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong () throws IOException {
        return Long.parseLong(next());
    }

    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter () throws IOException {
        return next().charAt(0);
    }

    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
