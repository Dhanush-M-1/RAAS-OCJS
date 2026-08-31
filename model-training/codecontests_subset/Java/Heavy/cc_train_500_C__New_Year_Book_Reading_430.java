import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Greg on 2015/9/16.
 */
public class NewYearBookReading_500C {
    private static void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int n = nextInt();
        int m = nextInt();
        int[] w = new int[n+1];
        int[] t = new int[m+1];
        for (int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }
        int sumW = 0;
        ArrayList<Integer> s = new ArrayList<Integer>();
        for (int i = 1; i <= m; i++) {
            int b = nextInt();
            int j = 0;
            for ( ; j < s.size(); j++) {
                int b1 = s.get(j);
                if (b1 != b) {
                    sumW += w[b1];
                } else {
                    s.remove(j);
                    s.add(0, b1);
                    break;
                }
            }
            if (j==s.size()) {
                s.add(0,b);
            }
        }
        out.println(sumW);
        out.close();
    }

    private static StringTokenizer st;
    private static BufferedReader br;
    private static PrintWriter out;

    private static String next() {
        while (st == null || !st.hasMoreElements()) {
            String s;
            try {
                s = br.readLine();
            } catch (IOException e) {
                return null;
            }
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }

    private static long nextLong() {
        return Long.parseLong(next());
    }

    public static void main(String[] args) {
        run();
    }
}
