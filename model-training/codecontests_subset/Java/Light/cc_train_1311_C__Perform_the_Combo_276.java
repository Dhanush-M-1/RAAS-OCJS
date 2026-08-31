import java.util.*;
import java.io.PrintWriter;

public class ProC {
    static Scanner in=new Scanner(System.in);
    static PrintWriter out=new PrintWriter(System.out);
    static int[] pos;
    static int[] fct;
    static int[] tct;
    public static void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt(), m = in.nextInt();
            String s = in.next();
            pos = new int[n];
            tct = new int[n];
            fct = new int[26];
            Arrays.fill(tct,1);
            for (int i = 0; i < m; ++i) {
                int k = in.nextInt();
                pos[k-1]++;
            }
            int kc = 0;
            for (int i = n - 1; i >= 0; --i) {
                kc+= pos[i];
                tct[i] += kc;
                fct[s.charAt(i)-'a']+=tct[i];
            }
            for (int i = 0; i < 26; ++i) out.print(fct[i] + " ");
            out.println();
        }
        out.flush();
    }

    public static void main(String[] args) {
            solve(0, in, out);
    }
}
