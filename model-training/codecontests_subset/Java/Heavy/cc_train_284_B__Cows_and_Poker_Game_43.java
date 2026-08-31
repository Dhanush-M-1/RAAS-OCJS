
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_CowsAndPokerGame {

    static BufferedReader in;
    static StringTokenizer st;
    static PrintWriter out;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                System.out)));
        int n = nextInt();
        String s = next();
        int allin = 0, folded = 0, in = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                allin++;
            }
            if (s.charAt(i) == 'F') {
                folded++;
            }
            if (s.charAt(i) == 'I') {
                in++;
            }
        }
        if (allin + folded == n) {
            out.print(allin);
        } else {
            if (in == 1) {
                out.print(1);
            } else {
                out.print(0);
            }
        }
        out.close();
    }

}
